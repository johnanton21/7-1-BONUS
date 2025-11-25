package com.bonus71.data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaideiasRepository {

    public List<Paideias> findAll() {
        List<Paideias> list = new ArrayList<>();
        String sql = "SELECT * FROM \"ΥΠΟΥΡΓΕΙΟ ΠΑΙΔΕΙΑΣ\"";

        try (Connection conn = DatabaseH2M.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Paideias(
                        rs.getInt("ΜΕΙΖΟΝΑ ΚΑΤΗΓΟΡΙΑ"),
                        rs.getString("ΟΝΟΜΑΣΙΑ"),
                        rs.getString("ΕΥΡΩ")
                ));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    public void insert(Paideias p) {
        String sql = "INSERT INTO \"ΥΠΟΥΡΓΕΙΟ ΠΑΙΔΕΙΑΣ\" VALUES (?, ?, ?)";

        try (Connection conn = DatabaseH2M.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, p.getMeizona());
            ps.setString(2, p.getOnomasia());
            ps.setString(3, p.getEvro());
            ps.executeUpdate();

        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void update(Paideias p) {
        String sql = "UPDATE \"ΥΠΟΥΡΓΕΙΟ ΠΑΙΔΕΙΑΣ\" SET ΟΝΟΜΑΣΙΑ=?, ΕΥΡΩ=? WHERE \"ΜΕΙΖΟΝΑ ΚΑΤΗΓΟΡΙΑ\"=?";

        try (Connection conn = DatabaseH2M.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, p.getOnomasia());
            ps.setString(2, p.getEvro());
            ps.setInt(3, p.getMeizona());
            ps.executeUpdate();

        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void delete(int meizona) {
        String sql = "DELETE FROM \"ΥΠΟΥΡΓΕΙΟ ΠΑΙΔΕΙΑΣ\" WHERE \"ΜΕΙΖΟΝΑ ΚΑΤΗΓΟΡΙΑ\"=?";

        try (Connection conn = DatabaseH2M.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, meizona);
            ps.executeUpdate();

        } catch (SQLException e) { e.printStackTrace(); }
    }
}


