package edu.iastate.cs228.hw1;

/**
 *  
 * @author Alexander Lafontaine
 *
 */

/**
 * A fox eats rabbits and competes against a badger. 
 */
public class Fox extends Animal 
{
	/**
	 * Constructor 
	 * @param p: plain
	 * @param r: row position 
	 * @param c: column position
	 * @param a: age 
	 */
	public Fox (Plain p, int r, int c, int a) 
	{
		super.plain = p;
		super.row = r;
		super.column = c;
		super.age = a;
	}
		
	/**
	 * A fox occupies the square. 	 
	 */
	public State who()
	{
		return State.FOX; 
	}
	
	/**
	 * A fox dies of old age or hunger, or from attack by numerically superior badgers. 
	 * @param pNew     plain of the next cycle
	 * @return Living  life form occupying the square in the next cycle. 
	 */
	public Living next(Plain pNew)
	{
		// Collects information of the neighborhood.
		int[] neighborhood = new int[NUM_LIFE_FORMS];
		census(neighborhood);
		
		// Survival Rules
		if (this.age == FOX_MAX_AGE)
		{
			return new Empty(pNew, this.row, this.column);
		}
		else if (neighborhood[BADGER] > neighborhood[FOX])
		{
			return new Badger(pNew, this.row, this.column, 0);
		}
		else if (neighborhood[BADGER] + neighborhood[FOX] > neighborhood[RABBIT])
		{
			return new Empty(pNew, this.row, this.column);
		}
		else
		{
			return new Fox(pNew, this.row, this.column, this.age + 1);
		}
	}
}
