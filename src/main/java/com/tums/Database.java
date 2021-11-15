package com.tums;

import com.tums.users.StudentUser;

import java.sql.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Database {
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/tums";
    private static final String DB_USER = "tums";
    private static final String DB_PASSWORD = "tums";
    private static Database instance = null;
    private static String useDatabase = "USE tums;";

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
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            AlertBox.showAlert("No database driver",e.getMessage());
        }

        try{
            connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            return connection;
        } catch (SQLException e){
            e.printStackTrace();
            AlertBox.showAlert("Database connection problem", e.getMessage());
        }
        return connection;
    }

    //Creating database
    protected static void createDatabase(){
        String createDatabase = "CREATE DATABASE IF NOT EXISTS tums;";


        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", DB_USER, DB_PASSWORD);
                Statement stmt = conn.createStatement()
                ){
            stmt.executeUpdate(createDatabase);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    protected static void createTable() {


        String createStudentTable = "CREATE TABLE IF NOT EXISTS student (`" +
                "id_student` INT AUTO_INCREMENT, " +
                "`name` varchar(255), " +
                "`lastName` VARCHAR(255)," +
                "`email` VARCHAR(255) NOT NULL, " +
                "`password` VARCHAR(255) NOT NULL, " +
                "`birthDate` DATE, " +
                "`created_at` DATETIME DEFAULT CURRENT_TIMESTAMP, " +
                "PRIMARY KEY (`id_student`), " +
                "UNIQUE KEY (`id_student`, `email`, `password`))";

        try (Connection conn = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(useDatabase);
            stmt.executeUpdate(createStudentTable);

        } catch (SQLException e) {
            System.err.println("creating table error");
            e.printStackTrace();
        }
    }


    //Adding student to the database
    public static void addStudent(String name, String lastName, String email, String password, String birthDate) {
        String sql = "INSERT INTO student (`name`, `lastName`, `email`, `password`, `birthDate`) VALUES (?, ?, ?, ?, ?);";

        try(
                Connection connection = getDBConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
                preparedStatement.setString(1,name);
                preparedStatement.setString(2,lastName);
                preparedStatement.setString(3,email);
                preparedStatement.setString(4,password);
                preparedStatement.setString(5,birthDate);
                preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public List<StudentUser> studentUserList(){
        List<StudentUser> students = new LinkedList<>();
        String sql = "SELECT * FROM student;";

        try(
                Connection connection = getDBConnection();
                Statement statement = connection.createStatement();
                ) {
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                int id = resultSet.getInt("id_student");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("lastName");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                Date bDate = resultSet.getDate("birthDate");
                LocalDate birthDate = ((java.sql.Date) bDate).toLocalDate();
                students.add(new StudentUser(id,name,lastName,email,password,birthDate));

            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }

        return students;
    }


}
