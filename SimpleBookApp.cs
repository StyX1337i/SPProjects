using System;
using BookModel;

class Program
{
    static void Main(string[] args)
    {
        Section cap1 = new Section("Capitolul 1");

        Paragraph p1 = new Paragraph("Paragraph 1");
        cap1.Add(p1);
        Paragraph p2 = new Paragraph("Paragraph 2");
        cap1.Add(p2);
        Paragraph p3 = new Paragraph("Paragraph 3");
        cap1.Add(p3);
        Paragraph p4 = new Paragraph("Paragraph 4");
        cap1.Add(p4);

        Console.WriteLine("Printing without Alignment\n");
        cap1.Print();

        p1.SetAlignStrategy(new AlignCenter());
        p2.SetAlignStrategy(new AlignRight());
        p3.SetAlignStrategy(new AlignLeft());

        Console.WriteLine();
        Console.WriteLine("Printing with Alignment\n");
        cap1.Print();
    }
}
