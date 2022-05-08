package ee.ut.library.controller;

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


}
