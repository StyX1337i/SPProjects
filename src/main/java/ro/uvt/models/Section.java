package ro.uvt.models;

import javax.persistence.*;

@Entity
@Table(name = "section")
public class Section extends BaseElement {
    private String title;

    public Section() {
    }

    public Section(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void print() {
        System.out.println(title);
        for (Element element : getChildren()) {
            element.print();
        }
    }
}

