package com.bonus71.data.repository;

import com.bonus71.data.config.DatabaseConfig;
import com.bonus71.data.entity.financial.ExpenditureDetailed;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExpenditureDetailedRepository {
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

  public void delete(int code) throws SQLException {
    String sql = "DELETE FROM EXPENDITURE_DETAILED WHERE CODE=?";

    try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

      ps.setInt(1, code);
      ps.executeUpdate();
    }
  }
}
