package ee.ut.library.config;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;
import java.util.UUID;

public class AuditorAwareImpl implements AuditorAware<UUID> {

    @Override
    public Optional<UUID> getCurrentAuditor() {
        //  Spring Security to return currently logged user
//TODO: modifiy this part after implementing the security
        return Optional.ofNullable(UUID.randomUUID());
    }
}