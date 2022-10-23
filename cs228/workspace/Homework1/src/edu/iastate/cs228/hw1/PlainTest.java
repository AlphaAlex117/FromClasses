package edu.iastate.cs228.hw1;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;

/**
 * 
 * @author Alexander Lafontaine
 *
 */
public class PlainTest {
	
	@Test
	public void ConstructPlainByWidth()
	{
		Plain p = new Plain(3);
		assertEquals(3, p.getWidth());
		System.out.println();
	}
	
	@Test
	public void PlainHasNoNullAfterRandomAssignment()
	{
		Plain p = new Plain(3);
		p.randomInit();
		assertFalse(p.grid[0][0] == null);
		assertFalse(p.grid[2][2] == null);
	}
	
	@Test
	public void toStringTest()
	{
		Plain p = new Plain(3);
		p.randomInit();
		System.out.println(p.toString());
	}
	
	@Test
	public void FiveByFivePlainConstruction()
	{
		Plain p = new Plain(5);
		p.randomInit();
		System.out.println(p.toString());
	}
	
	@Test
	public void FileToPlainConstruction() throws FileNotFoundException
	{
		Plain p = new Plain("public1-3x3.txt");
		System.out.println(p.toString());
		
		Plain p2 = new Plain("public1-5cycles.txt");
		System.out.println(p2.toString());
		
		Plain p3 = new Plain("public3-10x10.txt");
		System.out.println(p3.toString());
	}
	
	@Test
	public void WriteToFile() throws FileNotFoundException
	{
		Plain p = new Plain(5);
		p.randomInit();
		System.out.println(p.toString());
		p.write("publictest.txt");
	}
}
