package homework;

import databaseUtil.Database;

import java.sql.*;

public class ImportCountries {

    public void createCountries() throws SQLException {
        System.out.println("[Homework] Creating 'importedCountries' table....");
        Connection con = Database.getConnection();
        Statement statement = con.createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS importedCountries( " +
                "id SERIAL PRIMARY KEY ," +
                "name varchar(100)," +
                "capital varchar(100)," +
                "latitude varchar(100)," +
                "longitude varchar(100)," +
                "code varchar(100)," +
                "continent varchar(100))";

        statement.executeUpdate(sql);
        statement.close();
    }

    public int checkImportedCountries() throws SQLException {
        Connection con = Database.getConnection();
        PreparedStatement stmt = con.prepareStatement("SELECT COUNT(*) FROM importedCountries");
        ResultSet result = stmt.executeQuery();
        return result.next() ? result.getInt(1) : 0;
    }

    public void importCountries() throws SQLException {
        System.out.print("[Homework] Importing data into 'importedCountries' table....  ");
        Connection con = Database.getConnection();

        if(checkImportedCountries() == 0) {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate
                    ("COPY importedCountries(name, capital, latitude,longitude,code,continent)\n" +
                            "        FROM 'C:\\concap.csv'\n" +
                            "        DELIMITER ','\n" +
                            "        CSV HEADER"
                    );
            ResultSet result1 = statement.executeQuery("SELECT COUNT(*) FROM importedCountries");
            Integer numberOfCountries = result1.next() ? result1.getInt(1) : null;
            System.out.println("Successfully imported " + numberOfCountries + " countries.");
        } else {
            System.out.println("Table 'importedCountries' is already populated with imported data!");
        }
    }
}
