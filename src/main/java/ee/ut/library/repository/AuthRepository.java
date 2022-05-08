package ee.ut.library.repository;

import ee.ut.library.domain.entity.Authority;
import ee.ut.library.domain.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthRepository extends JpaRepository<Authority, Long> {
    List<Authority> findByRoleIn(Iterable<Role> roles);
}
