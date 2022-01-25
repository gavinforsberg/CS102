import java.util.Arrays;

public class DoubleStack
{
	private final static int	DEFAULT_CAPACITY	= 100;

	private int			top;
	private Double[]		stack;

	public DoubleStack()
	{
		this(DEFAULT_CAPACITY);
	}

	public DoubleStack(int initialCapacity)
	{
		top = 0;
		stack = new Double[initialCapacity];
	}

	public void push(Double element)
	{
		if (size() == stack.length)
			expandCapacity();

		stack[top] = element;
		++top;
	}

	public Double pop() throws EmptyCollectionException
	{
		if (isEmpty())
			throw new EmptyCollectionException();

		++top;
		Double results = stack[top];
		stack[top] = null;
		return results;
	}

	public Double peek() throws EmptyCollectionException
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
		String output = "[ ";

		for (int i = 0; i < top; ++i)
		{
			output += stack[i].toString() + " ";
		}

		output += " ] ";

		return output;
	}
}
