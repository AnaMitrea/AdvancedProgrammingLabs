package dao.homework;

import databaseUtil.Database;
import oopmodel.Country;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GenericCountryDAO extends GenericDAO{
    static int id = 1;

    private int checkForCountryDuplicates(String name) throws SQLException {
        Connection con = Database.getConnection();
        PreparedStatement stmt = con.prepareStatement("SELECT COUNT(*) FROM importedcountries WHERE name = ?");
        stmt.setString(1,name);
        ResultSet result = stmt.executeQuery();
        return result.next() ? result.getInt(1) : 0;
    }

    private int findMaximumId() throws SQLException {
        Connection con = Database.getConnection();
        PreparedStatement statement = con.prepareStatement("SELECT max(id) FROM importedcountries");
        ResultSet result = statement.executeQuery();
        Integer maxId = result.next() ? result.getInt(1) : null;
        return maxId + 1;
    }

    public Country create(String name, String capital, String latitude, String longitude, String code, String continent) throws SQLException {
        Connection con = Database.getConnection();

        if(checkForCountryDuplicates(name) > 0) {
            System.out.println("Country '" + name + "' already exists in countries table. Cannot insert duplicates.");
        }
        else {
            id = findMaximumId();

            PreparedStatement sql = con.prepareStatement("INSERT INTO importedcountries VALUES(?,?,?,?,?,?,?)");
            sql.setInt(1, id);
            sql.setString(2, name);
            sql.setString(3, capital);
            sql.setString(4, latitude);
            sql.setString(5, longitude);
            sql.setString(6, code);
            sql.setString(7, continent);
            sql.executeUpdate();

            return new Country(id, name, capital, latitude, longitude, code, continent);
        }
        return null;
    }

    /**
     * Method used for finding a country by their name.
     * @param name  Name to be searched
     * @return  The Country object containing all the information
     * @throws SQLException Exception
     */
    @Override
    public Country findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        PreparedStatement statement = con.prepareStatement("SELECT * FROM importedcountries WHERE name = ?");
        statement.setString(1,name);
        ResultSet result = statement.executeQuery();

        if (result.next()) {
            int countryId = result.getInt("id");
            String countryName = result.getString("name");
            String capital = result.getString("capital");
            String latitude = result.getString("latitude");
            String longitude = result.getString("longitude");
            String code = result.getString("code");
            String continent = result.getString("continent");

            return new Country(countryId, countryName, capital, latitude, longitude, code, continent);
        }
        System.out.print("No entry in countries table for '" + name + "'! - returned ");
        return null;
    }

    /**
     * Method used for finding a country by their id.
     * @param id  Name to be searched
     * @return  The Country object containing all the information
     * @throws SQLException Exception
     */
    @Override
    public Country findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        PreparedStatement statement = con.prepareStatement("SELECT * FROM importedcountries WHERE id = ?");
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();

        if (result.next()) {
            int countryId = result.getInt("id");
            String countryName = result.getString("name");
            String capital = result.getString("capital");
            String latitude = result.getString("latitude");
            String longitude = result.getString("longitude");
            String code = result.getString("code");
            String continent = result.getString("continent");

            return new Country(countryId, countryName, capital, latitude, longitude, code, continent);
        }
        System.out.print("No entry in countries table for id '" + id + "'! - returned ");
        return null;
    }
}
