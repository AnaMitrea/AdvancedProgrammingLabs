package dao.homework;

import databaseUtil.Database;
import oopmodel.Continent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GenericContinentDAO extends GenericDAO{
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
    public Continent create(String name) throws SQLException {
        Connection con = Database.getConnection();

        if(checkForContinentDuplicates(name) > 0) {
            System.out.print("Continent '" + name + "' already exists in continents table. Cannot insert duplicates. - returned ");
        }
        else {
            id = findMaximumId();

            PreparedStatement sql = con.prepareStatement("INSERT INTO continents VALUES(?,?)");
            sql.setInt(1, id);
            sql.setString(2, name);
            sql.executeUpdate();

            return new Continent(id, name);
        }
        return null;
    }


    /**
     * Method used for finding a continent by their name.
     * @param name  Name to be searched
     * @return  The continent object containing all the information
     * @throws SQLException Exception
     */
    @Override
    public Continent findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        PreparedStatement statement = con.prepareStatement("SELECT * FROM continents WHERE name = ?");
        statement.setString(1,name);
        ResultSet result = statement.executeQuery();

        if (result.next()) {
            int continentId = result.getInt("id");
            String continentName = result.getString("name");

            System.out.print("Found in continents table the entry");
            return new Continent(continentId, continentName);
        }
        System.out.print("No entry in continents table for '" + name + "'! - returned ");
        return null;
    }

    /**
     * Method used for finding a continent by their id.
     * @param id  Name to be searched
     * @return  The continent object containing all the information
     * @throws SQLException Exception
     */
    @Override
    public Continent findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        PreparedStatement statement = con.prepareStatement("SELECT * FROM continents WHERE id = ?");
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();

        if (result.next()) {
            int continentId = result.getInt("id");
            String continentName = result.getString("name");

            System.out.print("Found in continents table the entry");
            return new Continent(continentId, continentName);
        }
        System.out.print("No entry in continents table for id '" + id + "'! - returned ");
        return null;
    }
}
