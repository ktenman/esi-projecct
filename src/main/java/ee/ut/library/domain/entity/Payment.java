package ee.ut.library.domain.entity;

import com.sun.istack.NotNull;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import java.util.Map;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Getter
@Setter
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class Payment extends Auditable {
    private static final String SEQ_PAYMENT = "seq_payment";

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = SEQ_PAYMENT)
    @SequenceGenerator(name = SEQ_PAYMENT, sequenceName = SEQ_PAYMENT, allocationSize = 1)
    private Long id;

    @NotNull
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private Map<String, String> details;

    @ManyToOne(optional = false)
    @NotNull
    private Customer customer;

}
