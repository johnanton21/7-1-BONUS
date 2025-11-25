package com.bonus71.data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

    public class YgeiasRepository {

        public List<Ygeias> findAll() {
            List<Ygeias> list = new ArrayList<>();

            String sql = "SELECT * FROM \"ΥΠΟΥΡΓΕΙΟ ΥΓΕΙΑΣ\"";

            try (Connection conn = DatabaseH2M.getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    list.add(new Ygeias(
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


        public void insert(Ygeias y) {
            String sql = "INSERT INTO \"ΥΠΟΥΡΓΕΙΟ ΥΓΕΙΑΣ\" VALUES (?, ?, ?)";

            try (Connection conn = DatabaseH2M.getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setInt(1, y.getMeizona());
                ps.setString(2, y.getOnomasia());
                ps.setString(3, y.getEvro());

                ps.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        public void update(Ygeias y) {
            String sql = "UPDATE \"ΥΠΟΥΡΓΕΙΟ ΥΓΕΙΑΣ\" " +
                    "SET ΟΝΟΜΑΣΙΑ=?, ΕΥΡΩ=? WHERE \"ΜΕΙΖΟΝΑ ΚΑΤΗΓΟΡΙΑ\"=?";

            try (Connection conn = DatabaseH2M.getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, y.getOnomasia());
                ps.setString(2, y.getEvro());
                ps.setInt(3, y.getMeizona());

                ps.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        public void delete(int meizona) {
            String sql = "DELETE FROM \"ΥΠΟΥΡΓΕΙΟ ΥΓΕΙΑΣ\" WHERE \"ΜΕΙΖΟΝΑ ΚΑΤΗΓΟΡΙΑ\"=?";

            try (Connection conn = DatabaseH2M.getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setInt(1, meizona);
                ps.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


