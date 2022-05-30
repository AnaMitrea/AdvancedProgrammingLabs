package repositories;

import entity.CitiesEntity;
import entity.ContinentsEntity;
import managerfactory.EntityManager;

import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class CitiesEntityRepository implements AbstractRepository<CitiesEntity, Integer, String> {

    /**
     * Method used for saving all the entities from a list into the database.
     * @param entities  Entities list to be saved
     */
    @Override
    public void saveAll(List<CitiesEntity> entities) {
        javax.persistence.EntityManager entityManager = EntityManager.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        int count=0;
        for (CitiesEntity entity : entities) {
            if(count<=10_000) {
                String current = String.valueOf(entityManager.createNativeQuery("select max(id) from cities").getSingleResult());


                int maxim = Integer.parseInt(current);
                maxim += 1;
                //System.out.println("max=" + maxim + " " + entity.getName() + " " + entity.getLongitude().substring(0, 6) + " " + entity.getLatitude());
                String name = entity.getName();
                String longitude = entity.getLongitude();
                String latitude = entity.getLatitude();
                //System.out.println(name+" "+latitude+" "+longitude.substring(0,5));
                entityManager.createNativeQuery("INSERT INTO cities (id,name,latitude,longitude) VALUES (:id,:name,:latitude,:longitude)")
                        .setParameter("id", maxim)
                        .setParameter("name", name)
                        .setParameter("latitude", latitude.substring(0, 4))
                        .setParameter("longitude", longitude.substring(0, 4)).executeUpdate();


            }
            count++;

        }
        transaction.commit();
        entityManager.close();
        // System.out.println(entity.getName()+" "+entity.getLatitude()+" "+entity.getLongitude().substring(0,6));
    }

    /**
     * Method used to find by name criterion a city in the database.
     * @param name  Name to be searched
     * @return  City Entity
     */
    @Override
    public CitiesEntity findByName(String name) {
        javax.persistence.EntityManager entityManager = EntityManager.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        TypedQuery<CitiesEntity> query = entityManager.createNamedQuery("FindByIdObjectName", CitiesEntity.class);
        query.setParameter("name", name);
        transaction.commit();
        CitiesEntity returnedResult = query.getSingleResult();
        entityManager.close();
        return returnedResult;
    }

    /**
     * Method used to find by id criterion a city in the database.
     * @param id    Id to be searched
     * @return  City Entity
     */
    @Override
    public CitiesEntity findById(Integer id) {
        javax.persistence.EntityManager entityManager = EntityManager.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        TypedQuery<CitiesEntity> query = entityManager.createNamedQuery("FindByIdObject", CitiesEntity.class);
        query.setParameter(1, id);
        transaction.commit();
        entityManager.close();
        CitiesEntity returnedResult = query.getSingleResult();
        entityManager.close();
        return returnedResult;
    }

    /**
     * Counts the data from the table
     * @return  counter
     */
    @Override
    public long count() {
        long count = 0;
        javax.persistence.EntityManager entityManager = EntityManager.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        count = (long) entityManager.createNamedQuery("CountCities").getSingleResult();
        transaction.commit();
        entityManager.close();
        return count;
    }

    /**
     * Imports an entity into the table.
     * @param entity    City entity
     */
    @Override
    public void create(CitiesEntity entity) {
        javax.persistence.EntityManager entityManager = EntityManager.getEntityManagerFactory().createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(entity);
        transaction.commit();
        entityManager.close();
    }

    /**
     * Checks if a city id exists in the table
     * @param id    Id
     * @return  Boolean value
     */
    @Override
    public boolean existsById(Integer id) {
        javax.persistence.EntityManager entityManager = EntityManager.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        String name = String.valueOf(entityManager.createNamedQuery("ExistsById")
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
     *Check if a name exists in the table
     * @param name  Name
     * @return  Boolean
     */
    @Override
    public boolean existsByName(String name) {
        javax.persistence.EntityManager entityManager = EntityManager.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        String id = String.valueOf(entityManager.createNamedQuery("ExistsByName")
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
