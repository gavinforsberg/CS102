

/* MazeSolver attempts to recursively traverse a Maze. The goal is to get from the given starting position to the bottom right, 
 * following a path of 1's. Arbitrary constants are used to represent location in the maze that have been TRIED and that are part 
 * of the solution PATH.
 */
public class MazeSolver
{
	private Maze _maze;
	
	//Constructor for the MazeSolver Class
	public MazeSolver(Maze maze)
	{
		_maze = maze;
	}
	
	//Attempts to recursively traverse the maze. Inserts special characters indicating locations that have been TRIED and 
	//that eventually become part of the solution PATH.
	public boolean traverse(int row, int column)
	{
		boolean done = false;
		
		if(_maze.validPosition(row, column))
		{
			_maze.tryPosition(row, column);	//mark this cell as tried
			if(row == _maze.getRows() - 1 && column == _maze.getColumns() -1)
				done = true;	//This maze is solved
			else
			{
				done = traverse(row + 1, column);			//down
				if(!done)
					done = traverse(row, column + 1);		//right
				if(!done)
					done = traverse(row - 1, column);		//up
				if(!done)
					done = traverse(row, column - 1);		//left
			}
			
			if(done)		//this location is part of the final path
				_maze.markPath(row, column);
		}
		return done;
	}
}
