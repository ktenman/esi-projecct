package ee.ut.library.domain.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import java.math.BigDecimal;
import java.time.Instant;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Getter
@Setter
public class BookRentingRequest extends Auditable {
    private static final String SEQ_BOOK_RENTING_REQUEST = "seq_book_renting_request";
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = SEQ_BOOK_RENTING_REQUEST)
    @SequenceGenerator(name = SEQ_BOOK_RENTING_REQUEST, sequenceName = SEQ_BOOK_RENTING_REQUEST, allocationSize = 1)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Status status = Status.OPEN;

    private Instant rentedAt;
    private Instant rentedUntil;
    @ManyToOne(optional = false)
    @NotNull
    private Customer customer;
    @ManyToOne(optional = false)
    @NotNull
    private Book book;

    private BigDecimal fineAmount;

    public enum Status {
        OPEN, CANCELLED, DECLINED, EXPIRED, RENTED
    }
}
