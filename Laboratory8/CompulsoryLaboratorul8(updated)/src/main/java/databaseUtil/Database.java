package databaseUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:postgresql://localhost:5432/cities";
    private static final String USER = "postgres";
    // diana
    // private static final String PASSWORD = "diana2001";
    // ana:
    private static final String PASSWORD = "admin";
    private static Connection connection = null;
    private static boolean isInstantiated = false;

    private Database() {}

    public static Connection getConnection(){
        if(!isInstantiated) {
            createConnection();
        }
        return connection;
    }

    private static void createConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            isInstantiated = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection(){
        try {
            connection.close();
            isInstantiated = false;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}