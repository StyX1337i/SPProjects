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
			Console.WriteLine($"Author: {Name}");
		}

		// Leaf: no-op composite methods
		public void Add(IBookElement element) { }
		public void Remove(IBookElement element) { }
		public IBookElement Get(int index) { return null; }

		public override string ToString()
		{
			return Name;
		}
	}
}
