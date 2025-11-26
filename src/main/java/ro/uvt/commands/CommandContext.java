package ro.uvt.commands;

import ro.uvt.persistence.CrudRepository;
import ro.uvt.models.Book;
import ro.uvt.observer.AllBooksSubject;

public class CommandContext {
    private CrudRepository<Book, Long> booksRepository;
    private Object data;
    private Long id;
    private AllBooksSubject allBooksSubject;

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

    public AllBooksSubject getAllBooksSubject() {
        return allBooksSubject;
    }

    public void setAllBooksSubject(AllBooksSubject allBooksSubject) {
        this.allBooksSubject = allBooksSubject;
    }
}

