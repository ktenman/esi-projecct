package ee.ut.library.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Setter
@Getter
@Table(name = "\"user\"")
public class User extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    @Column(unique = true)
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}
