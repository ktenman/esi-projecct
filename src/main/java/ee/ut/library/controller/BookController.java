package ee.ut.library.controller;

import ee.ut.library.domain.entity.Book;
import ee.ut.library.domain.enums.Status;
import ee.ut.library.dto.CreateBookRequest;
import ee.ut.library.dto.UpdateBookRequest;
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

import javax.validation.Valid;
import java.util.List;

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
    public Book insert(@Valid @RequestBody CreateBookRequest createBookRequest) {
        return bookService.insert(createBookRequest);
    }

    @PutMapping
    @ApiOperation(value = "Updates the book")
    public Book update(@Valid @RequestBody UpdateBookRequest updateBookRequest) {
        return bookService.update(updateBookRequest);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete the book by its id")
    public void deleteById(@PathVariable Long id) {
        bookService.deleteById(id);
    }

    @GetMapping("/titles/{title}")
    @ApiOperation(value = "Retrieves books by title")
    public List<Book> getBooksByTitle(@PathVariable String title) {
        return bookService.getBooksByTitle(title);
    }

    @GetMapping("/authors/{author}")
    @ApiOperation(value = "Retrieves books by author")
    public List<Book> getBooksByAuthor(@PathVariable String author) {
        return bookService.getBooksByAuthor(author);
    }

    @GetMapping("/languages/{lang}")
    @ApiOperation(value = "Retrieves books by language")
    public List<Book> getBooksByLanguage(@PathVariable String lang) {
        return bookService.getBooksByLanguage(lang);
    }

    @GetMapping("/statuses/{status}")
    @ApiOperation(value = "Retrieves books by status")
    public List<Book> getBooksByStatus(@PathVariable Status status) {
        return bookService.findAllByStatus(status);
    }

    @GetMapping("/available")
    @ApiOperation(value = "Retrieves available books")
    public List<Book> getAvailableBooks() {
        return bookService.findAllByStatus(Status.AVAILABLE);
    }

    @GetMapping("/years/{year}")
    @ApiOperation(value = "Retrieves books by year")
    public List<Book> getBooksByYear(@PathVariable Integer year) {
        return bookService.getBooksByYear(year);
    }
}
