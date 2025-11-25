package com.bonus71.data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OikonomikonRepository {

    public List<Oikonomikon> findAll() {
        List<Oikonomikon> list = new ArrayList<>();

        String sql = "SELECT * FROM \"ΥΠΟΥΡΓΕΙΟ ΟΙΚΟΝΟΜΙΚΩΝ\"";

        try (Connection conn = DatabaseH2M.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Oikonomikon(
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


    public void insert(Oikonomikon o) {
        String sql = "INSERT INTO \"ΥΠΟΥΡΓΕΙΟ ΟΙΚΟΝΟΜΙΚΩΝ\" VALUES (?, ?, ?)";

        try (Connection conn = DatabaseH2M.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, o.getMeizona());
            ps.setString(2, o.getOnomasia());
            ps.setString(3, o.getEvro());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void update(Oikonomikon o) {
        String sql = "UPDATE \"ΥΠΟΥΡΓΕΙΟ ΟΙΚΟΝΟΜΙΚΩΝ\" " +
                "SET ΟΝΟΜΑΣΙΑ=?, ΕΥΡΩ=? WHERE \"ΜΕΙΖΟΝΑ ΚΑΤΗΓΟΡΙΑ\"=?";

        try (Connection conn = DatabaseH2M.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, o.getOnomasia());
            ps.setString(2, o.getEvro());
            ps.setInt(3, o.getMeizona());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void delete(int meizona) {
        String sql = "DELETE FROM \"ΥΠΟΥΡΓΕΙΟ ΟΙΚΟΝΟΜΙΚΩΝ\" WHERE \"ΜΕΙΖΟΝΑ ΚΑΤΗΓΟΡΙΑ\"=?";

        try (Connection conn = DatabaseH2M.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, meizona);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

