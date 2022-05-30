package dao.compulsory;

import databaseUtil.*;

import java.sql.*;

public class CountryDAO {

    static int id = 1;

    /**
     * Method used for checking if the input country already exists in the table.
     * @param name  The name of the country
     * @return      0 if it isn't duplicated, 1 otherwise
     * @throws SQLException     Exception
     */
    public int checkForCountryDuplicates(String name) throws SQLException {
        Connection con = Database.getConnection();
        PreparedStatement stmt = con.prepareStatement("SELECT COUNT(*) FROM countries WHERE name = ?");
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
        PreparedStatement statement = con.prepareStatement("SELECT max(id) FROM countries");
        ResultSet result = statement.executeQuery();
        Integer maxId = result.next() ? result.getInt(1) : null;
        return maxId + 1;
    }

    /**
     * Method used to insert a non duplicated country in the table.<br>
     * In case of a duplicated value, a message is shown in the console.
     * @param name          Name of the country
     * @param code          Country code
     * @param continent     Continent
     * @throws SQLException Exception
     */
    public void create(String name, String code, String continent) throws SQLException {
        Connection con = Database.getConnection();

        if(checkForCountryDuplicates(name) > 0) {
            System.out.println("Country '" + name + "' already exists in countries table. Cannot insert duplicates.");
        }
        else {
            id = findMaximumId();

            PreparedStatement sql = con.prepareStatement("INSERT INTO countries VALUES(?,?,?,?)");
            sql.setInt(1, id);
            sql.setString(2, name);
            sql.setString(3, code);
            sql.setString(4, continent);
            sql.executeUpdate();
        }
    }

    /**
     * Method used for finding a country by their name.
     * @param name      Name to be searched
     * @throws SQLException Exception
     */
    public void findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        PreparedStatement statement = con.prepareStatement("SELECT * FROM countries WHERE name = ?");
        statement.setString(1,name);
        ResultSet result = statement.executeQuery();

        if (result.next()) {
            int countryId = result.getInt("id");
            String countryCode = result.getString("code");
            String countryContinent = result.getString("continent");

            System.out.println(
                    "Searched for country '" + name +
                    "' - id: " + countryId +
                    ", code: " + countryCode +
                    ", continent: " + countryContinent + ".");
        } else {
            System.out.println("No entry in countries table for '" + name + "'!");
        }
    }

    /**
     * Method used for finding a country by their identification.
     * @param id      Id to be searched
     * @throws SQLException Exception
     */
    public void findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        PreparedStatement statement = con.prepareStatement("SELECT * FROM countries where id = ?");
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();

        if (result.next()) {
            String countryName = result.getString("name");
            String countryCode = result.getString("code");
            String countryContinent = result.getString("continent");

            System.out.println(
                    "Searched for id '" + id +
                            "' - name: " + countryName +
                            ", code: " + countryCode +
                            ", continent: " + countryContinent + ".");
        } else{
            System.out.println("No entry in countries table for id " + id + "!");
        }
    }
}