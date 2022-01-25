package jsjf ;
import java.util.* ;

public class Main
{
	public static void main( String[] args )
	{
		ExerciseHeapSort() ;
		ExercisePriorityQueue() ;
	}
	
	public static void ExerciseHeapSort()
	{
		Integer[] ints = new Integer[ 10 ] ;
		ints[ 0 ] =  2 ;
		ints[ 1 ] =  8 ;
		ints[ 2 ] =  5 ;
		ints[ 3 ] =  6 ;
		ints[ 4 ] =  7 ;
		ints[ 5 ] =  4 ;
		ints[ 6 ] =  3 ;
		ints[ 7 ] =  1 ;
		ints[ 8 ] = 10 ;
		ints[ 9 ] =  9 ;
		
		System.out.println( "Heap Sort Demo" ) ;
		System.out.println( "------------------------------------------" ) ;
		System.out.println( "Pre-sort : " + Arrays.toString( ints ) ) ;
		HeapSort.Sort( ints ) ;
		System.out.println( "Post-sort: " + Arrays.toString( ints ) ) ;
		System.out.println() ;
	}
	
	public static void ExercisePriorityQueue()
	{
		ArrayList<PrioritizedObject<Integer>> prioritizedInts = new ArrayList<>() ;
		prioritizedInts.add( new PrioritizedObject<>(  2, 4 ) ) ;
		prioritizedInts.add( new PrioritizedObject<>(  8, 3 ) ) ;
		prioritizedInts.add( new PrioritizedObject<>(  5, 3 ) ) ;
		prioritizedInts.add( new PrioritizedObject<>(  6, 3 ) ) ;
		prioritizedInts.add( new PrioritizedObject<>(  7, 2 ) ) ;
		prioritizedInts.add( new PrioritizedObject<>(  4, 2 ) ) ;
		prioritizedInts.add( new PrioritizedObject<>(  3, 2 ) ) ;
		prioritizedInts.add( new PrioritizedObject<>(  1, 1 ) ) ;
		prioritizedInts.add( new PrioritizedObject<>( 10, 1 ) ) ;
		prioritizedInts.add( new PrioritizedObject<>(  9, 1 ) ) ;
		
		PriorityQueue<Integer> pq = new PriorityQueue<>() ;
		for( int i = 0 ; i < prioritizedInts.size() ; ++i )
			pq.addElement( prioritizedInts.get( i ) ) ;
		
		Integer[] dequeued = new Integer[ prioritizedInts.size() ] ;
		for( int i = 0 ; i < dequeued.length ; ++i )
			dequeued[ i ] = pq.removeNext() ; 
		
		System.out.println( "Priority Queue Demo" ) ;
		System.out.println( "------------------------------------------" ) ;
		System.out.println( "Unprioritized Order: " + Arrays.toString( prioritizedInts.toArray() ) ) ;
		System.out.println( "Prioritized Order .: " + Arrays.toString( dequeued ) ) ;
		System.out.println() ;
	}
}
