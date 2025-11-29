package com.bonus71.data.repository;
import com.bonus71.data.config.DatabaseConfig;
import com.bonus71.data.entity.Comparison.YearsComparison;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class YearsComparisonRepository {

    private static final String SELECT_BY_YEAR =
            "SELECT YEAR, NET_REVENUES, EXPENSES, BALANCE FROM COMPARISON WHERE YEAR = ?";

    public YearsComparison findByYear(int year) throws SQLException {
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_BY_YEAR)) {

            ps.setInt(1, year);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new YearsComparison(
                            rs.getInt("YEAR"),
                            rs.getString("NET_REVENUES"),
                            rs.getString("EXPENSES"),
                            rs.getString("BALANCE")
                    );
                } else {
                    return null;
                }
            }
        }
    }
}
