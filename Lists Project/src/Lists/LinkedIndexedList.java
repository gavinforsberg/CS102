package Lists;

public class LinkedIndexedList<T> extends LinkedList<T> implements IndexedListADT<T>
{
	public LinkedIndexedList()
	{
		super();
	}

	public void add(int index, T element)
	{
		if(index < 0)
			throw new IndexOutOfBoundsException();
		
		int counter = 0;
		LinearNode<T> current = head;
		LinearNode<T> previous = null;

		while (current != null && counter < index)
		{
			previous = current;
			current = current.getNext();
			++counter;
		}
		
		if(index > counter) 
			throw new IndexOutOfBoundsException();

		LinearNode<T> newNode = new LinearNode<T>(element);

		if (isEmpty())
			head = tail = newNode;
		else
		{
			newNode.setNext(current);

			if (previous != null)
				previous.setNext(newNode);
			else
				head = newNode;

			if (current == null)
				tail = newNode;
		}
		++count;
		++modCount;
	}

	public void set(int index, T element)
	{
		if (isEmpty())
			throw new IndexOutOfBoundsException();

		int counter = 0;
		LinearNode<T> current = head;
		LinearNode<T> previous = null;

		while (current != null && counter < index)
		{
			previous = current;
			current = current.getNext();
			++counter;
		}

		if (current == null)
			throw new IndexOutOfBoundsException();

		LinearNode<T> newNode = new LinearNode<T>(element);

		newNode.setNext(current.getNext());

		if (previous != null)
			previous.setNext(newNode);
		else
			head = newNode;
		
		if (current.getNext() == null)
			tail = newNode;

		++modCount;
	}

	public void add(T element)
	{
		LinearNode<T> newNode = new LinearNode<T>(element);

		if (isEmpty())
			head = tail = newNode;
		else
		{
			tail.setNext(newNode);
			tail = newNode;
		}

		++count;
		++modCount;
	}

	public T get(int index)
	{
		int counter = 0;
		LinearNode<T> current = head;

		while (current != null && counter < index)
		{
			current = current.getNext();
			++counter;
		}

		if (current == null)
			throw new IndexOutOfBoundsException();

		return current.getElement();
	}

	public int indexOf(T element)
	{
		int counter = 0;
		LinearNode<T> current = head;
		while (current != null)
		{
			if (current.getElement().equals(element))
				return counter;
			current = current.getNext();
			++counter;
		}

		return -1;
	}

	public T remove(int index)
	{
		if (isEmpty())
			throw new IndexOutOfBoundsException();

		int counter = 0;
		LinearNode<T> current = head;
		LinearNode<T> previous = null;

		while (current != null && counter < index)
		{
			previous = current;
			current = current.getNext();
			++counter;
		}

		if (current == null)
			throw new IndexOutOfBoundsException();
		
		previous.setNext(current.getNext());
		current.setNext(null);
		
		--count;
		++modCount;
		
		return current.getElement();
	}
	
	public String toString()
	{
		String output = "[ ";
		LinearNode<T> current = head; 
		while(current != null)
		{
			if(current != head)
				output += ", ";
			output += current.getElement().toString();
			current = current.getNext(); 
		}
		
		return output += " ]";
	}
}
