package ee.ut.library.domain.entity;

import ee.ut.library.domain.enums.Role;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
public class Authority implements Serializable {
    private static final String SEQ_PAYMENT = "seq_authority";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_PAYMENT)
    @SequenceGenerator(name = SEQ_PAYMENT, sequenceName = SEQ_PAYMENT, allocationSize = 1)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Role role;
}
