package ee.ut.library.repository;

import ee.ut.library.domain.entity.Customer;
import ee.ut.library.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByUser(User user);
}
