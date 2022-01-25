
public class Tester
{
	public static void main(String[] argrs) throws EmptyCollectionException
	{
		
		System.out.println("Testing ArrayStack... ");
		System.out.println("=-=-=-==-=-=-==-=-=-=-=-=-=-=-=-=-=-=-");
		
		ArrayStack<Integer> as = new ArrayStack<Integer>();
		as.push(7);
		as.push(5);
		
		System.out.println(as);

		Integer z = as.pop();

		System.out.println(z);
		System.out.println(as);
		
		ArrayStack<String> as2 = new ArrayStack<String>();
		as2.push("Alex");
		as2.push("Fisher");
		as2.push("Brent");
		
		System.out.println(as2);
		
		String a = as2.pop();
		
		System.out.println(a);
		System.out.println(as2);
		
		
		
		System.out.println();
		System.out.println("Testing LinkedStack... ");
		System.out.println("=-=-=-==-=-=-==-=-=-=-=-=-=-=-=-=-=-=-");
		
		System.out.println();
		
		LinkedStack<String> ls = new LinkedStack<String>();
		
		ls.push("Jake");
		ls.push("Greg");
		ls.push("Mumtahan");
		
		DoLinkedStackStuff(ls);
		
		LinkedStack<Integer> ls2 = new LinkedStack<Integer>();
		
		ls2.push(1);
		ls2.push(2);
		ls2.push(3);
		ls2.push(4);
	
		DoLinkedStackStuff(ls2);		
	}
	
	
	public static <T> void DoLinkedStackStuff(StackADT<T> ls) throws EmptyCollectionException
	{
		System.out.print("Before Pop: ");
		System.out.println(ls);
		T popped = ls.pop();
		System.out.println("Popped " + popped);
		System.out.print("After Pop: ");
		System.out.println(ls);
	
	}
}