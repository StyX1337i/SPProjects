 class AlignLeft implements AlignStrategy {
    @Override
    public void render(Paragraph paragraph, String renderingContext) {
        System.out.println("Alignment: Left");
        System.out.println("  " + paragraph.getText());
    }
}