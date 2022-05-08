package ee.ut.library.controller;

import ee.ut.library.domain.enums.Status;
import ee.ut.library.domain.entity.Book;
import ee.ut.library.service.BookService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.*;
import javax.validation.Valid;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@RestController
@AllArgsConstructor
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    @GetMapping
    @ApiOperation(value = "Retrieves all books")
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Retrieves the book by its id")
    public Book get(@PathVariable Long id) {
        return bookService.getOne(id);
    }

    @PostMapping
    @ApiOperation(value = "Inserts new book")
    public Book insert(@Valid @RequestBody Book book) {
        return bookService.insert(book);
    }

    @PutMapping
    @ApiOperation(value = "Updates the book")
    public Book update(@Valid @RequestBody Book book) {
        return bookService.update(book);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete the book by its id")
    public void deleteById(@PathVariable Long id) {
        bookService.deleteById(id);
    }

    @GetMapping("/titles/{title}")
    @ApiOperation(value = "Retrieves books by title")
    public List<Book> getBooksByTitle(@PathVariable String title) {
        List<Book> books = bookService.findAll();
        // Regex to match the title
        books.removeIf(book -> !Pattern.matches(title, book.getTitle()));
        return books;
    }

    @GetMapping("/authors/{author}")
    @ApiOperation(value = "Retrieves books by author")
    public List<Book> getBooksByAuthor(@PathVariable String author) {
        List<Book> books = bookService.findAll();
        books.removeIf(book -> !Pattern.matches(author, book.getAuthor()));
        return books;
    }

    @GetMapping("/languages/{lang}")
    @ApiOperation(value = "Retrieves books by language")
    public List<Book> getBooksByLanguage(@PathVariable String lang) {
        List<Book> books = bookService.findAll();
        books.removeIf(book -> !book.getLanguage().equals(lang));
        return books;
    }

    @GetMapping("/statuses/{status}")
    @ApiOperation(value = "Retrieves books by status")
    public List<Book> getBooksByStatus(@PathVariable String status) {
        List<Book> books = bookService.findAll();
        books.removeIf(book -> !book.getStatus().equals(status));
        return books;
    }

    @GetMapping("/years/{year}")
    @ApiOperation(value = "Retrieves books by year")
    public List<Book> getBooksByYear(@PathVariable String year) {
        List<Book> books = bookService.findAll();
        books.removeIf(book -> !book.getReleaseDate().equals(year));
        return books;
    }

    @GetMapping("/available")
    @ApiOperation(value = "Retrieves available books")
    public List<Book> getAvailableBooks() {
        List<Book> books = bookService.findAll();
        books.removeIf(book -> !book.getStatus().equals(Status.AVAILABLE));
        return books;
    }
}
