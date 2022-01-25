/*
 * Gavin Forsberg
 * SearchingAlgorithm.java
 * Project4.zip
 * Program which contains the linearSearch and binarySearch methods. Also contains a global 
 * variable to track comparisons made throughout searching methods, and a isSorted method to 
 * check whether or not the data provided for search is already in order or not.
 */

public class SearchingAlgorithms
{
	//Global variable which holds the number of comparisons made for each search method
	static int comparisons = 0;

	//linearSearch Call
	public static <T> boolean linearSearch(T[] data, T target) 
	{
		return linearSearch(data, 0, data.length - 1, target);
	}

	//Linear Search method from the book 
	public static <T> boolean linearSearch(T[] data, int min, int max, T target)
	{
		if(data == null)
			throw new NullPointerException();
		
		boolean found = false;

		int index = min;
		while (!found && index <= max)
		{
			found = data[index].equals(target);
			++index;
			++comparisons;
		}
		return found;
	}

	//BinarySearch call
	public static <T extends Comparable<T>> 
		boolean binarySearch(T[] data, T target) 
	{
		return binarySearch(data, 0, data.length - 1, target);
	}

	//BinarySearch Method from the book
	public static <T extends Comparable<T>> 
		boolean binarySearch(T[] data, int min, int max, T target)
	{
		//Throws an exception if the data is null
		if(data == null)
			throw new NullPointerException();
		//Throws an exception if the data is not sorted
		if(!isSorted(data))
			throw new IllegalArgumentException();
		
		boolean found = false;
		int midpoint = (min + max) / 2;

		int compareResult = data[midpoint].compareTo(target);
		
		++comparisons;
		if (compareResult == 0)
			found = true;
		else if (compareResult > 0)
		{
			if (min <= midpoint - 1)
			{
				found = binarySearch(data, min, midpoint - 1, target);
				
			}
		} 
		else if (compareResult < 0)
		{
			if (midpoint + 1 <= max)
				found = binarySearch(data, midpoint + 1, max, target);
			
		} 
		else if (midpoint + 1 <= max)
			found = binarySearch(data, midpoint + 1, max, target);
		
		return found;
	}
	
	//Method to test whether or not the data provided is sorted
	public static <T extends Comparable<T>> boolean isSorted(T[] data)
	{
		for(int i = 0; i < data.length - 1; ++i)
		{
			if(data[i].compareTo(data[i + 1]) > 0)
				return false;
		}
		return true;
	}
}