namespace BookModel
{
	public class Paragraph : IBookElement
	{
		public string Text { get; set; }
		private IAlignStrategy _textAlignment;

		public Paragraph(string text)
		{
			Text = text;
		}

		public void SetAlignStrategy(IAlignStrategy alignStrategy)
		{
			_textAlignment = alignStrategy;
		}

		public void Print()
		{
			if (_textAlignment != null)
			{
				_textAlignment.Render(this);
			}
			else
			{
				Console.WriteLine($"Paragraph: {Text}");
			}
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
