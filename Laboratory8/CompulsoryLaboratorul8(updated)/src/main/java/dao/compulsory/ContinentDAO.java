package dao.compulsory;

import databaseUtil.*;

import java.sql.*;

public class ContinentDAO {
    static int id = 1;

    /**
     * Method used for checking if the input continent already exists in the table.
     * @param name  The name of the continent
     * @return      0 if it isnt duplicated, 1 otherwise
     * @throws SQLException     Exception
     */
    private int checkForContinentDuplicates(String name) throws SQLException {
        Connection con = Database.getConnection();
        PreparedStatement stmt = con.prepareStatement("SELECT COUNT(*) FROM continents WHERE name = ?");
        stmt.setString(1, name);
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
        PreparedStatement statement = con.prepareStatement("SELECT max(id) FROM continents");
        ResultSet result = statement.executeQuery();
        Integer maxId = result.next() ? result.getInt(1) : null;
        return maxId + 1;
    }

    /**
     * Method used to insert a non duplicated continent in the table.<br>
     * In case of a duplicated value, a message is shown in the console.
     * @param name          Name of the continent
     * @throws SQLException Exception
     */
    public void create(String name) throws SQLException {
        Connection con = Database.getConnection();

        if(checkForContinentDuplicates(name) > 0) {
            System.out.println("Continent '" + name + "' already exists in continents table. Cannot insert duplicates.");
        }
        else {
            id = findMaximumId();

            PreparedStatement sql = con.prepareStatement("INSERT INTO continents VALUES(?,?)");
            sql.setInt(1, id);
            sql.setString(2, name);
            sql.executeUpdate();
        }
    }

    /**
     * Method used for finding a continent by their name.
     * @param name      Name to be searched
     * @throws SQLException Exception
     */
    public void findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM continents WHERE name = ?");

        stmt.setString(1, name);
        ResultSet result = stmt.executeQuery();

        if (result.next()) {
            int continentId = result.getInt("id");

            System.out.println(
                    "Searched for continent '" + name +
                            "' - id: " + continentId + ".");
        } else {
            System.out.println("No entry in continents table for '" + name + "'!");
        }
    }

    /**
     * Method used for finding a continent by their identification.
     * @param id      Id to be searched
     * @throws SQLException Exception
     */
    public void findById(int id) throws SQLException {
        Connection con = Database.getConnection();

        PreparedStatement stmt = con.prepareStatement("SELECT * FROM continents where id = ?");
        stmt.setInt(1, id);
        ResultSet result = stmt.executeQuery();

        if (result.next()) {
            String continentName = result.getString("name");

            System.out.println(
                    "Searched for id '" + id +
                            "' - name: " + continentName + ".");
        } else{
            System.out.println("No entry in continents table for id " + id + "!");
        }
    }
}