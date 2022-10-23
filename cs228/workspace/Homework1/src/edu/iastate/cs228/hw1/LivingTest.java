package edu.iastate.cs228.hw1;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * 
 * @author Alexander Lafontaine
 *
 */
public class LivingTest {
	
	private Plain p;
	private int[] pop;
	
	@Before
	public void LivingSetUp()
	{
		// Initializes a 3x3 Plain and assigns random Living objects
		p = new Plain(3);
		p.randomInit();
		
		// Initializes population array
		pop = new int[Living.NUM_LIFE_FORMS];
		
	}
	
	@Test
	public void RandomCensusMiddleTest()
	{
		Living l = p.grid[1][1];
		l.census(pop);
		
		for (int amount : pop)
		{
			System.out.println(amount);
		}
		System.out.println();
		
		for (int i = 0; i < p.grid.length; ++i)
		{
			for (int j = 0; j < p.grid[0].length; ++j)
			{
				System.out.println(p.grid[i][j].who());
			}
		}
		System.out.println();
	}
	
	@Test
	public void RandomCensusTopLeftCornerTest()
	{
		Living l0 = p.grid[0][0];
		
		l0.census(pop);
		
		for (int amount : pop)
		{
			System.out.println(amount);
		}
		System.out.println();
	}
	
	@Test
	public void RandomCensusBottomRightCornerTest()
	{
		Living l2 = p.grid[2][2];
		
		l2.census(pop);
		
		for (int amount : pop)
		{
			System.out.println(amount);
		}
		System.out.println();
	}
	
	@Test
	public void RandomCensusEdgeTest()
	{
		Living l1 = p.grid[1][0];
		l1.census(pop);
		
		for (int amount : pop)
		{
			System.out.println(amount);
		}
		System.out.println();
	}
	
}
