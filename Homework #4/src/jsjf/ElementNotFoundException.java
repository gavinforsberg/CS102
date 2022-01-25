package jsjf ;

public class ElementNotFoundException extends RuntimeException
{
	private static final long serialVersionUID = 180310265833667221L ;

    public ElementNotFoundException( String collection )
    {
	    super( "The target element is not in this " + collection ) ;
    }
}
