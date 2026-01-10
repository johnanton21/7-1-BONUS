/*
 * MIT License
 *
 * Copyright (c) 2026 7+1 BONUS
 *
 * Licensed under the MIT License.
 */

package com.bonus71.data.repository;

import com.bonus71.data.config.DatabaseConfig;
import com.bonus71.data.entity.financial.ExpenditureDetailed;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * Repository class responsible for data access operations related to
 * {@link ExpenditureDetailed} entities.
 * <p>
 * This class provides CRUD (Create, Read, Update, Delete) functionality
 * for the {@code EXPENDITURE_DETAILED} database table using JDBC. It
 * encapsulates SQL execution and result mapping logic, ensuring a clear
 * separation between the persistence and business layers.
 * </p>
 *
 * <p>
 * All database connections are obtained via {@link DatabaseConfig}, and
 * prepared statements are used throughout to ensure security and
 * performance.
 * </p>
 */
public class ExpenditureDetailedRepository {
    /**
     * Retrieves all detailed expenditure records from the database.
     *
     * <p>
     * Executes a {@code SELECT * FROM EXPENDITURE_DETAILED} query and maps
     * each result row to an {@link ExpenditureDetailed} entity.
     * </p>
     *
     * @return a list containing all {@link ExpenditureDetailed} records found
     * @throws SQLException if a database access error occurs
     */
  public List<ExpenditureDetailed> findAll() throws SQLException {
    List<ExpenditureDetailed> list = new ArrayList<>();
    String sql = "SELECT * FROM EXPENDITURE_DETAILED";

    try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

      while (rs.next()) {
        list.add(new ExpenditureDetailed(
                        rs.getInt("CODE"),
                        rs.getString("DEPARTMENT"),
                        rs.getString("REGULAR_BUDGET"),
                        rs.getString("PUBLIC_INVESTMENT_BUDGET"),
                        rs.getString("TOTAL")
                ));
      }
    }

    return list;
  }
    /**
     * Inserts a new detailed expenditure record into the database.
     *
     * <p>
     * Persists the provided {@link ExpenditureDetailed} entity by executing
     * an {@code INSERT INTO EXPENDITURE_DETAILED} statement.
     * </p>
     *
     * @param expenditure the {@link ExpenditureDetailed} entity to be inserted
     * @throws SQLException if a database access error occurs
     */
  public void insert(ExpenditureDetailed expenditure) throws SQLException {
    String sql = "INSERT INTO EXPENDITURE_DETAILED VALUES (?, ?, ?, ?, ?)";

    try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

      ps.setInt(1, expenditure.getCode());
      ps.setString(2, expenditure.getDepartment());
      ps.setString(3, expenditure.getRegularBudget());
      ps.setString(4, expenditure.getPublicInvestmentBudget());
      ps.setString(5, expenditure.getTotal());

      ps.executeUpdate();
    }
  }
    /**
     * Updates an existing detailed expenditure record in the database.
     *
     * <p>
     * Updates department and budget-related fields of a record identified
     * by its unique expenditure code.
     * </p>
     *
     * @param expenditure the {@link ExpenditureDetailed} entity containing
     *                    updated data
     * @throws SQLException if a database access error occurs
     */
  public void update(ExpenditureDetailed expenditure) throws SQLException {
    String sql = "UPDATE EXPENDITURE_DETAILED "
            + "SET DEPARTMENT=?, "
            + "REGULAR_BUDGET=?, "
            + "PUBLIC_INVESTMENT_BUDGET=?, "
            + "TOTAL=? "
            + "WHERE CODE=?";

    try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

      ps.setString(1, expenditure.getDepartment());
      ps.setString(2, expenditure.getRegularBudget());
      ps.setString(3, expenditure.getPublicInvestmentBudget());
      ps.setString(4, expenditure.getTotal());
      ps.setInt(5, expenditure.getCode());

      ps.executeUpdate();
    }
  }

    /**
     * Deletes a detailed expenditure record from the database.
     *
     * <p>
     * Removes the record identified by the specified expenditure code
     * from the {@code EXPENDITURE_DETAILED} table.
     * </p>
     *
     * @param code the unique expenditure code identifier
     * @throws SQLException if a database access error occurs
     */
  public void delete(int code) throws SQLException {
    String sql = "DELETE FROM EXPENDITURE_DETAILED WHERE CODE=?";

    try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

      ps.setInt(1, code);
      ps.executeUpdate();
    }
  }
}
