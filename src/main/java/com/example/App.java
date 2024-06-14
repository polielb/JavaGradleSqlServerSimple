package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) {
        // System.out.println(System.getProperty("java.library.path"));
        String connectionUrl = "jdbc:sqlserver://DESKTOP-GMUPP2V\\SQLEXPRESS:64577;databaseName=master;integratedSecurity=true";

        try (Connection con = DriverManager.getConnection(connectionUrl)) {
            System.out.println("Conexión exitosa");

            // Obtener la fecha actual de SQL Server
            try (Statement stmt = con.createStatement()) {
                ResultSet rs = stmt.executeQuery("SELECT GETDATE()");
                if (rs.next()) {
                    System.out.println("Fecha actual de SQL Server: " + rs.getTimestamp(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
