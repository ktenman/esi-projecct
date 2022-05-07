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
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import java.util.Map;

@Entity
@Getter
@Setter
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class Payment {
    private static final String SEQ_PAYMENT = "seq_librarian";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_PAYMENT)
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
