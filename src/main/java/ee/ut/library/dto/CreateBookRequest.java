package ee.ut.library.dto;

import ee.ut.library.domain.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class CreateBookRequest {
    @NotBlank
    @Size(min = 2)
    private String title;
    @NotBlank
    @Size(min = 2)
    private String author;
    @NotNull
    private Integer year;
    @NotEmpty
    private List<Category> categories;
    @NotBlank
    private String language;
}
