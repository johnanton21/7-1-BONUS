/*
 * MIT License
 *
 * Copyright (c) 2026 7+1 BONUS
 *
 * Licensed under the MIT License.
 */

package com.bonus71.data.repository;

import com.bonus71.data.config.DatabaseConfig;
import com.bonus71.data.entity.financial.Revenue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Repository class responsible for data access operations related to
 * {@link Revenue} entities.
 *
 * <p>Provides CRUD (Create, Read, Update, Delete) functionality for the
 * {@code REVENUE} database table using JDBC. Encapsulates SQL execution
 * and result mapping, ensuring separation between persistence and
 * business logic layers.

 *
 * <p>Database connections are managed through {@link DatabaseConfig}, and
 * prepared statements are used to improve security and performance.

 */
public class RevenueRepository {
  /**
   * Retrieves all revenue records from the database.
   *
   * <p>Executes a {@code SELECT * FROM REVENUE} query and maps each result
   * row to a {@link Revenue} entity.

   *
   * @return a list containing all {@link Revenue} records found
   * @throws SQLException if a database access error occurs
   */
  public List<Revenue> findAll() throws SQLException {
    List<Revenue> list = new ArrayList<>();
    String sql = "SELECT * FROM REVENUE";

    try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

      while (rs.next()) {
        list.add(new Revenue(
                        rs.getInt("CODE"),
                        rs.getString("CATEGORY"),
                        rs.getString("EUROS")
                ));
      }
    }

    return list;
  }
  /**
   * Inserts a new revenue record into the database.
   *
   * <p>Persists the provided {@link Revenue} entity by executing an
   * {@code INSERT INTO REVENUE} statement.

   *
   * @param revenue the {@link Revenue} entity to be inserted
   * @throws SQLException if a database access error occurs
   */
  public void insert(Revenue revenue) throws SQLException {
    String sql = "INSERT INTO REVENUE VALUES (?, ?, ?)";

    try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

      ps.setInt(1, revenue.getCode());
      ps.setString(2, revenue.getCategory());
      ps.setString(3, revenue.getEuros());

      ps.executeUpdate();
    }
  }
  /**
   * Updates an existing revenue record in the database.
   *
   * <p>Updates the category and euro amount of a record identified by its code.

   *
   * @param revenue the {@link Revenue} entity containing updated data
   * @throws SQLException if a database access error occurs
   */
  public void update(Revenue revenue) throws SQLException {
    String sql = "UPDATE REVENUE SET CATEGORY=?, EUROS=? WHERE CODE=?";

    try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

      ps.setString(1, revenue.getCategory());
      ps.setString(2, revenue.getEuros());
      ps.setInt(3, revenue.getCode());

      ps.executeUpdate();
    }
  }
  /**
   * Deletes a revenue record from the database.
   *
   * <p>Removes the record identified by the specified code from the {@code REVENUE} table.

   *
   * @param code the unique code identifying the revenue record
   * @throws SQLException if a database access error occurs
   */
  public void delete(int code) throws SQLException {
    String sql = "DELETE FROM REVENUE WHERE CODE=?";

    try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

      ps.setInt(1, code);
      ps.executeUpdate();
    }
  }
}
