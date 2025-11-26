package ro.uvt.commands;

import ro.uvt.services.BooksService;

public class DeleteBookCommand implements Command {
    private final CommandContext context;

    public DeleteBookCommand(CommandContext context) {
        this.context = context;
    }

    @Override
    public Object execute() {
        BooksService booksService = context.getBooksService();
        String id = (String) context.getData();
        return booksService.deleteBook(id);
    }
}

