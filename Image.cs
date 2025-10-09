namespace BookModel
{
	public class Image : IBookElement
	{
		public string Url { get; set; }

		public Image(string url)
		{
			Url = url;
		}

		public void Print()
		{
			Console.WriteLine($"Image with name:{Url}");
		}

		// Leaf: no-op composite methods
		public void Add(IBookElement element) { }
		public void Remove(IBookElement element) { }
		public IBookElement Get(int index) { return null; }

		public override string ToString()
		{
			return $"Image: {Url}";
		}
	}
}
