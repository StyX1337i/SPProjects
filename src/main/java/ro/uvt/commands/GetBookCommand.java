package ro.uvt.commands;

import ro.uvt.services.BooksService;

public class GetBookCommand implements Command {
    private final CommandContext context;

    public GetBookCommand(CommandContext context) {
        this.context = context;
    }

    @Override
    public Object execute() {
        BooksService booksService = context.getBooksService();
        String id = (String) context.getData();
        return booksService.getBookById(id);
    }
}

