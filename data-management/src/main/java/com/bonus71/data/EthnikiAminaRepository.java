package com.bonus71.data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EthnikiAminaRepository {

    public List<EthnikiAmina> findAll() {
        List<EthnikiAmina> list = new ArrayList<>();

        String sql = "SELECT * FROM \"ΥΠΟΥΡΓΕΙΟ ΕΘΝΙΚΗΣ ΑΜΥΝΑΣ\"";

        try (Connection conn = DatabaseH2M.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new EthnikiAmina(
                        rs.getInt("ΜΕΙΖΟΝΑ ΚΑΤΗΓΟΡΙΑ"),
                        rs.getString("ΟΝΟΜΑΣΙΑ"),
                        rs.getString("ΕΥΡΩ")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    public void insert(EthnikiAmina a) {
        String sql = "INSERT INTO \"ΥΠΟΥΡΓΕΙΟ ΕΘΝΙΚΗΣ ΑΜΥΝΑΣ\" VALUES (?, ?, ?)";

        try (Connection conn = DatabaseH2M.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, a.getMeizona());
            ps.setString(2, a.getOnomasia());
            ps.setString(3, a.getEvro());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void update(EthnikiAmina a) {
        String sql = "UPDATE \"ΥΠΟΥΡΓΕΙΟ ΕΘΝΙΚΗΣ ΑΜΥΝΑΣ\" " +
                "SET ΟΝΟΜΑΣΙΑ=?, ΕΥΡΩ=? WHERE \"ΜΕΙΖΟΝΑ ΚΑΤΗΓΟΡΙΑ\"=?";

        try (Connection conn = DatabaseH2M.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, a.getOnomasia());
            ps.setString(2, a.getEvro());
            ps.setInt(3, a.getMeizona());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void delete(int meizona) {
        String sql = "DELETE FROM \"ΥΠΟΥΡΓΕΙΟ ΕΘΝΙΚΗΣ ΑΜΥΝΑΣ\" WHERE \"ΜΕΙΖΟΝΑ ΚΑΤΗΓΟΡΙΑ\"=?";

        try (Connection conn = DatabaseH2M.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, meizona);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

