import java.util.ArrayList;
import java.util.List;

public class Section implements Element {
    private String title;
    private List<Element> content = new ArrayList<>();

    public Section(String title) {
        this.title = title;
    }

    @Override
    public void add(Element element) {
        content.add(element);
    }

    @Override
    public void remove(Element element) {
        content.remove(element);
    }

    @Override
    public Element get(int index) {
        return content.get(index);
    }

    @Override
    public void print() {
        System.out.println(title);
        for (Element element : content) {
            element.print();
        }
    }
}