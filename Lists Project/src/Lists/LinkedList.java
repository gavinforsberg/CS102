package Lists; 
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;


public abstract class LinkedList<T> implements ListADT<T>
{
	protected int count;
	protected LinearNode<T> head, tail; 
	protected int modCount;
	
	public LinkedList()
	{
		count = 0;
		head = tail = null;
		modCount = 0;
	}
	
	public T removeFirst() throws EmptyCollectionException
	{
		if(isEmpty())
			throw new EmptyCollectionException();
		
		LinearNode<T> result = head;
		
		head = head.getNext();
		
		if(head == null)
			tail = null;
		-- count;
		++modCount;
		
		return result.getElement();
		
	}
	
	public T removeLast()  throws EmptyCollectionException
	{
		if(isEmpty())
			throw new EmptyCollectionException();
		LinearNode<T> previous = null;
		LinearNode<T> current = head;
		
		while(current.getNext() != null)
		{
			previous = current;
			current = current.getNext();
		}
		
		LinearNode<T> result = tail;
		
		tail = previous;
		
		if(tail == null)
			head = null;
		else 
			tail.setNext(null);
		
		--count;
		++modCount;
		
		return result.getElement();
	}
	
	public T remove(T targetElement) throws EmptyCollectionException, ElementNotFoundException
	{
		if(isEmpty())
			throw new EmptyCollectionException();
		
		boolean found = false;
		LinearNode<T> previous = null;
		LinearNode<T> current = head;
		
		while(current != null && !found)
		{
			if(targetElement.equals(current.getElement()))
				found = true;
			else
			{
				previous = current;
				current = current.getNext();
			}
		}
		
		if(!found)
			throw new ElementNotFoundException();
		
		if(size() == 1)
			head = tail = null;
		else if(current.equals(head))
			head = current.getNext();
		else if(current.equals(tail))
		{
			tail = previous;
			tail.setNext(null);
		}
		else
			previous.setNext(current.getNext());
	
		--count;
		++modCount;
		
		return current.getElement();
	}
	
	public T first() throws EmptyCollectionException
	{
		if(isEmpty())
			throw new EmptyCollectionException();
		
		return head.getElement();
	}
	
	public T last() throws EmptyCollectionException
	{
		if(isEmpty())
			throw new EmptyCollectionException();
	
		return tail.getElement();
	}
	
	public boolean contains(T targetElement) throws EmptyCollectionException
	{
		if(isEmpty())
			throw new EmptyCollectionException();
		
		boolean found = false;
		LinearNode<T> current = head;
		
		while(current != null && !found)
		{
			if(targetElement.equals(current.getElement()))
					found = true;
			else 
				current = current.getNext();
		}
		return found;
	}
	
	public int size()
	{
		return count;
	}
	
	public boolean isEmpty()
	{
		return count <= 0;
	}
	
	public String toString()
	{
		String output = "Linked List --> [ ";

		LinearNode<T> current = head;

		while (current != null)
		{
			output += current.getElement().toString() + " ";
			current.getNext();
		}

		output += "]";
		return output;

	}

	public Iterator<T> iterator()
	{
		return new LinkedListIterator();
	}
	
	private class LinkedListIterator implements Iterator<T> 
	{
		private int iteratorModCount;
		private LinearNode<T> current;
		
		public LinkedListIterator()
		{
			current = head; 
			iteratorModCount = modCount;
		}
		
		public boolean hasNext()
		{
			if(iteratorModCount != modCount)
				throw new ConcurrentModificationException();
			
			return current != null;
		}

		public T next()
		{
			if(! hasNext())
				throw new NoSuchElementException();
			
			T result = current.getElement();
			
			current = current.getNext();
			
			return result;
		}
		
	}
	
}