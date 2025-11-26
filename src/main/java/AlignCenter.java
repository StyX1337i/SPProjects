public class AlignCenter implements AlignStrategy {
    @Override
    public void render(Paragraph paragraph, String renderingContext) {
        String text = paragraph.getText();
        System.out.println("Alignment: Center");
        System.out.printf("%15s%n", text);
    }
}