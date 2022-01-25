public class LinkedQueue<T> implements QueueADT<T>
{
	private int			count;
	private LinearNode<T>	head;
	private LinearNode<T>	tail;

	public LinkedQueue()
	{
		count = 0;
		head = null;
		tail = null;
	}

	@Override
	public void enqueue(T element)
	{
		LinearNode<T> node = new LinearNode<T>(element);

		if (isEmpty())
			head = node;
		else
			tail.setNext(node);

		tail = node;
		++count;
	}

	@Override
	public T dequeue() throws EmptyCollectionException
	{
		if (isEmpty())
			throw new EmptyCollectionException();

		T result = head.getElement();
		head = head.getNext();
		--count;

		if (isEmpty())
			tail = null;

		return result;
	}

	@Override
	public T first() throws EmptyCollectionException
	{
		if (isEmpty())
			throw new EmptyCollectionException();
		return head.getElement();
	}

	@Override
	public int size()
	{
		return count;
	}

	@Override
	public boolean isEmpty()
	{

		return count <= 0;
	}

	public String toString()
	{
		String output = "Linked Queue --> [ ";

		LinearNode<T> current = head;

		while (current != null)
		{
			output += current.getElement().toString() + " ";
			current.getNext();
		}

		output += "]";
		return output;

	}
}
