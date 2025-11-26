package ro.uvt.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ro.uvt.models.BaseElement;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
public class Book extends BaseElement {
    private String title;
    private String isbn;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name = "book_author",
        joinColumns = @JoinColumn(name = "book_id"),
        inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors = new ArrayList<>();

    @OneToMany(targetEntity = BaseElement.class, cascade = CascadeType.ALL, mappedBy = "parent")
    private List<Element> content = new ArrayList<>();

    public Book() {
    }

    public Book(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public void addAuthor(Author author) {
        this.authors.add(author);
    }

    public List<Element> getContent() {
        return content;
    }

    public void setContent(List<Element> content) {
        this.content = content;
    }

    public void addContent(Element element) {
        if (element instanceof BaseElement) {
            ((BaseElement) element).setParent(this);
            content.add(element);
        }
    }

    @Override
    public void print() {
        System.out.println("Book: " + title);
        System.out.println("Authors:");
        for (Author author : authors) {
            author.print();
        }
        for (Element element : content) {
            element.print();
        }
    }
}

