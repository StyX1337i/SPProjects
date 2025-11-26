package ro.uvt.commands;

import ro.uvt.persistence.CrudRepository;
import ro.uvt.models.Book;

import java.util.Map;

public class CreateBookCommand implements Command {
    private final CommandContext context;

    public CreateBookCommand(CommandContext context) {
        this.context = context;
    }

    @Override
    public Object execute() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        String isbn = fetchISBNFromExternalService();
        CrudRepository<Book, Long> booksRepository = context.getBooksRepository();
        Map<String, Object> bookData = (Map<String, Object>) context.getData();
        
        String title = (String) bookData.getOrDefault("title", "Untitled");
        Book book = new Book(title, isbn);
        
        book = booksRepository.save(book);
        
        AllBooksSubject allBooksSubject = context.getAllBooksSubject();
        if (allBooksSubject != null) {
            allBooksSubject.add(book);
        }
        
        return book;
    }

    private String fetchISBNFromExternalService() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "ISBN-" + System.currentTimeMillis();
    }
}

