package ee.ut.library;

import ee.ut.library.domain.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    private Long userId;

    @NotNull
    @Size(min = 4, max = 50)
    private String userName;
    @NotNull
    @Size(min = 4, max = 50)
    private String passWord;
    @NotNull
    @Size(min = 2, max = 50)
    private String firstName;
    @NotNull
    @Size(min = 2, max = 50)
    private String lastName;
    @Email
    private String email;
    private String address;
    private String phoneNumber;
    private String idCode;
    @NotEmpty
    private Set<Role> roles;
    @Builder.Default
    private BigDecimal fineAmount = BigDecimal.ZERO;
    @Builder.Default
    private boolean activated = true;

}
