using System.Collections.Generic;

namespace BookModel
{
	public class Section : IBookElement
	{
		public string Title { get; set; }
		private List<IBookElement> _children;

		public Section(string title)
		{
			Title = title;
			_children = new List<IBookElement>();
		}

		public void Print()
		{
			Console.WriteLine(Title);
			foreach (var child in _children)
			{
				child.Print();
			}
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

		public override string ToString()
		{
			return $"Section: {Title}";
		}
	}
}
