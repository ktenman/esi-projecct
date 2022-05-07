package ee.ut.library.config;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<Long> {

    @Override
    public Optional<Long> getCurrentAuditor() {
        //  Spring Security to return currently logged user
//TODO: modifiy this part after implementing the security
        return Optional.of(2L);
    }
}
