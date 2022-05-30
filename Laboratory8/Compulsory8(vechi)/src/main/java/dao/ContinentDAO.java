package dao;

import databaseUtil.*;
import java.sql.*;

public class ContinentDAO {

    static int id = 3;

    static public void create(String name) throws SQLException {
        Connection con = Database.getConnection();
        PreparedStatement sql = con.prepareStatement("INSERT INTO continents VALUES(?,?)");

        sql.setInt(1, id);
        sql.setString(2,name);
        System.out.println(sql);
        sql.executeUpdate();
        id++;
    }

    static public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        Statement statement = con.createStatement();
        ResultSet result = statement.executeQuery("SELECT id FROM continents where name = '" + name + "'");

        return result.next() ? result.getInt(1) : null;
    }


    static public String findById(int id) throws SQLException {

        Connection con = Database.getConnection();
        Statement statement = con.createStatement();
        ResultSet result = statement.executeQuery("SELECT name FROM continents where id = " + id );

        return result.next() ? result.getString(1) : "";
    }
}

