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
public class AnimalTest {

	private Plain p;
	private Animal b;
	private Animal f;
	private Animal r;
	
	@Before
	public void AnimalSetUp()
	{
		p = new Plain(3);
		b = new Badger(p, 0, 0, 2);
		f = new Fox(p, 1, 1, 3);
		r = new Rabbit(p, 2, 2, 1);
		
	}
	
	// Return the age of all animal types.
	@Test
	public void ReturnAnimalAge()
	{
		assertEquals(2, b.myAge());
		assertEquals(3, f.myAge());
		assertEquals(1, r.myAge());
	}
}
