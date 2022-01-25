
//SolveTowers uses recursion to solve the Towers of Hanoi puzzle
public class solveTowers
{
	//Creates a TowersofHanoi puzzle and solves it
	public static void main(String[] args)
	{
		TowersOfHanoi towers = new TowersOfHanoi(4);
		towers.solve();
		
	}
}
