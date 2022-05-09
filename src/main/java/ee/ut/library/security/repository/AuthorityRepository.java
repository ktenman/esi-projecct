package ee.ut.library.security.repository;


import ee.ut.library.domain.entity.Authority;
import ee.ut.library.domain.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, String> {
    List<Authority> findByRoleIn(Iterable<Role> roles);

}
