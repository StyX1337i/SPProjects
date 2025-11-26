package ro.uvt.commands;

import ro.uvt.persistence.CrudRepository;
import ro.uvt.models.Book;

import java.util.Optional;

public class GetBookCommand implements Command {
    private final CommandContext context;

    public GetBookCommand(CommandContext context) {
        this.context = context;
    }

    @Override
    public Object execute() {
        CrudRepository<Book, Long> booksRepository = context.getBooksRepository();
        Long id = Long.parseLong((String) context.getData());
        Optional<Book> book = booksRepository.findById(id);
        return book.orElse(null);
    }
}

