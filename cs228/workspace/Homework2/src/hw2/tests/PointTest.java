package hw2.tests;
import org.junit.Test;

import edu.iastate.cs228.hw2.Point;

import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class PointTest {
	
	Point testPoint;
	Point testPoint2;
	Point testPoint3;
	Point testPoint4;
	
	@Before
	public void PointSetUp()
	{
		testPoint = new Point(5, 4);
		testPoint2 = new Point(2, 6);
		testPoint3 = new Point(5, 6);
		testPoint4 = new Point(5, 4);
	}
	
	@Test
	public void PointToStringTest()
	{
		assertEquals("(5, 4)", testPoint.toString());
	}
	
	@Test
	public void xORyTest()
	{
		Point.setXorY(true);
		assertTrue(Point.xORy);
		Point.setXorY(false);
		assertFalse(Point.xORy);
	}

	@Test
	public void compareToTest()
	{
		Point.setXorY(true);
		assertEquals(-1, testPoint2.compareTo(testPoint));
		Point.setXorY(false);
		assertEquals(1, testPoint2.compareTo(testPoint));
		assertEquals(0, testPoint4.compareTo(testPoint));
	}
}
