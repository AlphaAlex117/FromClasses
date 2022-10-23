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
 * @author Alexander Lafontaine
 */
public class WildlifeTest {

	Plain pOldRandom;
	Plain pOldFile;
	Plain pNew;
	
	@Before
	public void WildlifeSetUp() throws FileNotFoundException
	{
		pOldRandom = new Plain(3);
		pOldRandom.randomInit();
		
		pOldFile = new Plain("public1-3x3.txt");
		
		pNew = new Plain(3);
	}
	
	@Test
	public void UpdateRandom()
	{
		Wildlife.updatePlain(pOldRandom, pNew);
	}
	
	@Test
	public void UpdateFile()
	{
		Wildlife.updatePlain(pOldFile, pNew);
	}
}
