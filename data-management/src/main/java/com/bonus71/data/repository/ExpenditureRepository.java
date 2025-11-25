package com.bonus71.data.repository;

import com.bonus71.data.config.DatabaseConfig;
import com.bonus71.data.entity.financial.Expenditure;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenditureRepository {

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

    public void delete(int code) throws SQLException {
        String sql = "DELETE FROM EXPENDITURE WHERE CODE=?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, code);
            ps.executeUpdate();
        }
    }
}
