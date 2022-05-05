package ee.ut.library.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
