namespace BookModel
{
	public interface IBookElement
	{
		void Print();
		void Add(IBookElement element);
		void Remove(IBookElement element);
		IBookElement Get(int index);
	}
}
