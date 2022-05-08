package ee.ut.library.domain.entity;

import ee.ut.library.domain.enums.UserType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "\"user\"")
public class User extends Auditable {
    private static final String SEQ_PAYMENT = "seq_user";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_PAYMENT)
    @SequenceGenerator(name = SEQ_PAYMENT, sequenceName = SEQ_PAYMENT, allocationSize = 1)
    private Long id;
    @NotNull
    @Size(min = 4, max = 50)
    private String username;
    @NotNull
    @Size(min = 4, max = 100)
    private String password;
    @NotNull
    @Size(min = 2, max = 50)
    private String firstName;
    @NotNull
    @Size(min = 2, max = 50)
    private String lastName;
    @Email
    @Column(unique = true, nullable = false)
    private String email;
    private String address;
    private boolean activated;
    @Enumerated(EnumType.STRING)
    private UserType type;
    private String phoneNumber;
    @ManyToMany
    @JoinTable(name = "user_authority",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_id", referencedColumnName = "id")})
    private Set<Authority> authorities;
}
