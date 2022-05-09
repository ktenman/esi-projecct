package ee.ut.library.repository;

import ee.ut.library.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findOneWithAuthoritiesByUsername(String username);

    Optional<User> findOneWithAuthoritiesByEmailIgnoreCase(String email);
}
