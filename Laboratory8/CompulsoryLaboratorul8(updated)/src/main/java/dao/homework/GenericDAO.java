package dao.homework;

import oopmodel.TableClass;

import java.sql.SQLException;

public abstract class GenericDAO {
    /**
     * Abstract method used for finding Cities/Countries/Continents by their name.
     * @param name  Name to be searched
     * @return      Object containing the information
     * @throws SQLException Exception
     */
    public abstract TableClass findByName(String name) throws SQLException;

    /**
     * Abstract method used for finding Cities/Countries/Continents by their id.
     * @param id    Id to be searched
     * @return      Object containing the information
     * @throws SQLException Exception
     */
    public abstract TableClass findById(int id) throws SQLException;
}
