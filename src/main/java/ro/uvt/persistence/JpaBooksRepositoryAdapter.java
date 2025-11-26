package ro.uvt.persistence;

import org.springframework.stereotype.Component;
import ro.uvt.models.Book;

import java.util.List;
import java.util.Optional;

@Component
public class JpaBooksRepositoryAdapter implements CrudRepository<Book, Long> {
    private final BooksRepository booksRepository;

    public JpaBooksRepositoryAdapter(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @Override
    public List<Book> findAll() {
        return booksRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return booksRepository.findById(id);
    }

    @Override
    public Book save(Book entity) {
        return booksRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        booksRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return booksRepository.existsById(id);
    }
}

