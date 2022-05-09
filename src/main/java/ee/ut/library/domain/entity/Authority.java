package ee.ut.library.domain.entity;

import ee.ut.library.domain.enums.Role;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Setter
@Getter
@Table(name = "\"authority\"")
public class Authority implements Serializable {
    private static final String SEQ_AUTHORITY = "seq_authority";

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = SEQ_AUTHORITY)
    @SequenceGenerator(name = SEQ_AUTHORITY, sequenceName = SEQ_AUTHORITY, allocationSize = 1)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Role role;
}
