package ee.ut.library.service;

import ee.ut.library.domain.dto.CreateBookRequest;
import ee.ut.library.domain.dto.UpdateBookRequest;
import ee.ut.library.domain.entity.Book;
import ee.ut.library.domain.enums.Status;

import java.util.List;

public interface BookService extends CrudService<Book> {
    List<Book> findAllByStatus(Status... statuses);

    List<Book> getBooksByYear(Integer integer);

    List<Book> getBooksByAuthor(String author);

    List<Book> getBooksByTitle(String title);

    List<Book> getBooksByLanguage(String language);

    Book insert(CreateBookRequest createBookRequest);

    Book update(UpdateBookRequest updateBookRequest);
}
