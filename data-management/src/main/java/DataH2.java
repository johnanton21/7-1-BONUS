import java.sql.*;
public class DataH2 {
        public static void main(String[] args) {
            // Το αρχείο  βρίσκεται στο ~/Downloads/esoda.mv.db
            // Άρα το path σύνδεσης είναι:
            String jdbcURL = "jdbc:h2:/Users/alikistamatelatou/Downloads/esoda";
            String username = "sa";
            String password = "";

            try (Connection conn = DriverManager.getConnection(jdbcURL, username, password)) {
                System.out.println(" Συνδέθηκε στη βάση esoda!");

                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM esoda");

                while (rs.next()) {
                    String kodikos = rs.getString("Κωδικός εσόδου");
                    String kathgoria = rs.getString("Κατηγορία");
                    String euro = rs.getString("Ευρώ");

                    System.out.println(kodikos + " | " + kathgoria + " | " + euro);
                }

                rs.close();
                stmt.close();
            } catch (SQLException e) {
                System.err.println("Σφάλμα σύνδεσης ή εκτέλεσης: " + e.getMessage());
            }
        }
    }

