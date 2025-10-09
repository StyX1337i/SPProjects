namespace BookModel
{
    public class Image : IBookElement
    {
        public string ImageName { get; set; }

        public Image(string imageName)
        {
            ImageName = imageName;
        }

        public void Print()
        {
            Console.WriteLine($"Imagine: {ImageName}");
        }

        public override string ToString()
        {
            return $"Imagine: {ImageName}";
        }
    }
}
