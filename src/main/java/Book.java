import java.util.ArrayList;
import java.util.List;

public class Book implements Element {
    private String title;
    private List<Author> authors = new ArrayList<>();
    private List<Element> content = new ArrayList<>();

    public Book(String title) {
        this.title = title;
    }

    public void addAuthor(Author author) {
        this.authors.add(author);
    }
    
    public void addContent(Element element) {
        this.content.add(element);
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
    

    @Override
    public void add(Element element) {
        addContent(element);
    }
    @Override
    public void remove(Element element) {
        content.remove(element);
    }
    @Override
    public Element get(int index) {
        return content.get(index);
    }
}