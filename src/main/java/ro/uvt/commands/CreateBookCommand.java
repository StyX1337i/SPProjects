package ro.uvt.commands;

import ro.uvt.services.BooksService;

import java.util.Map;

public class CreateBookCommand implements Command {
    private final CommandContext context;

    public CreateBookCommand(CommandContext context) {
        this.context = context;
    }

    @Override
    public Object execute() {
        BooksService booksService = context.getBooksService();
        Map<String, Object> bookData = (Map<String, Object>) context.getData();
        return booksService.createBook(bookData);
    }
}

