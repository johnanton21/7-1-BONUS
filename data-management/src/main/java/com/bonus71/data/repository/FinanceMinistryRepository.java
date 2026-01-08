package com.bonus71.data.repository;

import com.bonus71.data.config.DatabaseConfig;
import com.bonus71.data.entity.ministry.FinanceMinistry;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * Repository class responsible for data access operations related to
 * {@link FinanceMinistry} entities.
 * <p>
 * Provides CRUD (Create, Read, Update, Delete) functionality for the
 * {@code FINANCE_MINISTRY} database table using JDBC. Encapsulates SQL
 * execution and result mapping, ensuring separation of persistence
 * and business logic layers.
 * </p>
 *
 * <p>
 * Database connections are managed through {@link DatabaseConfig}, and
 * prepared statements are used to ensure security and efficiency.
 * </p>
 */
public class FinanceMinistryRepository {
    /**
     * Retrieves all finance ministry records from the database.
     *
     * <p>
     * Executes a {@code SELECT * FROM FINANCE_MINISTRY} query and maps each
     * result row to a {@link FinanceMinistry} entity.
     * </p>
     *
     * @return a list containing all {@link FinanceMinistry} records found
     * @throws SQLException if a database access error occurs
     */
  public List<FinanceMinistry> findAll() throws SQLException {
    List<FinanceMinistry> list = new ArrayList<>();
    String sql = "SELECT * FROM FINANCE_MINISTRY";

    try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

      while (rs.next()) {
        list.add(new FinanceMinistry(
                        rs.getInt("MAJOR_CATEGORY"),
                        rs.getString("NAME"),
                        rs.getString("EUROS")
                ));
      }
    }

    return list;
  }
    /**
     * Inserts a new finance ministry record into the database.
     *
     * <p>
     * Persists the provided {@link FinanceMinistry} entity by executing
     * an {@code INSERT INTO FINANCE_MINISTRY} statement.
     * </p>
     *
     * @param ministry the {@link FinanceMinistry} entity to be inserted
     * @throws SQLException if a database access error occurs
     */
  public void insert(FinanceMinistry ministry) throws SQLException {
    String sql = "INSERT INTO FINANCE_MINISTRY VALUES (?, ?, ?)";

    try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

      ps.setInt(1, ministry.getMajorCategory());
      ps.setString(2, ministry.getName());
      ps.setString(3, ministry.getEuros());

      ps.executeUpdate();
    }
  }
    /**
     * Updates an existing finance ministry record in the database.
     *
     * <p>
     * Updates the name and euro amount of a record identified by its major
     * category.
     * </p>
     *
     * @param ministry the {@link FinanceMinistry} entity containing updated data
     * @throws SQLException if a database access error occurs
     */
  public void update(FinanceMinistry ministry) throws SQLException {
    String sql = "UPDATE FINANCE_MINISTRY "
            + "SET NAME=?, EUROS=? WHERE MAJOR_CATEGORY=?";

    try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

      ps.setString(1, ministry.getName());
      ps.setString(2, ministry.getEuros());
      ps.setInt(3, ministry.getMajorCategory());

      ps.executeUpdate();
    }
  }
    /**
     * Deletes a finance ministry record from the database.
     *
     * <p>
     * Removes the record identified by the specified major category from
     * the {@code FINANCE_MINISTRY} table.
     * </p>
     *
     * @param majorCategory the major category identifier
     * @throws SQLException if a database access error occurs
     */
  public void delete(int majorCategory) throws SQLException {
    String sql = "DELETE FROM FINANCE_MINISTRY WHERE MAJOR_CATEGORY=?";

    try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

      ps.setInt(1, majorCategory);
      ps.executeUpdate();
    }
  }
}
