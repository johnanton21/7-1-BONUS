/*
 * MIT License
 *
 * Copyright (c) 2026 7+1 BONUS
 *
 * Licensed under the MIT License.
 */

package com.bonus71.data.repository;

import com.bonus71.data.config.DatabaseConfig;
import com.bonus71.data.entity.ministry.Education;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * Repository class responsible for data access operations related to
 * {@link Education} entities.
 * <p>
 * This class provides CRUD (Create, Read, Update, Delete) functionality
 * for the {@code EDUCATION} database table using JDBC. It encapsulates
 * all SQL logic and database interaction, ensuring separation of concerns
 * between persistence and business logic layers.

 *
 * <p>
 * Database connections are managed through {@link DatabaseConfig}, and
 * all operations use prepared statements to ensure safety and efficiency.

 */
public class EducationRepository {
    /**
     * Retrieves all education records from the database.
     *
     * <p>
     * Executes a {@code SELECT * FROM EDUCATION} query and maps each result
     * row to an {@link Education} entity.

     *
     * @return a list containing all {@link Education} records found
     * @throws SQLException if a database access error occurs
     */
  public List<Education> findAll() throws SQLException {
    List<Education> list = new ArrayList<>();
    String sql = "SELECT * FROM EDUCATION";

    try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

      while (rs.next()) {
        list.add(new Education(
                        rs.getInt("MAJOR_CATEGORY"),
                        rs.getString("NAME"),
                        rs.getString("EUROS")
                ));
      }
    }
    return list;
  }
    /**
     * Inserts a new education record into the database.
     *
     * <p>
     * Executes an {@code INSERT INTO EDUCATION} statement using the data
     * provided by the given {@link Education} entity.

     *
     * @param ministry the {@link Education} entity to be persisted
     * @throws SQLException if a database access error occurs
     */
  public void insert(Education ministry) throws SQLException {
    String sql = "INSERT INTO EDUCATION VALUES (?, ?, ?)";

    try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

      ps.setInt(1, ministry.getMajorCategory());
      ps.setString(2, ministry.getName());
      ps.setString(3, ministry.getEuros());
      ps.executeUpdate();
    }
  }
    /**
     * Updates an existing education record in the database.
     *
     * <p>
     * Updates the name and euro amount of an education record identified
     * by its major financial category.

     *
     * @param ministry the {@link Education} entity containing updated data
     * @throws SQLException if a database access error occurs
     */
  public void update(Education ministry) throws SQLException {
    String sql = "UPDATE EDUCATION "
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
     * Deletes an education record from the database.
     *
     * <p>
     * Removes the record identified by the specified major financial
     * category from the {@code EDUCATION} table.

     *
     * @param majorCategory the major financial category identifier
     * @throws SQLException if a database access error occurs
     */
  public void delete(int majorCategory) throws SQLException {
    String sql = "DELETE FROM EDUCATION WHERE MAJOR_CATEGORY=?";

    try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

      ps.setInt(1, majorCategory);
      ps.executeUpdate();
    }
  }
}
