package ee.ut.library.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Setter
@Getter
@Table(name = "customer")
public class Customer {
    private static final String SEQ_CUSTOMER = "seq_customer";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_CUSTOMER)
    @SequenceGenerator(name = SEQ_CUSTOMER, sequenceName = SEQ_CUSTOMER, allocationSize = 1)
    private Long id;
    private String name;
    private String address;
    @Column(unique = true)
    private String email;
    private String phoneNumber;
}
