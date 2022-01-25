package jsjf ;

public class EmptyCollectionException extends RuntimeException
{
	private static final long serialVersionUID = 7531101747543110639L ;

    public EmptyCollectionException( String collection )
    {
        super( "The " + collection + " is empty." ) ;
    }
}
