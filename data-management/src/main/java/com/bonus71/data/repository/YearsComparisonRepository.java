package com.bonus71.data.repository;

import com.bonus71.data.config.DatabaseConfig;
import com.bonus71.data.entity.Comparison.YearsComparison;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Repository class responsible for retrieving {@link YearsComparison} data
 * from the database.
 * <p>
 * Provides methods to query year-by-year financial comparison data
 * from the {@code COMPARISON} table. Encapsulates SQL execution and
 * result mapping, keeping database access logic separate from
 * business logic.
 * </p>
 *
 * <p>
 * Database connections are managed through {@link DatabaseConfig}, and
 * prepared statements are used to prevent SQL injection and ensure
 * efficient query execution.
 * </p>
 */

public class YearsComparisonRepository {

    private static final String SELECT_BY_YEAR =
            "SELECT YEAR, NET_REVENUES, EXPENSES, BALANCE FROM COMPARISON WHERE YEAR = ?";

    /**
     * Retrieves a {@link YearsComparison} record for the specified year.
     *
     * <p>
     * Executes a {@code SELECT} query with the given {@code year} parameter
     * and maps the result to a {@link YearsComparison} entity. Returns {@code null}
     * if no record exists for the given year.
     * </p>
     *
     * @param year the year for which the comparison data should be retrieved
     * @return a {@link YearsComparison} object representing the year's data,
     *         or {@code null} if no record is found
     * @throws SQLException if a database access error occurs
     */
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