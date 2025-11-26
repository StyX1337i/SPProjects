package ro.uvt.commands;

import ro.uvt.persistence.CrudRepository;
import ro.uvt.models.Book;

public class GetBooksCommand implements Command {
    private final CommandContext context;

    public GetBooksCommand(CommandContext context) {
        this.context = context;
    }

    @Override
    public Object execute() {
        CrudRepository<Book, Long> booksRepository = context.getBooksRepository();
        return booksRepository.findAll();
    }
}

