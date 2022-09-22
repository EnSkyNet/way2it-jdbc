package com.way2it.yk.jdbc.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    private static final String POSTGRES_DRIVER = "org.postgresql.Driver";

    private static final String URL = "jdbc:postgresql://localhost:5432/shop?serverTimezone=UTC";

    private static final String USER = "postgres";

    private static final String PASSWORD = "123456";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(POSTGRES_DRIVER);

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
