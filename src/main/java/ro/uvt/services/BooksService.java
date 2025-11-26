package ro.uvt.services;

import org.springframework.stereotype.Service;
import ro.uvt.models.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class BooksService {

    private final Map<String, Book> books = new ConcurrentHashMap<>();

    public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    public Book getBookById(String id) {
        return books.get(id);
    }

    public Book createBook(Map<String, Object> bookData) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        String isbn = fetchISBNFromExternalService();
        String id = String.valueOf(books.size() + 1);
        String title = (String) bookData.getOrDefault("title", "Untitled");
        String author = (String) bookData.getOrDefault("author", "Unknown");
        
        Book book = new Book(id, title, author, isbn);
        books.put(id, book);
        return book;
    }

    public Book updateBook(String id, Map<String, Object> bookData) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        Book existingBook = books.get(id);
        if (existingBook == null) {
            return null;
        }
        
        String title = (String) bookData.getOrDefault("title", existingBook.getTitle());
        String author = (String) bookData.getOrDefault("author", existingBook.getAuthor());
        
        Book updatedBook = new Book(id, title, author, existingBook.getIsbn());
        books.put(id, updatedBook);
        return updatedBook;
    }

    public boolean deleteBook(String id) {
        return books.remove(id) != null;
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

