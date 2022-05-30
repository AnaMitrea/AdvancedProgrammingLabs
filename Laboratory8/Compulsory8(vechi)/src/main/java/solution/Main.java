package solution;

import java.sql.Connection;
import dao.ContinentDAO;
import databaseUtil.*;

public class Main {
<<<<<<< HEAD
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Class.forName("org.postgresql.Driver");
        Database.createConnection();
        Connection con = Database.getConnection();

       CreateTables.createCountries();
       CreateTables.createContinents();

        ContinentDAO.create("Africa");
        System.out.println( "ID for Asia is " + ContinentDAO.findByName("Asia") );
        System.out.println( "Continent with id 1 is: " + ContinentDAO.findById(1));
        con.close();
=======
    public static void main(String[] args) {
        try {
            //Class.forName("org.postgresql.Driver");
            Database.createConnection();
            Connection con = Database.getConnection();

            //CreateTables.createCountries();
            //CreateTables.createContinents();

            //ContinentDAO.create("Africa");
            System.out.println("ID for Asia is " + ContinentDAO.findByName("Asia"));
            System.out.println("Continent with id 1 is: " + ContinentDAO.findById(1));
            con.close();
        }catch (Exception e) {
           e.printStackTrace();
        }
>>>>>>> ac156ca940eed3af9c3f89b85393e499ef0ec00f
    }
}
