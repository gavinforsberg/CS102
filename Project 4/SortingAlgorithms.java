/*
 * Gavin Forsberg
 * SortingAlgorithm.java
 * Project4.zip
 * Program which contains the selectionSort, bubbleSort, insertionSort, quickSort, and mergeSort methods. 
 * Also contains swap, merge, and partition methods to make the sorting methods work. Additionally, global 
 * variables are created for each of the sorting methods and results are displayed with a generic toString. 
 */

public class SortingAlgorithms
{
	//Global variable to track the number of 
	//comparisons made per sorting method
	public static int bubbleComparisons = 0;
	public static int selectComparisons = 0;
	public static int insertComparisons = 0;
	public static int mergeComparisons = 0;
	public static int quickComparisons = 0;
	
	//SelectionSort method from the book
	public static <T extends Comparable<T>> void selectionSort(T[] data)
	{		
		for(int index = 0; index < data.length - 1; ++index)
		{
			int min = index; 
			
			for(int scan = index + 1; scan < data.length; ++scan)
			{	
				++selectComparisons;
				if(data[scan].compareTo(data[min]) < 0)
					min = scan;
			}
			
			if(min != index)
				swap(data, min, index);
		}
	}
	
	//InsertionSort method from the book
	public static <T extends Comparable<T>> void insertionSort(T[] data)
	{
		for(int index = 1; index < data.length; ++index)
		{
			T key = data[index];
			int position = index;
			
			++insertComparisons;			
			while(position > 0 && data[position - 1].compareTo(key) > 0)
			{	
				data[position] = data[position - 1];
				--position;	
			}
			data[position] = key;
		}
	}
	
	//BubbleSort method from the book
	public static <T extends Comparable<T>> void bubbleSort(T[] data)
	{
		for(int position = data.length - 1; position >= 0; --position)
		{	
			for(int scan = 0; scan < position; ++scan)
			{
				++bubbleComparisons;
				if(data[scan].compareTo(data[scan + 1]) > 0)
					swap(data, scan, scan + 1);
			}
		}
	}
	
	//QuickSort call
	public static <T extends Comparable<T>> void quickSort(T[] data)	{	quickSort(data, 0, data.length -1);	}
	//QuickSort Method from the book
	private static <T extends Comparable<T>> void quickSort(T[] data, int min, int max)
	{
		if(min < max)
		{
			int indexOfPartitionElement = partition(data, min, max);
			quickSort(data, min, indexOfPartitionElement - 1);
			quickSort(data, indexOfPartitionElement + 1, max);
		}
	}
	
	//MergeSort Call
	public static <T extends Comparable<T>> void mergeSort(T[] data)	{	mergeSort(data, 0, data.length - 1);	}
	//MergeSort Method from the book
	public static <T extends Comparable<T>> void mergeSort(T[] data, int min, int max)
	{
		if(min < max)
		{
			int mid = (min + max) / 2;
			mergeSort(data, min, mid);
			mergeSort(data, mid + 1, max);
			merge(data, min, mid, max);
		}
	}
	
	//Merge method from the book -- used for mergeSort
	public static <T extends Comparable<T>> void merge(T[] data, int first, int mid, int last)
	{
		@SuppressWarnings("unchecked")
		T[] temp = (T[]) (new Comparable[data.length]);
		
		int first1 = first, last1 = mid;
		int first2 = mid + 1, last2 = last;
		int index = first1;
		
		while(first1 <= last1 &&  first2 <= last2)
		{
			++mergeComparisons;
			if(data[first1].compareTo(data[first2]) < 0)
			{
				temp[index] = data[first1];
				++first1;	
			}
			else
			{
				temp[index] = data[first2];
				++first2;
			}
			++index;
		}
		
		while(first1 <= last1)
		{	
			temp[index] = data[first1];
			++first1;
			++index;
		}
		
		while(first2 <= last2)
		{
			temp[index] = data[first2];
			++first2;	
			++index;	
		}
		
		for(index = first; index <= last; ++index)
			data[index] = temp[index];	
	}
	
	//Partition Method from the book -- used for quickSort
	private static <T extends Comparable<T>> int partition(T[] data, int min, int max)
	{
		int middle = (min + max) / 2;
		T partitionElement = data[middle];
		
		swap(data, middle, min);
		int left = min; 
		int right = max; 
		
		while(left < right)
		{	
			++quickComparisons; 
			while(left < right && data[left].compareTo(partitionElement) <= 0)
				++left;		
			
			++quickComparisons;
			while(data[right].compareTo(partitionElement) > 0)	
				--right;	 	
			
			
			if(left < right)
				swap(data, left, right);
		}
		swap(data, min, right);
		return right;
	}
	
	//Swap Method from the book -- used in many sort methods
	private static <T> void swap(T[] data, int index1, int index2)
	{
		T temp = data[index1];
		data[index1] = data[index2];
		data[index2] = temp;
	}
	
	//Generic toString to display the amount of comparisons per sort method
	public static <T extends Comparable<T>> String toString(T[] data)
	{
		return "Algorithm          # of Comparisons"
			+ "\n-----------------------------------"	
			+ "\nBubbleSort         " + bubbleComparisons 
			+ "\nSelectionSort      " + selectComparisons 
			+ "\nInsertionSort      " + insertComparisons
			+ "\nMergeSort          " + mergeComparisons
			+ "\nQuickSort          " + quickComparisons;
	}
}