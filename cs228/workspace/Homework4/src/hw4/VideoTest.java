package hw4;

import org.junit.Test;

import edu.iastate.cs228.hw4.SplayTree;
import edu.iastate.cs228.hw4.Video;

import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class VideoTest {

	@Test
	public void toStringTest()
	{
		Video videoTest = new Video("Star Wars", 7);
		
		System.out.println(videoTest.toString());
	}
}
