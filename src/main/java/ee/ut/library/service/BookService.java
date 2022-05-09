package ee.ut.library.service;

import ee.ut.library.domain.entity.Book;
import ee.ut.library.domain.enums.Status;

import java.util.List;

public interface BookService extends CrudService<Book> {
    List<Book> findAllByStatus(Status... statuses);

    List<Book> getBooksByYear(Integer integer);
}
