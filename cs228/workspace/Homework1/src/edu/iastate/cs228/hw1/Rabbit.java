package edu.iastate.cs228.hw1;

/**
 *  
 * @author Alexander Lafontaine
 *
 */

/*
 * A rabbit eats grass and lives no more than three years.
 */
public class Rabbit extends Animal 
{	
	/**
	 * Creates a Rabbit object.
	 * @param p: plain  
	 * @param r: row position 
	 * @param c: column position
	 * @param a: age 
	 */
	public Rabbit (Plain p, int r, int c, int a) 
	{
		super.plain = p;
		super.row = r;
		super.column = c;
		super.age = a;
	}
		
	// Rabbit occupies the square.
	public State who()
	{
		return State.RABBIT; 
	}
	
	/**
	 * A rabbit dies of old age or hunger. It may also be eaten by a badger or a fox.  
	 * @param pNew     plain of the next cycle 
	 * @return Living  new life form occupying the same square
	 */
	public Living next(Plain pNew)
	{
		// Collects information of the neighborhood.
		int[] neighborhood = new int[NUM_LIFE_FORMS];
		census(neighborhood);
		
		// Survival Rules
		if (this.age == RABBIT_MAX_AGE)
		{
			return new Empty(pNew, this.row, this.column);
		}
		else if (neighborhood[GRASS] == 0)
		{
			return new Empty(pNew, this.row, this.column);
		}
		else if (neighborhood[FOX] + neighborhood[BADGER] >= neighborhood[RABBIT] && neighborhood[FOX] > neighborhood[BADGER])
		{
			return new Fox(pNew, this.row, this.column, 0);
		}
		else if (neighborhood[BADGER] > neighborhood[RABBIT])
		{
			return new Badger(pNew, this.row, this.column, 0);
		}
		else 
		{
			return new Rabbit(pNew, this.row, this.column, this.age + 1);
		}
	}
}
