package oopmodel.util;

import databaseUtil.Database;
import oopmodel.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OopModelUtil {

    /**
     * Method used for creating a list containing all the continent information from the 'continents' table.
     * @return  The list of continents
     * @throws SQLException Exception
     */
    public static List<Continent> oopModelForContinent() throws SQLException {
        List<Continent> list = new ArrayList<>();

        Connection con = Database.getConnection();
        PreparedStatement statement = con.prepareStatement("SELECT * FROM continents");
        ResultSet result = statement.executeQuery();

        while (result.next()) {
            int continentId = result.getInt("id");
            String name = result.getString("name");

            list.add( new Continent(continentId, name) );
        }
        return list;
    }

    /**
     * Method used for creating a list containing all the country information from the 'importedcountries' table.
     * @return  The list of countries
     * @throws SQLException Exception
     */
    public static List<Country> oopModelForCountry() throws SQLException {
        List<Country> list = new ArrayList<>();

        Connection con = Database.getConnection();
        PreparedStatement statement = con.prepareStatement("SELECT * FROM importedcountries");
        ResultSet result = statement.executeQuery();

        while (result.next()) {
            int countryId = result.getInt("id");
            String name = result.getString("name");
            String capital = result.getString("capital");
            String latitude = result.getString("latitude");
            String longitude = result.getString("longitude");
            String code = result.getString("code");
            String continent = result.getString("continent");

            list.add( new Country(countryId, name, capital, latitude, longitude, code, continent) );
        }
        return list;
    }

    /**
     * Method used for creating a list containing all the city information from the 'cities' table.
     * @return  The list of cities
     * @throws SQLException Exception
     */
    public static List<City> oopModelForCity() throws SQLException {
        List<City> list = new ArrayList<>();

        Connection con = Database.getConnection();
        PreparedStatement statement = con.prepareStatement("SELECT * FROM cities");
        ResultSet result = statement.executeQuery();

        while (result.next()) {
            int cityId = result.getInt("id");
            String name = result.getString("name");
            boolean capital = result.getBoolean("capital");
            String latitude = result.getString("latitude");
            String longitude = result.getString("longitude");

            list.add( new City(cityId, name, capital, latitude, longitude) );
        }
        return list;
    }
}
