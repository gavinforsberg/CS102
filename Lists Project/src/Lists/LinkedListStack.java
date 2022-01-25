package Lists; 

public class LinkedListStack<T> implements StackADT<T>
{
	private LinkedUnorderedList<T> stack;
	
	public LinkedListStack()
	{
		stack = new LinkedUnorderedList<T>();
	}
	
	public void push(T element)
	{
		stack.addToRear(element);
		
	}
	
	public T pop() throws EmptyCollectionException
	{
		if(isEmpty())
			throw new EmptyCollectionException();
		
		return stack.removeLast();
	}

	public T peek() throws EmptyCollectionException
	{
		if(isEmpty())
			throw new EmptyCollectionException();
		
		return stack.last();
	}
	
	public boolean isEmpty()
	{
		
		return stack.isEmpty();
	}

	public int size()
	{
		
		return stack.size();
	}

}
