 package com.bonus71.data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Exoda2Repository {

    public List<Exoda2> findAll() {
        List<Exoda2> list = new ArrayList<>();

        String sql = "SELECT * FROM \"ΕΞΟΔΑ ΑΡΘΡΟΥ 2\"";

        try (Connection conn = DatabaseH2M.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Exoda2(
                        rs.getInt("ΚΩΔΙΚΟΣ"),
                        rs.getString("ΤΜΗΜΑ"),
                        rs.getString("ΤΑΚΤΙΚΟΣ ΠΡΟΫΠΟΛΟΓΙΣΜΟΣ"),
                        rs.getString("ΠΡΟΫΠΟΛΟΓΙΣΜΟΣ ΔΗΜΟΣΙΩΝ ΕΠΕΝΔΥΣΕΩΝ"),
                        rs.getString("ΣΥΝΟΛΟ")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public void insert(Exoda2 ex) {
        String sql = "INSERT INTO \"ΕΞΟΔΑ ΑΡΘΡΟΥ 2\" VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseH2M.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, ex.getKodikos());
            ps.setString(2, ex.getTmima());
            ps.setString(3, ex.getTaktikosProypologismos());
            ps.setString(4, ex.getProypologismosDimosionEpendyseon());
            ps.setString(5, ex.getSynolo());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Exoda2 ex) {
        String sql = "UPDATE \"ΕΞΟΔΑ ΑΡΘΡΟΥ 2\" " +
                "SET ΤΜΗΜΑ=?, " +
                "\"ΤΑΚΤΙΚΟΣ ΠΡΟΫΠΟΛΟΓΙΣΜΟΣ\"=?, " +
                "\"ΠΡΟΫΠΟΛΟΓΙΣΜΟΣ ΔΗΜΟΣΙΩΝ ΕΠΕΝΔΥΣΕΩΝ\"=?, " +
                "ΣΥΝΟΛΟ=? " +
                "WHERE ΚΩΔΙΚΟΣ=?";

        try (Connection conn = DatabaseH2M.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, ex.getTmima());
            ps.setString(2, ex.getTaktikosProypologismos());
            ps.setString(3, ex.getProypologismosDimosionEpendyseon());
            ps.setString(4, ex.getSynolo());
            ps.setInt(5, ex.getKodikos());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int kodikos) {
        String sql = "DELETE FROM \"ΕΞΟΔΑ ΑΡΘΡΟΥ 2\" WHERE ΚΩΔΙΚΟΣ=?";

        try (Connection conn = DatabaseH2M.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, kodikos);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

