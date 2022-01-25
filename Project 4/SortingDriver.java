/*
 * Gavin Forsberg
 * SortingDriver.java
 * Project4.zip
 * Driver program which tests the sorting methods. Everything is 
 * generic so Integers, Strings, and Characters are all available to test 
 * with different data sets (one sorted already and one not). All data is 
 * cloned from an array to more specific arrays for each sorting method. 
 * Displays the results of each sort, as well as the results of each comparison
 * variable via the toString created. 
 */

import java.util.Arrays;

public class SortingDriver
{
	public static void main(String[] args)
	{	
		///////////////////////////////////////////////////////////////////////////
		// Two of three data sets are commented out. Generic and works with all.///
		// Comment out the sets you aren't using //////////////////////////////////
		///////////////////////////////////////////////////////////////////////////
		
		
		/*
		 * Integer Data
		 */
//		Integer[] data = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
//		//Integer[] data = { 67, 19, 17, 83, 47, 87, 31, 97, 19, 43, 71, 59, 37, 11 } ;
//		Integer[] bs_data = data.clone();
//		Integer[] ss_data = data.clone();
//		Integer[] is_data = data.clone();
//		Integer[] ms_data = data.clone();
//		Integer[] qs_data = data.clone();
		
		/*
		 * String Data
		 */
//		String[] data = { "a", "d", "f", "e", "i", "k", "p", "n", "b", "x", "t", "l", "m"};
//		String[] bs_data = data.clone();
//		String[] ss_data = data.clone();
//		String[] is_data = data.clone();
//		String[] ms_data = data.clone();
//		String[] qs_data = data.clone();
		
		/*
		 * Character Data
		 */
		Character[] data = { 'a', 'd', 'f', 'e', 'i', 'k', 'p', 'n', 'b', 'x', 't', 'l', 'v'};
		Character[] bs_data = data.clone();
		Character[] ss_data = data.clone();
		Character[] is_data = data.clone();
		Character[] ms_data = data.clone();
		Character[] qs_data = data.clone();
		
		
		//Prints the Sorted Data (regardless of type used above^)
		SortingAlgorithms.bubbleSort(bs_data);
		System.out.println("BubbleSort:	" + Arrays.toString(bs_data));

		SortingAlgorithms.selectionSort(ss_data);		
		System.out.println("SelectionSort:	" + Arrays.toString(ss_data));

		SortingAlgorithms.insertionSort(is_data);
		System.out.println("InsertionSort:	" + Arrays.toString(is_data));

		SortingAlgorithms.mergeSort(ms_data);	
		System.out.println("MergeSort:	" + Arrays.toString(ms_data));

		SortingAlgorithms.quickSort(qs_data);
		System.out.println("QuickSort:	" + Arrays.toString(qs_data));
		
		
		//Prints the Sorting toString of number of comparisons
		System.out.println("\n");
		System.out.print(SortingAlgorithms.toString(data));
	}
}