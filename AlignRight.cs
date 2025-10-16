namespace BookModel
{
	public class AlignRight : IAlignStrategy
	{
		public void Render(Paragraph paragraph)
		{
			// Simple right alignment: pad left so that text ends at a fixed width
			const int lineWidth = 60;
			string text = paragraph.Text ?? string.Empty;
			int padding = lineWidth - text.Length;
			if (padding < 0) padding = 0;
			Console.WriteLine($"Paragraph: {new string(' ', padding)}{text}");
		}
	}
}


