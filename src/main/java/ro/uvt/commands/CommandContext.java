package ro.uvt.commands;

import ro.uvt.persistence.CrudRepository;
import ro.uvt.models.Book;

public class CommandContext {
    private CrudRepository<Book, Long> booksRepository;
    private Object data;
    private Long id;

    public CommandContext(CrudRepository<Book, Long> booksRepository, Object data) {
        this.booksRepository = booksRepository;
        this.data = data;
    }

    public CrudRepository<Book, Long> getBooksRepository() {
        return booksRepository;
    }

    public Object getData() {
        return data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

