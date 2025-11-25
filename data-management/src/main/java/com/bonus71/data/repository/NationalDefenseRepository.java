package com.bonus71.data.repository;

import com.bonus71.data.config.DatabaseConfig;
import com.bonus71.data.entity.ministry.NationalDefense;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NationalDefenseRepository {

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

    public void update(NationalDefense ministry) throws SQLException {
        String sql = "UPDATE NATIONAL_DEFENSE " +
                "SET NAME=?, EUROS=? WHERE MAJOR_CATEGORY=?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, ministry.getName());
            ps.setString(2, ministry.getEuros());
            ps.setInt(3, ministry.getMajorCategory());

            ps.executeUpdate();
        }
    }

    public void delete(int majorCategory) throws SQLException {
        String sql = "DELETE FROM NATIONAL_DEFENSE WHERE MAJOR_CATEGORY=?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, majorCategory);
            ps.executeUpdate();
        }
    }
}
