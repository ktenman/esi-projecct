package ee.ut.library.service;

import java.util.List;

public interface CrudService<T> {

    List<T> findAll();

    T getOne(Long id);

    T insert(T t);

    T update(T t);

    void deleteById(Long id);
}
