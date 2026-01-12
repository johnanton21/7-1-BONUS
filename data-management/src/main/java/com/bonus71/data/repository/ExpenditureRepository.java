/*
 * MIT License
 *
 * Copyright (c) 2026 7+1 BONUS
 *
 * Licensed under the MIT License.
 */

package com.bonus71.data.repository;

import com.bonus71.data.config.DatabaseConfig;
import com.bonus71.data.entity.financial.Expenditure;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * Repository class responsible for data access operations related to
 * {@link Expenditure} entities.
 *
 * <p>This class provides CRUD (Create, Read, Update, Delete) functionality
 * for the {@code EXPENDITURE} database table using JDBC. It encapsulates
 * SQL statements and database interaction logic, promoting a clean
 * separation between persistence and business logic layers.

 *
 * <p>Database connections are managed through {@link DatabaseConfig}, and
 * all operations use prepared statements to ensure safety and efficiency.

 */
public class ExpenditureRepository {
  /**
   * Retrieves all expenditure records from the database.
   *
   * <p>Executes a {@code SELECT * FROM EXPENDITURE} query and maps each
   * result row to an {@link Expenditure} entity.

   *
   * @return a list containing all {@link Expenditure} records found
   * @throws SQLException if a database access error occurs
   */
  public List<Expenditure> findAll() throws SQLException {
    List<Expenditure> list = new ArrayList<>();
    String sql = "SELECT * FROM EXPENDITURE";

    try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

      while (rs.next()) {
        list.add(new Expenditure(
                        rs.getInt("CODE"),
                        rs.getString("CATEGORY"),
                        rs.getString("EUROS")
                ));
      }
    }
    return list;
  }
  /**
   * Inserts a new expenditure record into the database.
   *
   * <p>Persists the provided {@link Expenditure} entity by executing an
   * {@code INSERT INTO EXPENDITURE} statement.

   *
   * @param expenditure the {@link Expenditure} entity to be inserted
   * @throws SQLException if a database access error occurs
   */
  public void insert(Expenditure expenditure) throws SQLException {
    String sql = "INSERT INTO EXPENDITURE VALUES (?, ?, ?)";

    try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

      ps.setInt(1, expenditure.getCode());
      ps.setString(2, expenditure.getCategory());
      ps.setString(3, expenditure.getEuros());
      ps.executeUpdate();
    }
  }
  /**
   * Updates an existing expenditure record in the database.
   *
   * <p>Updates the category and euro amount of an expenditure record
   * identified by its unique code.

   *
   * @param expenditure the {@link Expenditure} entity containing updated data
   * @throws SQLException if a database access error occurs
   */
  public void update(Expenditure expenditure) throws SQLException {
    String sql = "UPDATE EXPENDITURE SET CATEGORY=?, EUROS=? WHERE CODE=?";

    try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

      ps.setString(1, expenditure.getCategory());
      ps.setString(2, expenditure.getEuros());
      ps.setInt(3, expenditure.getCode());
      ps.executeUpdate();
    }
  }
  /**
   * Deletes an expenditure record from the database.
   *
   * <p>Removes the record identified by the specified expenditure code
   * from the {@code EXPENDITURE} table.

   *
   * @param code the unique expenditure code identifier
   * @throws SQLException if a database access error occurs
   */
  public void delete(int code) throws SQLException {
    String sql = "DELETE FROM EXPENDITURE WHERE CODE=?";

    try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

      ps.setInt(1, code);
      ps.executeUpdate();
    }
  }
}
