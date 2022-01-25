
public class CircularArrayQueue<T> implements QueueADT<T>
{
	private final static int	DEFAULT_CAPACITY	= 100;
	private int			front, rear, count;
	private T[]			queue;

	public CircularArrayQueue()
	{ // 'this' calls other constructor, you don't call it by name in Java
		this(DEFAULT_CAPACITY);
	}

	@SuppressWarnings("unchecked")
	private CircularArrayQueue(int initialCapacity)
	{
		front = rear = count = 0;
		queue = (T[]) new Object[initialCapacity];
	}

	@Override
	public void enqueue(T element)
	{
		if (size() == queue.length)
			expandCapacity();

		queue[rear] = element;
		rear = (rear + 1) % queue.length;
		count++;
	}

	@Override
	public T dequeue() throws EmptyCollectionException
	{
		if (isEmpty())
			throw new EmptyCollectionException();

		T result = queue[front];
		queue[front] = null;
		front = (front + 1) % queue.length;
		count--;

		return result;
	}

	@Override
	public T first() throws EmptyCollectionException
	{
		if (isEmpty())
			throw new EmptyCollectionException();

		return queue[front];
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

	@SuppressWarnings("unchecked")
	private void expandCapacity()
	{
		T[] larger = (T[]) new Object[queue.length * 2];

		for (int i = 0; i < count; ++i)
		{
			larger[i] = queue[front];
			front = (front + 1) % queue.length;
		}

		front = 0;
		rear = count;

		queue = larger;
	}

	public String toString()
	{
		String output = "CircularArrayQueue --> [ ";

		int pointer = front; 
		for(int i = 0; i < count; ++i)
		{
			output += queue[pointer] + " ";
			pointer = (pointer + 1) % queue.length;
		}

		output += "]";
		return output;
	}
}
