package com.example.util;



import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/appdb";
    private static final String USER = "root";
    private static final String PASSWORD = "#Hex521704";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            System.out.println("Database connection failed: " + e.getMessage());
            return null;
        }
    }
}

