import java.sql.*;
public class DataH2 {
        public static void main(String[] args) {
            // Το αρχείο  βρίσκεται στο ~/Downloads/esoda.mv.db
            // Άρα το path σύνδεσης είναι:
            String jdbcURL = "jdbc:h2:~/test";
            String username = "sa";
            String password = "";

            String[] tables = {"esoda", "oikonomikon", "EthnikiAmina", "Ygeias"};
            try (Connection conn = DriverManager.getConnection(jdbcURL, username, password)) {
                System.out.println(" Συνδέθηκε στη βάση ");
                Statement stmt = conn.createStatement();
                for (String table : tables) {
                    System.out.println(" Περιεχόμενα πίνακα: " + table + " ");
                    try (ResultSet rs = stmt.executeQuery("SELECT * FROM " + table)) {
                        ResultSetMetaData meta = rs.getMetaData();
                        int columns = meta.getColumnCount();
                        while (rs.next()) {
                            for (int i = 1; i <= columns; i++) {
                                System.out.print(rs.getString(i));
                                if (i < columns) System.out.print(" | ");
                            }
                            System.out.println();
                        }
                    } catch (SQLException e) {
                        System.err.println(" Δεν ήταν δυνατή η ανάγνωση του πίνακα " + table + ": " + e.getMessage());
                    }
                    System.out.println();
                }

                stmt.close();
            } catch (SQLException e) {
                System.err.println(" Σφάλμα σύνδεσης ή εκτέλεσης: " + e.getMessage());
            }
        }
}