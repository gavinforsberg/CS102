package Lists; 

public interface StackADT<T>
{	//Adds the specified element to the top of the stack
	public void push(T element);
	//Removes and returns the top element from the stack
	public T pop() throws EmptyCollectionException;
	//Returns without removing the top element of this stack
	public T peek() throws EmptyCollectionException;
	//Returns true if this stack contains no elements
	public boolean isEmpty();
	//Returns the number of elements in this stack
	public int size();
}
