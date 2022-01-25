package Lists; 
import java.util.ArrayList;
import java.util.Iterator;

public class Tester
{

	public static void main(String[] args)
	{
		ArrayList<Integer> ali = new ArrayList<>();
		ali.add(1);
		ali.add(2);
		ali.add(3);
		
		for(int i = 0; i < ali.size(); ++i)
			System.out.println(ali.get(i));
		
		for(Integer i : ali)
			System.out.println(i);
		
		LinkedUnorderedList<Integer> luli = new LinkedUnorderedList<>();
		
		luli.addToRear(1);
		luli.addToRear(2);
		luli.addToRear(3);
		
		for(Integer i : luli)
			System.out.println(i);
		
		Iterator<Integer> it = luli.iterator();
		while(it.hasNext())
		{
			Integer i = it.next();
			System.out.println(i);
		}
	}

}
