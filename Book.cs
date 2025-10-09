using System.Collections.Generic;

namespace BookModel
{
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

        public TableOfContents GetTableOfContents()
        {
            return _tableOfContents;
        }

        public IReadOnlyList<Chapter> GetChapters()
        {
            return _chapters.AsReadOnly();
        }

        public void GenerateTableOfContents()
        {
            _tableOfContents = new TableOfContents();
            foreach (var chapter in _chapters)
            {
                _tableOfContents.AddEntry(chapter.Name);
            }
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

        public override string ToString()
        {
            return $"Carte: {Title}";
        }
    }
}
