using System.Collections.Generic;

namespace BookModel
{
	public class Book : IBookElement
	{
		public string Title { get; set; }
		private List<Author> _authors;
		private List<IBookElement> _children;

		public Book(string title)
		{
			Title = title;
			_authors = new List<Author>();
			_children = new List<IBookElement>();
		}

		public void AddAuthor(Author author)
		{
			_authors.Add(author);
		}

		public void Print()
		{
			Console.WriteLine($"Book: {Title}");
			if (_authors.Count > 0)
			{
				Console.WriteLine("Authors:");
				foreach (var a in _authors) a.Print();
			}
			foreach (var child in _children) child.Print();
		}

		public void Add(IBookElement element)
		{
			_children.Add(element);
		}

		public void Remove(IBookElement element)
		{
			_children.Remove(element);
		}

		public IBookElement Get(int index)
		{
			return _children[index];
		}

		public void AddContent(IBookElement element)
		{
			Add(element);
		}

		public override string ToString()
		{
			return $"Book: {Title}";
		}
	}
}
