package com.tums;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/tums";
    private static final String DB_USER = "tums";
    private static final String DB_PASSWORD = "tums";
    private static Database instance = null;

    private Database(){
    }
    public static Database getInstance(){
        if (instance == null){
            instance = new Database();
        }
        return instance;
    }

    public static Connection getDBConnection(){
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            AlertBox.showAlert("No database driver",e.getMessage());
        }

        try{
            connection = DriverManager.getConnection(DB_CONNECTION,DB_USER, DB_PASSWORD);
            return connection;
        } catch (SQLException e){
            e.printStackTrace();
            AlertBox.showAlert("Database connection problem", e.getMessage());
        }
        return connection;
    }

    protected static void createTable() {

        String createStudentTable = "CREATE TABLE IF NOT EXISTS student (`" +
                "id_student` INT NOT NULL AUTO_INCREMENT, " +
                "`name` varchar(255), " +
                "`lastName` VARCHAR(255)," +
                "`email` VARCHAR(255) NOT NULL, " +
                "`birthDay` DATE, " +
                "`created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP, " +
                "PRIMARY KEY (`id_student`), " +
                "unique key (`id_student`, `email`))";

        try (Connection conn = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement()) {
            Class.forName(DB_DRIVER);

            // Create new table

            stmt.executeUpdate(createStudentTable);

        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("creating table error");
            e.printStackTrace();
        }
    }



}
