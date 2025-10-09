namespace BookModel
{
	public class Paragraph : IBookElement
	{
		public string Text { get; set; }

		public Paragraph(string text)
		{
			Text = text;
		}

		public void Print()
		{
			Console.WriteLine($"Paragraph: {Text}");
		}

		// Leaf: no-op composite methods
		public void Add(IBookElement element) { }
		public void Remove(IBookElement element) { }
		public IBookElement Get(int index) { return null; }

		public override string ToString()
		{
			return $"Paragraph: {Text}";
		}
	}
}
