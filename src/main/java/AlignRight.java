public class AlignRight implements AlignStrategy {
    @Override
    public void render(Paragraph paragraph, String renderingContext) {
        String text = paragraph.getText();
        System.out.println("Alignment: Right");
        System.out.printf("%30s%n", text);
    }
}