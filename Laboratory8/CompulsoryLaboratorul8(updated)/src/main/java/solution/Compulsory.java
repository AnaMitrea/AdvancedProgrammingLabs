package solution;

import dao.compulsory.ContinentDAO;
import dao.compulsory.CountryDAO;
import databaseUtil.*;
import java.sql.Connection;
import java.sql.SQLException;

public class Compulsory {
    private Connection con;
    private ContinentDAO continentDAO;
    private CountryDAO countriesDAO;

    public Compulsory() {

        this.con = Database.getConnection();
        createTables();
        continentDAO = new ContinentDAO();
        countriesDAO = new CountryDAO();
    }

    public void createTables() {
        try {
            CreateTables.createCountriesTable();
            CreateTables.createContinentsTable();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Compulsory compulsory = new Compulsory();

            compulsory.continentDAO.create("Africa");
            compulsory.continentDAO.create("Europe");

            compulsory.continentDAO.findByName("Asia");
            compulsory.continentDAO.findById(1);

            compulsory.countriesDAO.create("Romania", "678", "Europe");
            compulsory.countriesDAO.findByName("Romania");
            compulsory.countriesDAO.findByName("Brazil");
            compulsory.countriesDAO.findById(5);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            Database.closeConnection();
        }
    }
}