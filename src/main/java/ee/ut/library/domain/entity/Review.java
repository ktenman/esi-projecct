package ee.ut.library.domain.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Getter
@Setter
public class Review extends Auditable {
    private static final String SEQ_REVIEW = "seq_review";

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = SEQ_REVIEW)
    @SequenceGenerator(name = SEQ_REVIEW, sequenceName = SEQ_REVIEW, allocationSize = 1)
    private Long id;

    @ManyToOne(optional = false)
    @NotNull
    private Book book;

    private Integer score;

    private String comment;

}
