import java.util.Scanner;

public class PostFixTester
{
	public static void main(String[] args)
	{
		String expression;
		String again;
		int result;
		
		Scanner in = new Scanner (System.in);
		
		do 
		{
			PostFixEvaluator evaluator = new PostFixEvaluator();
			
			System.out.println("Enter a valid post-fix expression one token " + 
						"at a time with a space between each token (e.g. 5 4 + 3 2 1 - + *)");
			
			System.out.println("Each token must be an integer or an operator (+, -, *, /,)");
			
			expression = in.nextLine();
			
			result = evaluator.evaluate(expression);
			
			System.out.println(); 
			System.out.println("That expresssion equals " + result);
			System.out.println();
			System.out.print("Evaluate another exprsion [Y/N]?");
			System.out.println();
			
			again = in.nextLine();
		
		} while(again.equalsIgnoreCase("y"));
	}
}
