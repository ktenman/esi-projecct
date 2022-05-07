package ee.ut.library.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@Getter
@Setter
public class Librarian extends Auditable {
    private static final String SEQ_LIBRARIAN = "seq_librarian";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_LIBRARIAN)
    @SequenceGenerator(name = SEQ_LIBRARIAN, sequenceName = SEQ_LIBRARIAN, allocationSize = 1)
    private Long id;
    private String name;
    private String address;
    @Column(unique = true)
    private String email;
    private String phoneNumber;


}
