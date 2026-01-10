/*
 * MIT License
 *
 * Copyright (c) 2026 7+1 BONUS
 *
 * Licensed under the MIT License.
 */

package com.bonus71.data.repository;

import com.bonus71.data.config.DatabaseConfig;
import com.bonus71.data.entity.ministry.Environment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * Repository class responsible for data access operations related to
 * {@link Environment} entities.
 * <p>
 * This class provides CRUD (Create, Read, Update, Delete) functionality
 * for the {@code ENVIRONMENT} database table using JDBC. It encapsulates
 * all SQL queries and database interaction logic, ensuring a clear
 * separation between persistence and business layers.
 * </p>
 *
 * <p>
 * Database connections are obtained through {@link DatabaseConfig}, and
 * all operations utilize prepared statements for safety and performance.
 * </p>
 */
public class EnvironmentRepository {
    /**
     * Retrieves all environment-related records from the database.
     *
     * <p>
     * Executes a {@code SELECT * FROM ENVIRONMENT} query and maps each
     * result row to an {@link Environment} entity.
     * </p>
     *
     * @return a list containing all {@link Environment} records found
     * @throws SQLException if a database access error occurs
     */
  public List<Environment> findAll() throws SQLException {
    List<Environment> list = new ArrayList<>();
    String sql = "SELECT * FROM ENVIRONMENT";

    try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

      while (rs.next()) {
        list.add(new Environment(
                        rs.getInt("MAJOR_CATEGORY"),
                        rs.getString("NAME"),
                        rs.getString("EUROS")
                ));
      }
    }

    return list;
  }
    /**
     * Inserts a new environment record into the database.
     *
     * <p>
     * Persists the provided {@link Environment} entity by executing an
     * {@code INSERT INTO ENVIRONMENT} statement.
     * </p>
     *
     * @param ministry the {@link Environment} entity to be inserted
     * @throws SQLException if a database access error occurs
     */
  public void insert(Environment ministry) throws SQLException {
    String sql = "INSERT INTO ENVIRONMENT VALUES (?, ?, ?)";

    try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

      ps.setInt(1, ministry.getMajorCategory());
      ps.setString(2, ministry.getName());
      ps.setString(3, ministry.getEuros());
      ps.executeUpdate();
    }
  }
    /**
     * Updates an existing environment record in the database.
     *
     * <p>
     * Updates the name and euro amount of an environment-related record
     * identified by its major financial category.
     * </p>
     *
     * @param ministry the {@link Environment} entity containing updated data
     * @throws SQLException if a database access error occurs
     */
  public void update(Environment ministry) throws SQLException {
    String sql = "UPDATE ENVIRONMENT "
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
     * Deletes an environment record from the database.
     *
     * <p>
     * Removes the record identified by the specified major financial
     * category from the {@code ENVIRONMENT} table.
     * </p>
     *
     * @param majorCategory the major financial category identifier
     * @throws SQLException if a database access error occurs
     */
  public void delete(int majorCategory) throws SQLException {
    String sql = "DELETE FROM ENVIRONMENT WHERE MAJOR_CATEGORY=?";

    try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

      ps.setInt(1, majorCategory);
      ps.executeUpdate();
    }
  }
}
