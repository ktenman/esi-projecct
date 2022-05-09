package ee.ut.library.repository;

import ee.ut.library.domain.entity.Book;
import ee.ut.library.domain.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByStatusIn(Collection<Status> statuses);

    @Query("select b from Book b where year(b.releaseDate) = :year")
    List<Book> findAllByYear(@Param("year") Integer year);

    List<Book> findByAuthorContainingIgnoreCase(String author);
    List<Book> findByTitleContainingIgnoreCase(String title);
    List<Book> findByLanguageLikeIgnoreCase(String language);
}
