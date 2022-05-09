package ee.ut.library;

import ee.ut.library.domain.dto.BookDto;
import ee.ut.library.domain.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookMapper {
    public BookDto bookToDto(Book book) {
        return BookDto.builder()
                .title(book.getTitle())
                .author(book.getAuthor())
                .year(book.getReleaseDate().getYear())
                .categories(book.getCategories())
                .language(book.getLanguage())
                .status(book.getStatus())
                .id(book.getId())
                .build();
    }

    private List<BookDto> booksToDtos(List<Book> books) {
        return books.stream()
                .map(this::bookToDto)
                .collect(Collectors.toList());
    }
}
