import dao.compulsory.CountryDAO;
import databaseUtil.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import solution.Compulsory;
import java.sql.Connection;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;

class CompulsoryTest {

    Compulsory compulsory;
    Connection con;

    @BeforeEach
    void setUp() {
        System.out.println("Setup before test");
        compulsory = new Compulsory();
        con = Database.getConnection();
        compulsory.createTables();
    }

    @Test
    @DisplayName("Testing to check Brazil isn't in the countries table")
    void testBrazil() throws SQLException {
        CountryDAO countriesDAO = new CountryDAO();
        assertEquals(0, countriesDAO.checkForCountryDuplicates("Brazil"),
                "Brazil isn't in the DB");
    }

    @Test
    @DisplayName("Testing to check Romania is in the countries table")
    void testRomania() throws SQLException {
        CountryDAO countriesDAO = new CountryDAO();
        assertEquals(1, countriesDAO.checkForCountryDuplicates("Romania"),
                "Romania is in the countries table");
    }
}