using System.Collections.Generic;

namespace BookModel
{
    /// <summary>
    /// Clasa Chapter reprezintă un capitol care poate conține subcapitole
    /// Implementează pattern-ul Composite
    /// </summary>
    public class Chapter : IBookElement
    {
        public string Name { get; set; }
        private List<SubChapter> _subChapters;

        public Chapter(string name)
        {
            Name = name;
            _subChapters = new List<SubChapter>();
        }

        /// <summary>
        /// Adaugă un subcapitol în capitol
        /// </summary>
        public void AddSubChapter(SubChapter subChapter)
        {
            _subChapters.Add(subChapter);
        }

        /// <summary>
        /// Returnează toate subcapitolele
        /// </summary>
        public IReadOnlyList<SubChapter> GetSubChapters()
        {
            return _subChapters.AsReadOnly();
        }

        public void Print()
        {
            Console.WriteLine($"\n========== CAPITOL: {Name} ==========");
            foreach (var subChapter in _subChapters)
            {
                subChapter.Print();
            }
            Console.WriteLine($"========== SFÂRȘIT CAPITOL: {Name} ==========\n");
        }

        public override string ToString()
        {
            return $"Capitol: {Name}";
        }
    }
}
