package ro.uvt.observer;

import ro.uvt.models.Book;

public interface Observer {
    void update(Book book);
}

