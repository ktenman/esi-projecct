package ee.ut.library.service.impl;

import ee.ut.library.domain.dto.CreateBookRequest;
import ee.ut.library.domain.dto.UpdateBookRequest;
import ee.ut.library.domain.entity.Book;
import ee.ut.library.domain.enums.Status;
import ee.ut.library.exception.BookNotFoundException;
import ee.ut.library.repository.BookRepository;
import ee.ut.library.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book getOne(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
    }

    @Override
    public Book insert(Book book) {
        return null;
    }

    @Override
    public Book update(Book book) {
        return null;
    }

    public Book insert(CreateBookRequest createBookRequest) {
        Book book = new Book();
        fillBookFields(createBookRequest, book);
        return bookRepository.save(book);
    }

    private void fillBookFields(CreateBookRequest createBookRequest, Book book) {
        book.setLanguage(createBookRequest.getLanguage());
        book.setStatus(Status.AVAILABLE);
        book.setTitle(createBookRequest.getTitle());
        book.setAuthor(createBookRequest.getAuthor());
        book.setReleaseDate(LocalDate.ofYearDay(createBookRequest.getYear(), 1));
        book.setCategories(createBookRequest.getCategories());
    }

    public Book update(UpdateBookRequest updateBookRequest) {
        Book book = bookRepository.findById(updateBookRequest.getId())
                .orElseThrow(() -> new BookNotFoundException(updateBookRequest.getId()));
        fillBookFields(updateBookRequest, book);
        return bookRepository.save(book);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> findAllByStatus(Status... statuses) {
        return bookRepository.findAllByStatusIn(Set.of(statuses));
    }

    @Override
    public List<Book> getBooksByYear(Integer year) {
        return bookRepository.findAllByYear(year);
    }

    @Override
    public List<Book> getBooksByAuthor(String author) {
        return bookRepository.findByAuthorContainingIgnoreCase(author);
    }

    @Override
    public List<Book> getBooksByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }

    @Override
    public List<Book> getBooksByLanguage(String language) {
        return bookRepository.findByLanguageLikeIgnoreCase(language);
    }
}
