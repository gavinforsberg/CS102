/*
 * Gavin Forsberg
 * RecusiveAlgorithm.java
 * Project4.zip
 * Program which takes a normal number and recursively displays the 
 * Fibonacci number to match it. (The sum of the two preceding numbers)
 */

public class RecursiveAlgorithm
{
	//Fibonacci Tester
	public static void main(String[] args)
	{
		int n = 46;
		System.out.println(Fibonacci(n));
	}
	
	//Recursive method to produce 
	public static int Fibonacci(int number)
	{	//If less than or 1, return it
		if(number <= 1)
			return number;
		else //Recursive step for Fibonacci sequence
			return Fibonacci(number - 1) + Fibonacci(number - 2);
	}
}




















