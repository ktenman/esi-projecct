package ee.ut.library.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.util.function.Consumer;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Customer extends Auditable {
    private static final String SEQ_CUSTOMER = "seq_customer";

    public Customer(Consumer<Customer> builder) {
        builder.accept(this);
    }

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
