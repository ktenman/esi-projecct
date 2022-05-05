package ee.ut.library.service;

import java.util.List;
import java.util.UUID;

public interface CrudService<T> {

    List<T> getAll();

    T get(Long id);

    T insert(T t);

    T update(T t);

    void delete(Long id);
}
