package dao.homework;

import databaseUtil.Database;
import oopmodel.City;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CityDAO extends GenericDAO{

    static int id = 1;

    /**
     * Method used for checking if the input city already exists in the table.
     * @param name  The name of the city
     * @return      0 if it isn't duplicated, 1 otherwise
     * @throws SQLException     Exception
     */
    public int checkForCityDuplicates(String name) throws SQLException {
        Connection con = Database.getConnection();
        PreparedStatement stmt = con.prepareStatement("SELECT COUNT(*) FROM cities WHERE name = ?");
        stmt.setString(1,name);
        ResultSet result = stmt.executeQuery();
        return result.next() ? result.getInt(1) : 0;
    }

    /**
     * Method used to find the maximum id in the table in order to sustain the unique constraint of the primary key when we insert into the table.
     * @return      the maximum id
     * @throws SQLException Exception
     */
    private int findMaximumId() throws SQLException {
        Connection con = Database.getConnection();
        PreparedStatement statement = con.prepareStatement("SELECT max(id) FROM cities");
        ResultSet result = statement.executeQuery();
        Integer maxId = result.next() ? result.getInt(1) : null;
        return maxId + 1;
    }

    /**
     * Method used to insert a non duplicated city in the table and to create a City object.<br>
     * In case of a duplicated value, a message is shown in the console and it return null.
     * @param name      Name of the city
     * @param capital   True/False if the city is capital
     * @param latitude  Latitude
     * @param longitude Longitude
     * @return          The city object
     * @throws SQLException Exception
     */
    public City create(String name, boolean capital, String latitude, String longitude) throws SQLException {
        Connection con = Database.getConnection();

        if(checkForCityDuplicates(name) > 0) {
            System.out.println("City '" + name + "' already exists in 'cities' table. Cannot insert duplicates. - returned");
        }
        else {
            id = findMaximumId();

            PreparedStatement sql = con.prepareStatement("INSERT INTO cities VALUES(?,?,?,?,?)");
            sql.setInt(1, id);
            sql.setString(2, name);
            sql.setBoolean(3, capital);
            sql.setString(4, latitude);
            sql.setString(5, longitude);
            sql.executeUpdate();

            return new City(id, name, capital, latitude, longitude);
        }
        return null;
    }

    /**
     * Method used for finding a city by their name.
     * @param name  Name to be searched
     * @return      The City object containing all the information
     * @throws SQLException Exception
     */
    @Override
    public City findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        PreparedStatement statement = con.prepareStatement("SELECT * FROM cities WHERE name = ?");
        statement.setString(1,name);
        ResultSet result = statement.executeQuery();

        if (result.next()) {
            int cityId = result.getInt("id");
            String cityName = result.getString("name");
            boolean isCapital = result.getBoolean("capital");
            String latitude = result.getString("latitude");
            String longitude = result.getString("longitude");

            System.out.print("Found in the city table the entry");
            return new City(cityId, cityName, isCapital, latitude, longitude);
        }
        System.out.print("No entry in cities table for '" + name + "'! - returned ");
        return null;
    }

    /**
     * Method used for finding a city by their identification.
     * @param id    Id to be searched
     * @return      The City object containing all the information
     * @throws SQLException Exception
     */
    @Override
    public City findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        PreparedStatement statement = con.prepareStatement("SELECT * FROM cities where id = ?");
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();

        if (result.next()) {
            int cityId = result.getInt("id");
            String cityName = result.getString("name");
            boolean isCapital = result.getBoolean("capital");
            String latitude = result.getString("latitude");
            String longitude = result.getString("longitude");

            System.out.print("Found in the city table the entry");
            return new City(cityId, cityName, isCapital, latitude, longitude);
        }
        System.out.print("No entry in cities table for id " + id + "! - returned ");
        return null;
    }
}
