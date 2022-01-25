package Lists; 

public class LinkedListQueue<T> implements QueueADT<T>
{
private LinkedUnorderedList<T> queue;
	
	public LinkedListQueue()
	{
		queue = new LinkedUnorderedList<T>();
	}

	public void enqueue(T element)
	{
		queue.addToRear(element);
		
	}

	public T dequeue() throws EmptyCollectionException
	{
		if(isEmpty())
			throw new EmptyCollectionException();
		
		return queue.removeFirst();
	}

	public T first() throws EmptyCollectionException
	{
		if(isEmpty())
			throw new EmptyCollectionException();
		
		return queue.first();
	}

	public int size()
	{
		return queue.size();
	}

	public boolean isEmpty()
	{
		return queue.isEmpty();
	}
	
	
}
