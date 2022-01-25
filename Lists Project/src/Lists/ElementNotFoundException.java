package Lists; 

public class ElementNotFoundException extends Exception
{
	private static final long serialVersionUID = 8707268377524493433L;

	public ElementNotFoundException()
	{
		super();
	}

	public ElementNotFoundException(String msg)
	{
		super(msg);
	}
}
