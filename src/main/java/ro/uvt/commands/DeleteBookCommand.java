package ro.uvt.commands;

import ro.uvt.persistence.CrudRepository;
import ro.uvt.models.Book;

public class DeleteBookCommand implements Command {
    private final CommandContext context;

    public DeleteBookCommand(CommandContext context) {
        this.context = context;
    }

    @Override
    public Object execute() {
        CrudRepository<Book, Long> booksRepository = context.getBooksRepository();
        Long id = Long.parseLong((String) context.getData());
        boolean exists = booksRepository.existsById(id);
        if (exists) {
            booksRepository.deleteById(id);
        }
        return exists;
    }
}

