package ro.uvt.commands;

import ro.uvt.services.BooksService;

public class CommandContext {
    private BooksService booksService;
    private Object data;
    private String id;

    public CommandContext(BooksService booksService, Object data) {
        this.booksService = booksService;
        this.data = data;
    }

    public BooksService getBooksService() {
        return booksService;
    }

    public Object getData() {
        return data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

