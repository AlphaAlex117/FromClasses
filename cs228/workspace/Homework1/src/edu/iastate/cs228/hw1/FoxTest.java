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
public class FoxTest {

	private Fox f;
	
	@Before
	public void FoxSetUp()
	{
		Plain p = new Plain(3);
		f = new Fox(p, 1, 1, 1);
	}
	
	@Test
	public void CheckWhoMethod()
	{
		assertEquals(State.FOX, f.who());
	}
	
}
