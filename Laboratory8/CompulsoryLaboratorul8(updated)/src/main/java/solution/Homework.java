package solution;

import dao.homework.CityDAO;
import dao.homework.GenericContinentDAO;
import dao.homework.GenericCountryDAO;
import databaseUtil.*;
import homework.*;
import oopmodel.City;
import oopmodel.Continent;
import oopmodel.Country;
import oopmodel.util.OopModelUtil;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Homework {

    private List<City> cities;
    private List<Country> countries;
    private List<Continent> continents;

    public Homework() {
        //Class.forName("org.postgresql.Driver");
        createTables();
        this.cities = new ArrayList<>();
        this.countries = new ArrayList<>();
        this.continents = new ArrayList<>();
    }

    /**
     * Method used to create the initial tables and to populate the 'importedcountries' and 'cities' tables.
     */
    public void createTables() {
        try {
            CreateTables.createCountriesTable();
            CreateTables.createContinentsTable();
            CreateTables.createCitiesTable();

            ImportCountries importCountries = new ImportCountries();
            importCountries.createCountries();
            importCountries.importCountries();

            ImportCities importCities = new ImportCities();
            importCities.importCities();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createOopModel() throws SQLException {
        this.cities = OopModelUtil.oopModelForCity();
        this.countries = OopModelUtil.oopModelForCountry();
        this.continents = OopModelUtil.oopModelForContinent();
    }

    public static void main(String[] args) {
        Homework homework = new Homework();
        try {
            CityDAO cityDAO = new CityDAO();
            cityDAO.create("Iasi",false,"47.15","27.58");

            homework.createOopModel();

            System.out.println("Cities List: \n" + homework.cities);
            System.out.println( homework.cities.get(1).distanceBetween(homework.cities.get(2)) + " kilometers." );
            System.out.println("Countries List: \n" + homework.countries);
            System.out.println("Continents List: \n" + homework.continents);

            GenericContinentDAO genericContinentDAO = new GenericContinentDAO();
            System.out.println(genericContinentDAO.findById(20));
            System.out.println(genericContinentDAO.findById(5));
            System.out.println(genericContinentDAO.findByName("Europe"));

            GenericCountryDAO genericCountryDAO = new GenericCountryDAO();
            System.out.println(genericCountryDAO.findById(300));
            System.out.println(genericCountryDAO.findByName("Abcdef"));

            System.out.println(cityDAO.findByName("abcdef"));
            System.out.println(cityDAO.findById(2));

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            Database.closeConnection();
        }
    }
}