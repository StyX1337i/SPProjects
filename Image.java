public class Image implements Element {
    private String imageName;

    public Image(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public void print() {
        System.out.println("Image with name:" + imageName);
    }
    
    // Composite methods - implement the "safe" approach
    @Override
    public void add(Element element) {
        throw new UnsupportedOperationException();
    }
    @Override
    public void remove(Element element) {
        throw new UnsupportedOperationException();
    }
    @Override
    public Element get(int index) {
        throw new UnsupportedOperationException();
    }
}