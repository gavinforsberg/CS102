import java.util.Arrays;

public class IntStack
{
	private final static int	DEFAULT_CAPACITY	= 100;

	private int			top;
	private Integer[]		stack;

	public IntStack()
	{
		this(DEFAULT_CAPACITY);
	}

	public IntStack(int initialCapacity)
	{
		top = 0;
		stack = new Integer[initialCapacity];
	}

	public void push(Integer element)
	{
		if (size() == stack.length)
			expandCapacity();

		stack[top] = element;
		++top;
	}

	public Integer pop() throws EmptyCollectionException
	{
		if (isEmpty())
			throw new EmptyCollectionException();

		++top;
		Integer results = stack[top];
		stack[top] = null;
		return results;
	}

	public Integer peek() throws EmptyCollectionException
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

	// ++i;
	// i = i + 1 ;
	// return i;

	// i++;
	// i = 1 + i
	// return i;

	public String toString()
	{
		String output = "Int stack --> [ ";

		for (int i = 0; i < top; ++i)
		{
			output += stack[i].toString() + " ";
		}

		output += "] ";

		return output;
	}
}
