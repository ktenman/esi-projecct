package ee.ut.library.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ee.ut.library.domain.enums.Category;
import ee.ut.library.domain.enums.Status;
import ee.ut.library.exception.GeneralException;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ee.ut.library.domain.enums.Status.AVAILABLE;
import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Getter
@Setter
public class Book extends Auditable {

    private static final Set<String> LANGUAGES = Stream.of(Locale.getISOLanguages())
            .map(Locale::new)
            .map(Locale::getDisplayLanguage)
            .map(StringUtils::lowerCase)
            .collect(Collectors.toCollection(TreeSet::new));

    private static final String SEQ_BOOK = "seq_book";
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = SEQ_BOOK)
    @SequenceGenerator(name = SEQ_BOOK, sequenceName = SEQ_BOOK, allocationSize = 1)
    private Long id;
    private String author;
    @NotNull
    private String title;
    private LocalDate releaseDate;
    @Enumerated(EnumType.STRING)
    private Status status = AVAILABLE;

    private String language;
    @Convert(converter = CategoryListToStringConverter.class)
    @Column(name = "category")
    private List<Category> categories;

    @JsonIgnore
    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    @OrderBy("id DESC")
    private List<BookRentingRequest> bookRentingRequests;

    @JsonIgnore
    @OneToMany(mappedBy = "book", fetch = FetchType.EAGER)
    @OrderBy("id DESC")
    private List<Review> reviews;

    public void setLanguage(String language) {
        Optional.ofNullable(language)
                .filter(StringUtils::isNotBlank)
                .map(StringUtils::lowerCase)
                .filter(LANGUAGES::contains)
                .orElseThrow(() -> new GeneralException(String.format("%s language not supported", language)));
        this.language = language;
    }
}
