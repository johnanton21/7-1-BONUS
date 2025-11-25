package com.bonus71.data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

 public class ExodaRepository {

        // SELECT ALL
        public List<Exodo> findAll() {
            List<Exodo> list = new ArrayList<>();
            String sql = "SELECT * FROM ΕΞΟΔΑ";

            try (Connection conn = DatabaseH2M.getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    list.add(new Exodo(
                            rs.getInt("KΩΔΙΚΟΣΕΞΟΔΟΥ"),
                            rs.getString("ΚΑΤΗΓΟΡΙΑ"),
                            rs.getString("ΕΥΡΩ")
                    ));
                }
            } catch (SQLException e) { e.printStackTrace(); }

            return list;
        }

        // INSERT
        public void insert(Exodo e) {
            String sql = "INSERT INTO ΕΞΟΔΑ VALUES (?, ?, ?)";

            try (Connection conn = DatabaseH2M.getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setInt(1, e.getKodikos());
                ps.setString(2, e.getKatigoria());
                ps.setString(3, e.getEvro());
                ps.executeUpdate();

            } catch (SQLException e1) { e1.printStackTrace(); }
        }

        // UPDATE
        public void update(Exodo e) {
            String sql = "UPDATE ΕΞΟΔΑ SET ΚΑΤΗΓΟΡΙΑ=?, ΕΥΡΩ=? WHERE KΩΔΙΚΟΣΕΞΟΔΟΥ=?";

            try (Connection conn = DatabaseH2M.getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, e.getKatigoria());
                ps.setString(2, e.getEvro());
                ps.setInt(3, e.getKodikos());
                ps.executeUpdate();

            } catch (SQLException e1) { e1.printStackTrace(); }
        }

        // DELETE
        public void delete(int kodikos) {
            String sql = "DELETE FROM ΕΞΟΔΑ WHERE KΩΔΙΚΟΣΕΞΟΔΟΥ=?";

            try (Connection conn = DatabaseH2M.getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setInt(1, kodikos);
                ps.executeUpdate();

            } catch (SQLException e1) { e1.printStackTrace(); }
        }
    }





