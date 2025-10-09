namespace BookModel
{
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

        public override string ToString()
        {
            return $"Tabel: {Title}";
        }
    }
}
