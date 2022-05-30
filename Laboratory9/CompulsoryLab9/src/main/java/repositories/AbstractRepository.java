package repositories;

import java.util.List;

public interface AbstractRepository<T, ID, NAME> {

    void create(T entity);

    long count();

    boolean existsById(ID id);

    boolean existsByName(NAME name);

    T findById(ID id);

    T findByName(NAME name);

    void saveAll(List<T> entities);

}