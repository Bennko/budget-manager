package com.example.budgetmanager.db;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseHelper {
    public static final String DB_URL = "jdbc:sqlite:budget.db";

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(DB_URL);
    }
}
