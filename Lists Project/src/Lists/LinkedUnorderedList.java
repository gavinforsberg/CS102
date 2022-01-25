package Lists; 

public class LinkedUnorderedList<T> extends LinkedList<T> implements UnorderedListADT<T>
{
	
	public LinkedUnorderedList()
	{
		super();
	}
	
	
	public void addToFront(T element)
	{
		LinearNode<T> newNode = new LinearNode<T>(element);
		
		if(isEmpty())
			head = tail = newNode;
		else
		{
			newNode.setNext(head);
			head = newNode;
		}
		
		++count;
		++modCount;
		
	}

	
	public void addToRear(T element)
	{
		LinearNode<T> newNode = new LinearNode<T> (element);
		
		if(isEmpty())
			head = tail = newNode;
		else
		{
			tail.setNext(newNode);
			tail = newNode;
		}
		
		++count;
		++modCount;
	}

	
	public void addAfter(T element, T target) throws ElementNotFoundException
	{
		if(isEmpty())
			throw new ElementNotFoundException();
		
		boolean found = false; 
		LinearNode<T> current = head; 
		
		while(current != null && ! found)
		{
			if(target.equals(current.getElement()))
					found = true;
			else
				current = current.getNext();
		}
		
		if(!found)
			throw new ElementNotFoundException();
		
		LinearNode<T> newNode = new LinearNode<T>(element);
		
		newNode.setNext(current.getNext());
		current.setNext(newNode);
		
		++count;
		++modCount;
	}
}
