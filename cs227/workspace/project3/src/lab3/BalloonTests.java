package lab3;

import balloon.Balloon;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class BalloonTests
{
	private Balloon b;
	private Balloon b2;
	private Balloon b3;
	private Balloon b4;
	
	@Before
	public void setup()
	{
		b = new Balloon(10);
		b2 = new Balloon(15);
		b3 = new Balloon(-1);
	}
	
	// Tests the radius of a newly constructed balloon.
	@Test
	public void getRadiusTest()
	{
		assertEquals(0, b.getRadius());
	}
	
	// Checks if a newly constructed balloon is popped.
	@Test
	public void isPoppedTest()
	{
		assertEquals(false, b.isPopped());
	}
	
	// Tests the radius of the balloon after blowing it.
	@Test
	public void getRadiusAfterBlowTest()
	{
		b.blow(5);
		assertEquals(5, b.getRadius());
	}
	
	
	// Checks if, after blowing the balloon but not beyond its maximum, it has popped.
	@Test
	public void isPoppedAfterBlowTest()
	{
		b.blow(5);
		assertEquals(false, b.isPopped());
	}
	
	// Tests the radius of the balloon after deflating it.
	@Test
	public void getRadiusAfterDeflateTest()
	{
		b.blow(2);
		b.deflate();
		assertEquals(0, b.getRadius());
	}
	
	// Checks if, after deflating the balloon, it has popped.
	@Test
	public void isPoppedAfterDeflateTest()
	{
		b.blow(2);
		b.deflate();
		assertEquals(false, b.isPopped());
	}
	
	// Tests the radius after popping the balloon.
	@Test
	public void getRadiusAfterPopTest() 
	{
		b.blow(2);
		b.pop();
		assertEquals(0, b.getRadius());
	}
	
	// Checks if, after popping the balloon, it has popped.
	@Test
	public void isPoppedAfterPoppedTest()
	{
		b.blow(2);
		b.pop();
		assertEquals(true, b.isPopped());
	}
	
	// Tests radius after blowing a popped balloon.
	@Test
	public void getRadiusAfterBlowAndPop()
	{
		b2.pop();
		b2.blow(15);
		assertEquals(0, b.getRadius());
	}
	
	// Checks if, after blowing a popped balloon, it is popped.
	@Test
	public void isPoppedAfterBlowAndPop()
	{
		b2.pop();
		b2.blow(15);
		assertEquals(true, b2.isPopped());
	}
	
	
	// Tests for after the balloon is popped and when you expand it beyond its maximum.
	
	
	// Tests the radius after inflating it beyond the balloon's capacity.
	@Test
	public void getRadiusAfterTooMuchInflatingTest()
	{
		b2.blow(17);
		assertEquals(0, b2.getRadius());
	}
	
	// Checks if, after inflating the balloon beyond maximum, it has popped.
	@Test
	public void isPoppedAfterTooMuchInflatingTest()
	{
		b2.blow(17);
		assertEquals(true, b2.isPopped());
	}
	
	
	// Tests for negative numbers.
	
	
	// Tests radius after the balloon is initialized with negative radius.
	@Test
	public void getNegativeRadiusTest()
	{
		assertEquals(0, b3.getRadius());
	}
	
	// Checks if balloon is popped after initialized with negative radius.
	@Test
	public void isNegativePoppedTest()
	{
		assertEquals(false, b3.isPopped());
	}
	
	// Tests radius after blowing negative radius to the balloon.
	@Test
	public void getNegativeRadiusAfterBlowTest()
	{
		b3.blow(-5);
		assertEquals(0, b3.getRadius());
	}
	
	// Checks if, after blowing negative radius to the balloon, if popped.
	@Test
	public void isNegativePoppedAfterBlowTest()
	{
		b3.blow(-5);
		assertEquals(false, b3.isPopped());
	}
	
	@Test
	public void getRadiusAfterBlowTwice()
	{
		b.blow(3);
		b.blow(2);
		assertEquals(5, b.getRadius());
	}
	
}