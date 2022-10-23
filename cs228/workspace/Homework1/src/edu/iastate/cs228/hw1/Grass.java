package edu.iastate.cs228.hw1;

/**
 *  
 * @author Alexander Lafontaine
 *
 */

/**
 * Grass remains if more than rabbits in the neighborhood; otherwise, it is eaten. 
 *
 */
public class Grass extends Living 
{
	public Grass (Plain p, int r, int c) 
	{
		super.plain = p;
		super.row = r;
		super.column = c;
	}
	
	public State who()
	{ 
		return State.GRASS; 
	}
	
	/**
	 * Grass can be eaten out by too many rabbits. Rabbits may also multiply fast enough to take over Grass.
	 */
	public Living next(Plain pNew)
	{
		// Collects information of the neighborhood.
		int[] neighborhood = new int[NUM_LIFE_FORMS];
		census(neighborhood); 
		
		// Survival Rules
		if (neighborhood[RABBIT] / neighborhood[GRASS] >= 3)
		{
			return new Empty(pNew, this.row, this.column);
		}
		else if (neighborhood[RABBIT] >= 3)
		{
			return new Rabbit(pNew, this.row, this.column, 0);
		}
		else
		{
			return new Grass(pNew, this.row, this.column);
		}
	}
}
