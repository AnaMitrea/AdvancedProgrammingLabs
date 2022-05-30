package homework;

import databaseUtil.Database;

import java.sql.*;

public class ImportCities {

    private int checkImportedCities() throws SQLException {
        Connection con = Database.getConnection();
        PreparedStatement stmt = con.prepareStatement("SELECT COUNT(*) FROM cities");
        ResultSet result = stmt.executeQuery();
        return result.next() ? result.getInt(1) : 0;
    }

    public void importCities() throws SQLException {
        System.out.print("[Homework] Importing data into 'cities' table....  ");
        Connection con = Database.getConnection();

        if(checkImportedCities() == 0) {
            PreparedStatement statement = con.prepareStatement(
                    "SELECT id, capital, latitude, longitude FROM importedcountries");

            ResultSet result = statement.executeQuery();
            int numberOfCities = 0;
            while(result.next()){
                String name = result.getString("capital");

                if(!name.equals("N/A")) {
                    numberOfCities++;
                    int cityId = result.getInt("id");

                    boolean capital = true;
                    String latitude = result.getString("latitude");
                    String longitude = result.getString("longitude");

                    PreparedStatement insertQuery = con.prepareStatement("INSERT INTO cities VALUES(?,?,?,?,?)");
                    insertQuery.setInt(1, cityId);
                    insertQuery.setString(2, name);
                    insertQuery.setBoolean(3, capital);
                    insertQuery.setString(4, latitude);
                    insertQuery.setString(5, longitude);
                    insertQuery.executeUpdate();
                }
            }

            System.out.println("Successfully imported " + numberOfCities + " countries.");
        } else {
            System.out.println("Table 'cities' is already populated with imported data!");
        }
    }
}
