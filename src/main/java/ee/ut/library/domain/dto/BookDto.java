package ee.ut.library.domain.dto;

import ee.ut.library.domain.enums.Category;
import ee.ut.library.domain.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDto {
    private Long id;
    private String title;
    private String author;
    private Integer year;
    private List<Category> categories;
    private Status status;
    private String language;
}
