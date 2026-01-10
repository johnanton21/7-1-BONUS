package com.bonus71.data.repository;

import com.bonus71.data.config.DatabaseConfig;
import com.bonus71.data.entity.ministry.NationalDefense;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * Repository class responsible for data access operations related to
 * {@link NationalDefense} entities.
 * <p>
 * Provides CRUD (Create, Read, Update, Delete) functionality for the
 * {@code NATIONAL_DEFENSE} database table using JDBC. Encapsulates SQL
 * execution and result mapping logic, ensuring a clear separation between
 * persistence and business layers.

 *
 * <p>
 * Database connections are managed through {@link DatabaseConfig}, and
 * prepared statements are used to ensure security and efficiency.

 */
public class NationalDefenseRepository {
    /**
     * Retrieves all national defense ministry records from the database.
     *
     * <p>
     * Executes a {@code SELECT * FROM NATIONAL_DEFENSE} query and maps each
     * result row to a {@link NationalDefense} entity.

     *
     * @return a list containing all {@link NationalDefense} records found
     * @throws SQLException if a database access error occurs
     */
  public List<NationalDefense> findAll() throws SQLException {
    List<NationalDefense> list = new ArrayList<>();
    String sql = "SELECT * FROM NATIONAL_DEFENSE";

    try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

      while (rs.next()) {
        list.add(new NationalDefense(
                        rs.getInt("MAJOR_CATEGORY"),
                        rs.getString("NAME"),
                        rs.getString("EUROS")
                ));
      }
    }

    return list;
  }
    /**
     * Inserts a new national defense ministry record into the database.
     *
     * <p>
     * Persists the provided {@link NationalDefense} entity by executing
     * an {@code INSERT INTO NATIONAL_DEFENSE} statement.

     *
     * @param ministry the {@link NationalDefense} entity to be inserted
     * @throws SQLException if a database access error occurs
     */
  public void insert(NationalDefense ministry) throws SQLException {
    String sql = "INSERT INTO NATIONAL_DEFENSE VALUES (?, ?, ?)";

    try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

      ps.setInt(1, ministry.getMajorCategory());
      ps.setString(2, ministry.getName());
      ps.setString(3, ministry.getEuros());

      ps.executeUpdate();
    }
  }
    /**
     * Updates an existing national defense ministry record in the database.
     *
     * <p>
     * Updates the name and euro amount of a record identified by its major
     * category.

     *
     * @param ministry the {@link NationalDefense} entity containing updated data
     * @throws SQLException if a database access error occurs
     */
  public void update(NationalDefense ministry) throws SQLException {
    String sql = "UPDATE NATIONAL_DEFENSE "
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
     * Deletes a national defense ministry record from the database.
     *
     * <p>
     * Removes the record identified by the specified major category from
     * the {@code NATIONAL_DEFENSE} table.

     *
     * @param majorCategory the major category identifier
     * @throws SQLException if a database access error occurs
     */
  public void delete(int majorCategory) throws SQLException {
    String sql = "DELETE FROM NATIONAL_DEFENSE WHERE MAJOR_CATEGORY=?";

    try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

      ps.setInt(1, majorCategory);
      ps.executeUpdate();
    }
  }
}
