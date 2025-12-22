package com.bonus71.data.repository;

import com.bonus71.data.config.DatabaseConfig;
import com.bonus71.data.entity.ministry.Health;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HealthRepository {
  public List<Health> findAll() throws SQLException {
    List<Health> list = new ArrayList<>();
    String sql = "SELECT * FROM HEALTH";

    try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

      while (rs.next()) {
        list.add(new Health(
                        rs.getInt("MAJOR_CATEGORY"),
                        rs.getString("NAME"),
                        rs.getString("EUROS")
                ));
      }
    }

    return list;
  }

  public void insert(Health ministry) throws SQLException {
    String sql = "INSERT INTO HEALTH VALUES (?, ?, ?)";

    try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

      ps.setInt(1, ministry.getMajorCategory());
      ps.setString(2, ministry.getName());
      ps.setString(3, ministry.getEuros());

      ps.executeUpdate();
    }
  }

  public void update(Health ministry) throws SQLException {
    String sql = "UPDATE HEALTH "
            + "SET NAME=?, EUROS=? WHERE MAJOR_CATEGORY=?";

    try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

      ps.setString(1, ministry.getName());
      ps.setString(2, ministry.getEuros());
      ps.setInt(3, ministry.getMajorCategory());

      ps.executeUpdate();
    }
  }

  public void delete(int majorCategory) throws SQLException {
    String sql = "DELETE FROM HEALTH WHERE MAJOR_CATEGORY=?";

    try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

      ps.setInt(1, majorCategory);
      ps.executeUpdate();
    }
  }
}
