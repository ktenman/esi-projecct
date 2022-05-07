package ee.ut.library.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import java.util.function.Consumer;

import static javax.persistence.GenerationType.SEQUENCE;

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
    @GeneratedValue(strategy = SEQUENCE, generator = SEQ_CUSTOMER)
    @SequenceGenerator(name = SEQ_CUSTOMER, sequenceName = SEQ_CUSTOMER, allocationSize = 1)
    private Long id;
    private String name;
    private String address;
    @NotNull
    @Column(unique = true, nullable = false)
    private String email;
    private String phoneNumber;
    @NotNull
    @Column(unique = true, nullable = false)
    private String idCode;
    private BigDecimal fineAmount = BigDecimal.ZERO;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    @OrderBy("id DESC")
    private List<Payment> payments;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    @OrderBy("id DESC")
    private List<BookRentingRequest> bookRentingRequests;
}
