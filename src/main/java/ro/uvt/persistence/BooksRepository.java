package ro.uvt.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.uvt.models.Book;

@Repository
public interface BooksRepository extends JpaRepository<Book, Long> {
}

