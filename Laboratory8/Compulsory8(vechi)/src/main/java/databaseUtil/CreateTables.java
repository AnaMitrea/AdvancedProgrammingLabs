package databaseUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTables {

    static public void createContinents() throws SQLException {
        Connection con = Database.getConnection();
        Statement statement = con.createStatement();
        String sql = "CREATE TABLE continents( id int primary key," +
                                                "name varchar(20))";

        statement.executeUpdate(sql);
        statement.close();
    }

    static public void createCountries() throws SQLException {
        Connection con = Database.getConnection();
        Statement statement = con.createStatement();
        String sql = "CREATE TABLE countries( id int primary key," +
                                              "name varchar(20)," +
                                              "code varchar(20)," +
                                              "continent int) ";
        statement.executeUpdate(sql);
        statement.close();
    }
}
