package repositories;

import entity.CountriesEntity;
import entity.ImportedcCountriesEntity;
import managerfactory.EntityManager;

import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class ImportedCountriesRepository implements AbstractRepository<ImportedcCountriesEntity, Integer, String> {

    /**
     * Method used for saving all the entities from a list into the database.
     * @param entities  Entities list to be saved
     */
    @Override
    public void saveAll(List<ImportedcCountriesEntity> entities) {
        for (ImportedcCountriesEntity entity : entities)
            System.out.println("ok");
            //save(entity);
    }

    /**
     * Method used to find by name country a continent in the database.
     * @param name  Name to be searched
     * @return  continent Entity
     */
    @Override
    public ImportedcCountriesEntity findByName(String name) {
        javax.persistence.EntityManager entityManager = EntityManager.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        TypedQuery<ImportedcCountriesEntity> query = entityManager.createNamedQuery("FindByIdObjectName3", ImportedcCountriesEntity.class);
        query.setParameter("name", name);
        entityManager.close();
        return query.getSingleResult();
    }

    /**
     * Method used to find by id criterion a continent in the database.
     * @param id    Id to be searched
     * @return  Country Entity
     */
    @Override
    public ImportedcCountriesEntity findById(Integer id) {
        javax.persistence.EntityManager entityManager = EntityManager.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        TypedQuery<ImportedcCountriesEntity> query = entityManager.createNamedQuery("FindByIdObject3", ImportedcCountriesEntity.class);
        query.setParameter(1, id);
        entityManager.close();
        return query.getSingleResult();
    }

    /**
     * Counts the data from the table
     * @return  Counter
     */
    @Override
    public long count() {
        long count = 0;
        javax.persistence.EntityManager entityManager = EntityManager.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        count = (long) entityManager.createNamedQuery("CountImportedCountries").getSingleResult();
        transaction.commit();
        entityManager.close();
        return count;
    }

    /**
     * Imports an entity into the table.
     * @param entity    Country entity
     */
    @Override
    public void create(ImportedcCountriesEntity entity) {
        javax.persistence.EntityManager entityManager = EntityManager.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(entity);
        transaction.commit();
        entityManager.close();
    }

    /**
     * Checks if a country id exists in the table
     * @param id    Id
     * @return  Boolean value
     */
    @Override
    public boolean existsById(Integer id) {
        javax.persistence.EntityManager entityManager = EntityManager.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        String name = String.valueOf(entityManager.createNamedQuery("ExistsById4")
                .setParameter(1, id)
                .getResultList());
        transaction.commit();
        entityManager.close();
        if(name.equals("0"))
            return false;
        else
            return true;
    }

    /**
     * Check if a name exists in the table
     * @param name  Name
     * @return  Boolean
     */
    @Override
    public boolean existsByName(String name) {
        javax.persistence.EntityManager entityManager = EntityManager.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        String id = String.valueOf(entityManager.createNamedQuery("ExistsByName4")
                .setParameter("name", name)
                .getResultList());
        transaction.commit();
        entityManager.close();
        if(id.equals("0"))
            return false;
        else
            return true;
    }
}
