package com.s4m.poo.basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/gestion_notes";
    private static final String USER = "root";
    private static final String PASSWORD = "12345678";

    private static Connection connection = null;

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Connexion réussie DB");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
