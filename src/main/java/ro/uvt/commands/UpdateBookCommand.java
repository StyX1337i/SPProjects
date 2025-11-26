package ro.uvt.commands;

import ro.uvt.persistence.CrudRepository;
import ro.uvt.models.Book;

import java.util.Map;
import java.util.Optional;

public class UpdateBookCommand implements Command {
    private final CommandContext context;

    public UpdateBookCommand(CommandContext context) {
        this.context = context;
    }

    @Override
    public Object execute() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        CrudRepository<Book, Long> booksRepository = context.getBooksRepository();
        Long id = context.getId();
        Map<String, Object> bookData = (Map<String, Object>) context.getData();
        
        Optional<Book> existingBookOpt = booksRepository.findById(id);
        if (!existingBookOpt.isPresent()) {
            return null;
        }
        
        Book existingBook = existingBookOpt.get();
        String title = (String) bookData.getOrDefault("title", existingBook.getTitle());
        
        existingBook.setTitle(title);
        return booksRepository.save(existingBook);
    }
}

