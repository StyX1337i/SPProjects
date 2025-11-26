public class Paragraph implements Element {
    private String text;
    private AlignStrategy alignStrategy; 

    public Paragraph(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setAlignStrategy(AlignStrategy strategy) {
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