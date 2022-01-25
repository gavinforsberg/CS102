public class Tester
{
	public static void main(String[] args) throws EmptyCollectionException
	{
		System.out.println("Testing LinkedQueue... ");
		System.out.println("=-=-=-==-=-=-==-=-=-=-=-=-=-=-=-=-=-=-");
		
		System.out.println();
		
		LinkedQueue<String> queue = new LinkedQueue<String>();
		
		queue.enqueue("Jake");
		queue.enqueue("Greg");
		queue.enqueue("Mumtahan");
		
		DoQueueStuff(queue);
		
		LinkedQueue<Integer> queue2 = new LinkedQueue<Integer>();
		
		queue2.enqueue(1);
		queue2.enqueue(2);
		queue2.enqueue(3);
		queue2.enqueue(4);
	
		DoQueueStuff(queue2);
		
		System.out.println();
		
		
		///////////////////////////////////
		//CircularArrayQueue
		//////////////////////////////////
		System.out.println("Testing CircularArrayQueue...");
		System.out.println("=-=-=-==-=-=-==-=-=-=-=-=-=-=-=-=-=-=-");
		CircularArrayQueue<String> queue3 = new CircularArrayQueue<String>();
		queue3.enqueue("Jake");
		queue3.enqueue("Greg");
		queue3.enqueue("Mumtahan");
		
		DoQueueStuff(queue);
		
		CircularArrayQueue<Integer> queue4 = new CircularArrayQueue<Integer>();
		
		queue4.enqueue(1);
		queue4.enqueue(2);
		queue4.enqueue(3);
		queue4.enqueue(4);
	
		DoQueueStuff(queue4);
		
		System.out.println();
	}

	
	public static <T> void DoQueueStuff(QueueADT<T> queue) throws EmptyCollectionException
	{
		System.out.print("Before Queueing: ");
		System.out.println(queue);
		T result = queue.dequeue();
		System.out.println("Dequeued " + result);
		System.out.print("After Pop: ");
		System.out.println(queue);
	
	}
}