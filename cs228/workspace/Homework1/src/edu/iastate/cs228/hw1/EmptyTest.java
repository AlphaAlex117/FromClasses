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
public class EmptyTest {

	private Empty e;
	
	@Before
	public void EmptySetUp()
	{
		Plain p = new Plain(3);
		e = new Empty(p, 1, 1);
	}
	
	@Test
	public void CheckWhoMethod()
	{
		assertEquals(State.EMPTY, e.who());
	}
	
}
