package databaseUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTables {

    public static void createContinentsTable() throws SQLException {
        System.out.println("[Compulsory] Creating 'continents' table...");
        Connection con = Database.getConnection();
        Statement statement = con.createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS continents( " +
                        "id int primary key," +
                        "name varchar(20))";

        statement.executeUpdate(sql);
        statement.close();
    }

    public static void createCountriesTable() throws SQLException {
        System.out.println("[Compulsory] Creating 'countries' table...");
        Connection con = Database.getConnection();
        Statement statement = con.createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS countries( " +
                        "id int primary key," +
                        "name varchar(20)," +
                        "code varchar(20)," +
                        "continent varchar (20)) ";
        statement.executeUpdate(sql);
        statement.close();
    }

    public static void createCitiesTable() throws SQLException {
        System.out.println("[Homework] Creating 'cities' table...");
        Connection con = Database.getConnection();
        Statement statement = con.createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS cities( " +
                "id int PRIMARY KEY," +
                "name varchar(20)," +
                "capital boolean NOT NULL DEFAULT FALSE," +
                "latitude varchar(20)," +
                "longitude varchar(20))";

        statement.executeUpdate(sql);
        statement.close();
    }
}