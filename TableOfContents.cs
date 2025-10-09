using System.Collections.Generic;

namespace BookModel
{
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

        public IReadOnlyList<string> GetEntries()
        {
            return _entries.AsReadOnly();
        }

        public void Print()
        {
            Console.WriteLine("\n****************** CUPRINS ******************");
            for (int i = 0; i < _entries.Count; i++)
            {
                Console.WriteLine($"{i + 1}. {_entries[i]}");
            }
            Console.WriteLine("*********************************************\n");
        }

        public override string ToString()
        {
            return "Cuprins";
        }
    }
}
