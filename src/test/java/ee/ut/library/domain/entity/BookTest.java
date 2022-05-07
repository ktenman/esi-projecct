package ee.ut.library.domain.entity;

import ee.ut.library.exception.GeneralException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class BookTest {

    Book book = new Book();

    @Test
    void setLanguage() {
        Throwable thrown = catchThrowable(() -> book.setLanguage("estonian"));

        assertThat(thrown).isNull();
    }

    @Test
    void setLanguage_exceptionThrown() {

        Throwable thrown = catchThrowable(() -> book.setLanguage("estonia"));

        assertThat(thrown).isInstanceOf(GeneralException.class)
                .hasMessage("estonia language not supported");
    }


}
