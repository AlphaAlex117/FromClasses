package edu.iastate.cs228.hw1;

/**
 *  
 * @author Alexander Lafontaine
 *
 */

/** 
 * Empty squares are competed by various forms of life.
 */
public class Empty extends Living 
{
	public Empty (Plain p, int r, int c) 
	{
		super.plain = p;
		super.row = r;
		super.column = c;
	}
	
	public State who()
	{
		return State.EMPTY; 
	}
	
	/**
	 * An empty square will be occupied by a neighboring Badger, Fox, Rabbit, or Grass, or remain empty. 
	 * @param pNew     plain of the next life cycle.
	 * @return Living  life form in the next cycle.   
	 */
	public Living next(Plain pNew)
	{
		// Collects information of the neighborhood.
		int[] neighborhood = new int[NUM_LIFE_FORMS];
		census(neighborhood); 
		
		//  Survival Rules
		if (neighborhood[RABBIT] > 1)
		{
			return new Rabbit(pNew, this.row, this.column, 0);
		}
		else if (neighborhood[FOX] > 1)
		{
			return new Fox(pNew, this.row, this.column, 0);
		}
		else if (neighborhood[BADGER] > 1)
		{
			return new Badger(pNew, this.row, this.column, 0);
		}
		else if (neighborhood[GRASS] >= 1)
		{
			return new Grass(pNew, this.row, this.column);
		}
		else
		{
			return new Empty(pNew, this.row, this.column);
		}
	}
}
