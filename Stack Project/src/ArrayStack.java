import java.util.Arrays;

public class ArrayStack<T> implements StackADT<T>
{
	private final static int	DEFAULT_CAPACITY	= 100;

	private int	top;
	private T[]	stack;
	
	public ArrayStack()
	{
		this(DEFAULT_CAPACITY);
	}

	@SuppressWarnings("unchecked")
	public ArrayStack(int initialCapacity)
	{
		top = 0;
		stack = (T[]) new Object[initialCapacity];
	}
	
	public void push(T element)
	{
		if (size() == stack.length)
			expandCapacity();

		stack[top] = element;
		++top;
	}

	public T pop() throws EmptyCollectionException
	{
		if (isEmpty())
			throw new EmptyCollectionException();

		++top;
		T results = stack[top];
		stack[top] = null;
		return results;
	}

	public T peek() throws EmptyCollectionException
	{
		if (isEmpty())
			throw new EmptyCollectionException();
		return stack[top - 1];
	}

	public int size()
	{
		return top;
	}

	public boolean isEmpty()
	{
		return top == 0;
	}

	private void expandCapacity()
	{
		stack = Arrays.copyOf(stack, stack.length * 2);
	}

	public String toString()
	{
		String output = "TStack --> [ ";

		for (int i = 0; i < top - 1; ++i)
		{
			output += stack[i].toString() + " ";
		}

		output += "]";
		return output;
	}
}