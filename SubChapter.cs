using System.Collections.Generic;

namespace BookModel
{
    public class SubChapter : IBookElement
    {
        public string Name { get; set; }
        private List<IBookElement> _content;

        public SubChapter(string name)
        {
            Name = name;
            _content = new List<IBookElement>();
        }

        /// <summary>
        /// Adaugă o imagine în subcapitol
        /// </summary>
        public void AddImage(Image image)
        {
            _content.Add(image);
        }

        /// <summary>
        /// Adaugă un paragraf în subcapitol
        /// </summary>
        public void AddParagraph(Paragraph paragraph)
        {
            _content.Add(paragraph);
        }

        /// <summary>
        /// Adaugă un tabel în subcapitol
        /// </summary>
        public void AddTable(Table table)
        {
            _content.Add(table);
        }

        /// <summary>
        /// Adaugă un element generic în subcapitol
        /// </summary>
        public void AddElement(IBookElement element)
        {
            _content.Add(element);
        }

        /// <summary>
        /// Returnează toate elementele de conținut
        /// </summary>
        public IReadOnlyList<IBookElement> GetContent()
        {
            return _content.AsReadOnly();
        }

        public void Print()
        {
            Console.WriteLine($"\n--- Subcapitol: {Name} ---");
            foreach (var element in _content)
            {
                element.Print();
            }
            Console.WriteLine($"--- Sfârșit subcapitol: {Name} ---\n");
        }

        public override string ToString()
        {
            return $"Subcapitol: {Name}";
        }
    }
}
