package hw2.tests;
import edu.iastate.cs228.hw2.Algorithm;
import edu.iastate.cs228.hw2.Point;
import edu.iastate.cs228.hw2.PointScanner;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;

public class PointScannerTest {
	
	@Test
	public void TestingEverything() throws InputMismatchException, FileNotFoundException
	{
		PointScanner p = new PointScanner("points.txt", Algorithm.SelectionSort);
		p.scan();
		System.out.println(p.stats());
		System.out.println(p.toString());
	}
}
