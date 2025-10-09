using System;
using System.Collections.Generic;
using System.Linq;

public interface IBookElement
{
    void Print();
}

public class Author : IBookElement
{
    public string Name { get; set; }
    
    public Author(string name)
    {
        Name = name;
    }
    
    public void Print()
    {
        Console.WriteLine($"Autor: {Name}");
    }
}

public class Image : IBookElement
{
    public string ImageName { get; set; }
    
    public Image(string imageName)
    {
        ImageName = imageName;
    }
    
    public void Print()
    {
        Console.WriteLine($"Imagine: {ImageName}");
    }
}

public class Paragraph : IBookElement
{
    public string Text { get; set; }
    
    public Paragraph(string text)
    {
        Text = text;
    }
    
    public void Print()
    {
        Console.WriteLine($"Paragraf: {Text}");
    }
}

public class Table : IBookElement
{
    public string Title { get; set; }
    
    public Table(string title)
    {
        Title = title;
    }
    
    public void Print()
    {
        Console.WriteLine($"Tabel: {Title}");
    }
}

public class SubChapter : IBookElement
{
    public string Name { get; set; }
    private List<IBookElement> _content;
    
    public SubChapter(string name)
    {
        Name = name;
        _content = new List<IBookElement>();
    }
    
    public void AddImage(Image image)
    {
        _content.Add(image);
    }
    
    public void AddParagraph(Paragraph paragraph)
    {
        _content.Add(paragraph);
    }
    
    public void AddTable(Table table)
    {
        _content.Add(table);
    }
    
    public void Print()
    {
        Console.WriteLine($"Subcapitol: {Name}");
        foreach (var element in _content)
        {
            element.Print();
        }
    }
}

public class Chapter : IBookElement
{
    public string Name { get; set; }
    private List<SubChapter> _subChapters;
    
    public Chapter(string name)
    {
        Name = name;
        _subChapters = new List<SubChapter>();
    }
    
    public void AddSubChapter(SubChapter subChapter)
    {
        _subChapters.Add(subChapter);
    }
    
    public void Print()
    {
        Console.WriteLine($"Capitol: {Name}");
        foreach (var subChapter in _subChapters)
        {
            subChapter.Print();
        }
    }
}

public class TableOfContents : IBookElement
{
    private List<string> _entries;
    
    public TableOfContents()
    {
        _entries = new List<string>();
    }
    
    public void AddEntry(string entry)
    {
        _entries.Add(entry);
    }
    
    public void Print()
    {
        Console.WriteLine("Cuprins:");
        for (int i = 0; i < _entries.Count; i++)
        {
            Console.WriteLine($"{i + 1}. {_entries[i]}");
        }
    }
}

public class Book : IBookElement
{
    public string Title { get; set; }
    public Author Author { get; set; }
    private TableOfContents _tableOfContents;
    private List<Chapter> _chapters;
    
    public Book(string title, Author author)
    {
        Title = title;
        Author = author;
        _tableOfContents = new TableOfContents();
        _chapters = new List<Chapter>();
    }
    
    public void AddChapter(Chapter chapter)
    {
        _chapters.Add(chapter);
        _tableOfContents.AddEntry(chapter.Name);
    }
    
    public void Print()
    {
        Console.WriteLine($"Carte: {Title}");
        Author.Print();
        _tableOfContents.Print();
        foreach (var chapter in _chapters)
        {
            chapter.Print();
        }
    }
}

class Program
{
    static void Main(string[] args)
    {
        var author = new Author("Ion Creangă");
        var book = new Book("Amintiri din copilărie", author);

        var chapter1 = new Chapter("Introducere");
        var subChapter1 = new SubChapter("Copilăria");
        subChapter1.AddParagraph(new Paragraph("Text paragraf 1"));
        subChapter1.AddImage(new Image("imagine1.jpg"));
        subChapter1.AddTable(new Table("Tabel 1"));
        
        chapter1.AddSubChapter(subChapter1);
        book.AddChapter(chapter1);

        book.Print();
    }
}
