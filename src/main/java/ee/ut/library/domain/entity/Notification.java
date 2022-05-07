package ee.ut.library.domain.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Getter
@Setter
public class Notification extends Auditable {

    private static final String SEQ_NOTIFICATION = "seq_notification";

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = SEQ_NOTIFICATION)
    @SequenceGenerator(name = SEQ_NOTIFICATION, sequenceName = SEQ_NOTIFICATION, allocationSize = 1)
    private Long id;

    @ManyToOne(optional = false)
    @NotNull
    private Customer customer;

    @ManyToOne(optional = false)
    @NotNull
    @JoinColumn(name = "renting_id")
    private BookRentingRequest bookRentingRequest;

    private String message;
}
