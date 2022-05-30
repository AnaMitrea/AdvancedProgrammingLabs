package repositories;

import entity.CountriesEntity;
import managerfactory.EntityManager;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class CountriesEntityRepository implements AbstractRepository<CountriesEntity, Integer, String> {

    /**
     * Method used for saving all the entities from a list into the database.
     * @param entities  Entities list to be saved
     */
    @Override
    public void saveAll(List<CountriesEntity> entities) {
        for (CountriesEntity entity : entities)
            System.out.println("ok");
            //save(entity);
    }

    /**
     * Method used to find by name criterion a continent in the database.
     * @param name  Name to be searched
     * @return  Country Entity
     */
    @Override
    public CountriesEntity findByName(String name) {
        javax.persistence.EntityManager entityManager = EntityManager.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        TypedQuery<CountriesEntity> query = entityManager.createNamedQuery("FindByIdObjectName2", CountriesEntity.class);
        query.setParameter("name", name);
        CountriesEntity returnedResult = query.getSingleResult();
        entityManager.close();
        transaction.commit();
        return returnedResult;
    }

    /**
     * Method used to find by id criterion a continent in the database.
     * @param id    Id to be searched
     * @return  Country Entity
     */
    @Override
    public CountriesEntity findById(Integer id) {
        javax.persistence.EntityManager entityManager = EntityManager.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        TypedQuery<CountriesEntity> query = entityManager.createNamedQuery("FindByIdObject2", CountriesEntity.class);
        query.setParameter(1, id);
        CountriesEntity returnedResult = query.getSingleResult();
        entityManager.close();
        transaction.commit();
        return returnedResult;
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
        count = (long) entityManager.createNamedQuery("CountCountries").getSingleResult();
        transaction.commit();
        entityManager.close();
        return count;
    }

    /**
     * Imports an entity into the table.
     * @param entity    Country entity
     */
    @Override
    public void create(CountriesEntity entity) {
        javax.persistence.EntityManager entityManager = EntityManager.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(entity);
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
        String name = String.valueOf(entityManager.createNamedQuery("ExistsById2")
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
        String id = String.valueOf(entityManager.createNamedQuery("ExistsByName2")
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
