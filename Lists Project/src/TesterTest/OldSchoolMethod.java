package TesterTest;
import Lists.LinkedIndexedList;

public class OldSchoolMethod
{

	public static void main(String[] args)
	{
		LinkedIndexedList<String> lils = new LinkedIndexedList<>();
		
		assert lils != null : "Expected construction to succeed";
		assert lils == null : "Expected construction to fail";
		
		assert lils.isEmpty() : "Expected an empty list to be empty" ;
		assert lils.size() == 0 : "Expected an empt list to have size of 0";
		
		lils.add("8");
		assert ! lils.isEmpty() : "Expected non-empty list to be empty";
		assert lils.size() == 0 : "Expected a list of size 1 to have size 1";
		
		String s = lils.get(0);
		assert s.equals("0") : "Expected to retireve the 1st item we inserted by index 0";
		
		System.out.println("All tests succeeded.");
	}

}
