package ee.ut.library.service.impl;

import ee.ut.library.domain.entity.Book;
import ee.ut.library.domain.enums.Status;
import ee.ut.library.exception.BookNotFoundException;
import ee.ut.library.repository.BookRepository;
import ee.ut.library.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
        return bookRepository.save(book);
    }

    @Override
    public Book update(Book book) {
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
}
