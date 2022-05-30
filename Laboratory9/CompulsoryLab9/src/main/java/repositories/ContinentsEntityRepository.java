package repositories;

import entity.ContinentsEntity;
import entity.CountriesEntity;
import managerfactory.EntityManager;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class ContinentsEntityRepository implements AbstractRepository<ContinentsEntity, Integer, String> {

    /**
     * Method used for saving all the entities from a list into the database.
     * @param entities  Entities list to be saved
     */
    @Override
    public void saveAll(List<ContinentsEntity> entities) {
        for (ContinentsEntity entity : entities)
            System.out.println("ok");
           // save(entity);
    }

    /**
     * Method used to find by name criterion a continent in the database.
     * @param name  Name to be searched
     * @return  continent Entity
     */
    @Override
    public ContinentsEntity findByName(String name) {
        javax.persistence.EntityManager entityManager = EntityManager.getEntityManagerFactory().createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        TypedQuery<ContinentsEntity> query = entityManager.createNamedQuery("FindByIdObjectName1", ContinentsEntity.class);
        query.setParameter("name", name);
        ContinentsEntity returnedResult = query.getSingleResult();
        entityManager.close();
        return returnedResult;
    }

    /**
     * Method used to find by id criterion a continent in the database.
     * @param id    Id to be searched
     * @return  Continent Entity
     */
    @Override
    public ContinentsEntity findById(Integer id) {
        javax.persistence.EntityManager entityManager = EntityManager.getEntityManagerFactory().createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        TypedQuery<ContinentsEntity> query = entityManager.createNamedQuery("FindByIdObject1", ContinentsEntity.class);
        query.setParameter(1, id);
        ContinentsEntity returnedResult = query.getSingleResult();
        entityManager.close();
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
        count = (long) entityManager.createNamedQuery("CountContinents").getSingleResult();
        transaction.commit();
        entityManager.close();
        return count;
    }

    /**
     * Imports an entity into the table.
     * @param entity    Continent entity
     */
    @Override
    public void create(ContinentsEntity entity) {
        javax.persistence.EntityManager entityManager = EntityManager.getEntityManagerFactory().createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    /**
     * Checks if a continent id exists in the table
     * @param id    Id
     * @return  Boolean value
     */
    @Override
    public boolean existsById(Integer id) {
        javax.persistence.EntityManager entityManager = EntityManager.getEntityManagerFactory().createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        String name = String.valueOf(entityManager.createNamedQuery("ExistsById1")
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
     * Check if a name exists
     * @param name  Name
     * @return  Boolean
     */
    @Override
    public boolean existsByName(String name) {
        javax.persistence.EntityManager entityManager = EntityManager.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        String id = String.valueOf(entityManager.createNamedQuery("ExistsByName1")
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
