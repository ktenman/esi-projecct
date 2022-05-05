package ee.ut.library.config;

import ee.ut.library.security.SecurityUtils;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        //  Spring Security to return currently logged user
        return SecurityUtils.getCurrentUsername();
    }
}