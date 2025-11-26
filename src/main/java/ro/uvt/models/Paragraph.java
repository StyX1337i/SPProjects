package ro.uvt.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "paragraph")
public class Paragraph extends BaseElement {
    private String text;

    @Transient
    private ro.uvt.AlignStrategy alignStrategy;

    public Paragraph() {
    }

    public Paragraph(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @JsonIgnore
    public ro.uvt.AlignStrategy getAlignStrategy() {
        return alignStrategy;
    }

    public void setAlignStrategy(ro.uvt.AlignStrategy strategy) {
        this.alignStrategy = strategy;
    }

    @Override
    public void print() {
        if (alignStrategy != null) {
            alignStrategy.render(this, "Default Context");
        } else {
            System.out.println("Paragraph: " + text);
        }
    }
}

