
public class LinkedStack<T> implements StackADT<T>
{
	private int count; 
	private LinearNode<T> top;
	
	public LinkedStack()
	{
		count = 0; 
		top = null; 
	}

	@Override
	public void push(T element)
	{
		LinearNode<T> node = new LinearNode<T> (element);
		node.setNext(top);		
		top = node;
		++count;
	}

	@Override
	public T pop() throws EmptyCollectionException
	{
		if(isEmpty())
			throw new EmptyCollectionException();
		
		T result = top.getElement();
		top = top.getNext();
		--count;
			
		return result;
	}

	@Override
	public T peek() throws EmptyCollectionException
	{
		if(isEmpty())
			throw new EmptyCollectionException();
		
		return top.getElement();
	}

	@Override
	public boolean isEmpty()
	{
		return count <= 0;
	}

	@Override
	public int size()
	{
		return count;
	}
	
	public String toString()
	{
		String output = "TStack --> [ ";

		LinearNode<T> current = top;
		
		while(current != null)
		{
			output += current.getElement().toString() + " ";
			current.getNext();
		}

		output += "]";
		return output;
	}
	

}