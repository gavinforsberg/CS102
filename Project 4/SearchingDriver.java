/*
 * Gavin Forsberg
 * SearchingDriver.java
 * Project4.zip
 * Driver program which tests the searching methods. If the data is sorted, 
 * it will use binarySearch to find the target. If the data is not sorted, 
 * it will use the linearSearch method to find the target. Everything is 
 * generic so Integers, Strings, and Characters are all available to test 
 * with different data sets (one sorted already and one not). 
 */

public class SearchingDriver
{
	///////////////////////////////////////////////////////////////////////////
	// Two of three data sets are commented out. Generic and works with all.///
	// Comment out the sets you aren't using //////////////////////////////////
	///////////////////////////////////////////////////////////////////////////

	public static void main(String[] args)
	{
		// Sorted/Unsorted pool of integers
//		Integer[] pool = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
//		//Integer[] pool = { 6, 19, 27, 47, 7, 60, 72, 9, 90, 93 };
//		Integer target = 7;

		// Sorted/Unsorted pool of Strings
//		String[] pool = { "a", "b", "c", "z", "x", "n", "p", "g", "u", "q", "d" };
//		//String[] pool = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k" };
//		String target = "g";

		// Sorted/Unsorted pool of Characters
		Character[] pool = { 'a', 'b', 'c', 'z', 'x', 'n', 'p', 'g', 'u', 'q', 'd' };
		// Character[] pool = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k' };
		Character target = 'g';

		// Tracks if the target has been found
		boolean found;

		// Uses binarySearch if the data is already sorted
		if(SearchingAlgorithms.isSorted(pool))
		{
			found = SearchingAlgorithms.binarySearch(pool, target);
			System.out.println("Binary was used");
		} 
		else // If the data is not already sorted, linearSearch is used
		{
			found = SearchingAlgorithms.linearSearch(pool, target);
			System.out.println("Linear was used");
		}

		// Prints results and number of comparisons
		if(found)
			System.out.println("\nFound it! " + " (" + target + ") ");
		else
			System.out.println("\nDidn't find it!");

		System.out.println("\nComparisons " + SearchingAlgorithms.comparisons);
	}
}
