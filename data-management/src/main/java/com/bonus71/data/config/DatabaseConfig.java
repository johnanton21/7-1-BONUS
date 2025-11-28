package com.bonus71.data.config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {

    private static final String URL =

            "jdbc:mysql://mainline.proxy.rlwy.net:13518/railway?useSSL=true&serverTimezone=UTC";

    private static final String USER = "root";

    private static final String PASS = "xvRyHXdJgJHaVvQIcJclFMKzxPAmlsXs";

    static {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {

            throw new RuntimeException("Unable to load MySQL driver!", e);

        }

    }

    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(URL, USER, PASS);

    }

}
