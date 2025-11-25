package com.bonus71.data.repository;

import com.bonus71.data.config.DatabaseConfig;
import com.bonus71.data.entity.financial.Revenue;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RevenueRepository {

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

    public void delete(int code) throws SQLException {
        String sql = "DELETE FROM REVENUE WHERE CODE=?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, code);
            ps.executeUpdate();
        }
    }
}
