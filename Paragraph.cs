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
            Console.WriteLine($"Paragraf: {Text}");
        }

        public override string ToString()
        {
            return $"Paragraf: {Text}";
        }
    }
}
