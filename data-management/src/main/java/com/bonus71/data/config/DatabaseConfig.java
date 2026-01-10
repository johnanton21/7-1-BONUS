/*
 * MIT License
 *
 * Copyright (c) 2026 7+1 BONUS
 *
 * Licensed under the MIT License.
 */

package com.bonus71.data.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Database configuration utility class.
 *
 * <p>This class is responsible for configuring and providing access
 * to the application's database. It centralizes all database connection
 * settings, including the JDBC URL, credentials, and driver initialization.</p>
 *
 * <p>The class uses the MySQL JDBC driver and establishes connections
 * through the {@link java.sql.DriverManager}. A static initialization block
 * ensures that the database driver is loaded once when the class is first
 * accessed.</p>
 *
 * <p>This class follows a utility-based design and exposes a single
 * static method for obtaining database connections, allowing repository
 * classes to interact with the database in a consistent and controlled
 * manner.</p>
 */

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
