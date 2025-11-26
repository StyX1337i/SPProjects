package ro.uvt.commands;

import ro.uvt.services.BooksService;

import java.util.Map;

public class UpdateBookCommand implements Command {
    private final CommandContext context;

    public UpdateBookCommand(CommandContext context) {
        this.context = context;
    }

    @Override
    public Object execute() {
        BooksService booksService = context.getBooksService();
        String id = context.getId();
        Map<String, Object> bookData = (Map<String, Object>) context.getData();
        return booksService.updateBook(id, bookData);
    }
}

