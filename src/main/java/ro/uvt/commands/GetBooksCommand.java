package ro.uvt.commands;

import ro.uvt.services.BooksService;

public class GetBooksCommand implements Command {
    private final CommandContext context;

    public GetBooksCommand(CommandContext context) {
        this.context = context;
    }

    @Override
    public Object execute() {
        BooksService booksService = context.getBooksService();
        return booksService.getAllBooks();
    }
}

