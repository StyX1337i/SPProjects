namespace BookModel
{
	public class AlignCenter : IAlignStrategy
	{
		public void Render(Paragraph paragraph)
		{
			const int lineWidth = 60;
			string text = paragraph.Text ?? string.Empty;
			int totalPadding = lineWidth - text.Length;
			if (totalPadding < 0) totalPadding = 0;
			int leftPadding = totalPadding / 2;
			Console.WriteLine($"Paragraph: {new string(' ', leftPadding)}{text}");
		}
	}
}


