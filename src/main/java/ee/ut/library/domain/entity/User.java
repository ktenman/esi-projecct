package ee.ut.library.domain.entity;

import ee.ut.library.domain.enums.UserType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;
import java.util.function.Consumer;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Setter
@Getter
@Table(name = "\"user\"")
@NoArgsConstructor
public class User extends Auditable {
    private static final String SEQ_USER = "seq_user";

    public User(Consumer<User> builder) {
        builder.accept(this);
    }

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = SEQ_USER)
    @SequenceGenerator(name = SEQ_USER, sequenceName = SEQ_USER, allocationSize = 1)
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
    private boolean activated = true;
    @Enumerated(EnumType.STRING)
    private UserType type;
    private String phoneNumber;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_authority",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_id", referencedColumnName = "id")})
    private Set<Authority> authorities;
}
