package com.bonus71.data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EsodaRepository {

    public List<Esoda> findAll() {
        List<Esoda> list = new ArrayList<>();

        String sql = "SELECT * FROM ΕΣΟΔΑ";

        try (Connection conn = DatabaseH2M.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Esoda(
                        rs.getInt("ΚΩΔΙΚΟΣΕΣΟΔΟΥ"),
                        rs.getString("ΚΑΤΗΓΟΡΙΑ"),
                        rs.getString("ΕΥΡΩ")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public void insert(Esoda es) {
        String sql = "INSERT INTO ΕΣΟΔΑ VALUES (?, ?, ?)";

        try (Connection conn = DatabaseH2M.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, es.getKodikos());
            ps.setString(2, es.getKatigoria());
            ps.setString(3, es.getEvro());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Esoda es) {
        String sql = "UPDATE ΕΣΟΔΑ SET ΚΑΤΗΓΟΡΙΑ=?, ΕΥΡΩ=? WHERE ΚΩΔΙΚΟΣΕΣΟΔΟΥ=?";

        try (Connection conn = DatabaseH2M.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, es.getKatigoria());
            ps.setString(2, es.getEvro());
            ps.setInt(3, es.getKodikos());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int kodikos) {
        String sql = "DELETE FROM ΕΣΟΔΑ WHERE ΚΩΔΙΚΟΣΕΣΟΔΟΥ=?";

        try (Connection conn = DatabaseH2M.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, kodikos);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

