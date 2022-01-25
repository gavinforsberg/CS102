package Lists; 

public class LinkedOrderedList<T> extends LinkedList<T> implements OrderedListADT<T>
{

	public LinkedOrderedList()
	{
		super();
	}

	public void add(T element) throws NonComparableElementException
	{
		if (!(element instanceof Comparable))
			throw new NonComparableElementException();

		@SuppressWarnings({ "unchecked" })
		Comparable<T> comparableElement = (Comparable<T>) element;

		LinearNode<T> newNode = new LinearNode<T>(element);

		if (isEmpty())
			head = tail = newNode;
		else if (comparableElement.compareTo(head.getElement()) <= 0)
		{
			newNode.setNext(head);
			head = newNode;
		} 
		else if (comparableElement.compareTo(tail.getElement()) >= 0)
		{
			tail.setNext(newNode);
			tail = newNode;
		}
		else
		{
			LinearNode<T> current = head; 
			LinearNode<T> previous = null;
			
			while(comparableElement.compareTo(current.getElement()) >= 0)
			{
				previous = current; 
				current = current.getNext();
			}
			
			newNode.setNext(current);
			previous.setNext(newNode);
		}
		++count;
		++modCount;
	}
}
