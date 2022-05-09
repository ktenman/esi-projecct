package ee.ut.library.repository;

import ee.ut.library.domain.entity.Book;
import ee.ut.library.domain.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByStatusIn(Collection<Status> statuses);
}
