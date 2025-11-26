package ro.uvt.observer;

public interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers(ro.uvt.models.Book book);
}

