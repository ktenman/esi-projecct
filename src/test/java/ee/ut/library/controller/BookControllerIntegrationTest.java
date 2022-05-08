package ee.ut.library.controller;

import ee.ut.library.IntegrationTestBase;
import ee.ut.library.domain.entity.Book;
import ee.ut.library.domain.enums.Category;
import ee.ut.library.domain.enums.Status;
import ee.ut.library.exception.CustomExceptionHandler;
import ee.ut.library.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WithMockUser(username = "John", authorities = {"LIBRARIAN"})
class BookControllerIntegrationTest extends IntegrationTestBase {

    @Resource
    BookRepository bookRepository;

    @Resource
    BookController bookController;

    @BeforeEach
    void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(bookController)
                .setControllerAdvice(new CustomExceptionHandler())
                .build();
    }

    @Test
    void insertBook() throws Exception {
        assertThat(bookRepository.findAll()).isEmpty();

        Book book = new Book();
        book.setLanguage("English");
        book.setAuthor("Mark Twain");
        book.setTitle("The Adventures of Tom Sawyer");
        book.setReleaseDate(LocalDate.ofYearDay(1876,1));
        book.setCategories(List.of(Category.CHILDREN_S, Category.ACTION_AND_ADVENTURE, Category.YOUNG_ADULT));
        book.setStatus(Status.AVAILABLE);

        mockMvc.perform(post("/books")
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(book)))
                .andExpect(status().isOk());

        assertThat(bookRepository.findAll()).hasSize(1);
    }

    @Test
    void insertBook_missingLanguage() throws Exception {
        assertThat(bookRepository.findAll()).isEmpty();

        Book book = new Book();
        book.setAuthor("Mark Twain");
        book.setTitle("The Adventures of Tom Sawyer");
        book.setReleaseDate(LocalDate.ofYearDay(1876,1));
        book.setCategories(List.of(Category.CHILDREN_S, Category.ACTION_AND_ADVENTURE, Category.YOUNG_ADULT));
        book.setStatus(Status.AVAILABLE);

        mockMvc.perform(post("/books")
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(book)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.title").value("Internal Error"))
                .andExpect(jsonPath("$.message").value("null language not supported"));

        assertThat(bookRepository.findAll()).isEmpty();
    }

}
