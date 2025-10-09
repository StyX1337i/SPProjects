namespace BookModel
{
	public class Table : IBookElement
	{
		public string Name { get; set; }

		public Table(string name)
		{
			Name = name;
		}

		public void Print()
		{
			Console.WriteLine($"Table: {Name}");
		}

		// Leaf: no-op composite methods
		public void Add(IBookElement element) { }
		public void Remove(IBookElement element) { }
		public IBookElement Get(int index) { return null; }

		public override string ToString()
		{
			return $"Table: {Name}";
		}
	}
}
