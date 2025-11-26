package ro.uvt.models;

import javax.persistence.*;

@Entity
@Table(name = "image")
public class Image extends BaseElement {
    private String imageName;

    public Image() {
    }

    public Image(String imageName) {
        this.imageName = imageName;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public void print() {
        System.out.println("Image with name:" + imageName);
    }
}

