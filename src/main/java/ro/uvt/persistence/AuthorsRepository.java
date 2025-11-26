package ro.uvt.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.uvt.models.Author;

@Repository
public interface AuthorsRepository extends JpaRepository<Author, Long> {
}

