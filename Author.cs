namespace BookModel
{
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

        public override string ToString()
        {
            return Name;
        }
    }
}
