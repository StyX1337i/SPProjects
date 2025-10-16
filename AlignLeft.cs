namespace BookModel
{
	public class AlignLeft : IAlignStrategy
	{
		public void Render(Paragraph paragraph)
		{
			Console.WriteLine($"Paragraph: {paragraph.Text}");
		}
	}
}


