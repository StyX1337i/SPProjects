package ro.uvt.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ro.uvt.Element;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "base_element")
public abstract class BaseElement implements Element {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private BaseElement parent;

    @OneToMany(targetEntity = BaseElement.class, cascade = CascadeType.ALL, mappedBy = "parent")
    private List<Element> children = new ArrayList<>();

    public BaseElement() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonIgnore
    public BaseElement getParent() {
        return parent;
    }

    public void setParent(BaseElement parent) {
        this.parent = parent;
    }

    @Override
    public void add(Element element) {
        if (element instanceof BaseElement) {
            ((BaseElement) element).setParent(this);
            children.add(element);
        }
    }

    @Override
    public void remove(Element element) {
        if (element instanceof BaseElement) {
            ((BaseElement) element).setParent(null);
            children.remove(element);
        }
    }

    @Override
    public Element get(int index) {
        return children.get(index);
    }

    public List<Element> getChildren() {
        return children;
    }
}

