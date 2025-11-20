public class Main {
    public static void main(String[] args) throws Exception {
        // SpringApplication.run(DesignPatternsLab2023Application.class, args);
        
        Section cap1 = new Section("Capitolul 1");
        
        Paragraph p1 = new Paragraph("Paragraph 1");
        cap1.add(p1);
        
        Paragraph p2 = new Paragraph("Paragraph 2");
        cap1.add(p2);
        
        Paragraph p3 = new Paragraph("Paragraph 3");
        cap1.add(p3);
        
        Paragraph p4 = new Paragraph("Paragraph 4");
        cap1.add(p4);
        
        System.out.println("Printing without Alignment");
        System.out.println();
        cap1.print();

        // Setează strategiile de aliniere
        p1.setAlignStrategy(new AlignCenter()); // Aliniere Centru
        p2.setAlignStrategy(new AlignRight());  // Aliniere Dreapta
        p3.setAlignStrategy(new AlignLeft());   // Aliniere Stânga (chiar dacă este implicită)
        
        System.out.println();
        System.out.println("Printing with Alignment");
        System.out.println();
        cap1.print();
    }
}