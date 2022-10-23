package hw4;

import org.junit.Test;

import edu.iastate.cs228.hw4.AllCopiesRentedOutException;
import edu.iastate.cs228.hw4.FilmNotInInventoryException;
import edu.iastate.cs228.hw4.SplayTree;
import edu.iastate.cs228.hw4.Video;
import edu.iastate.cs228.hw4.VideoStore;

import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;

public class VideoStoreTest {
	
	VideoStore store1;
	
	@Before
	public void SetUp() throws FileNotFoundException
	{
		store1 = new VideoStore("videoList1.txt");
	}
	
	@Test
	public void findVideoTest()
	{
		Video searchingVideo = store1.findVideo("Star Wars: Revenge of the Sith");
		System.out.println(searchingVideo.getFilm());
	}
	
	@Test
	public void addVideoTest()
	{
		Video searchingVideo = store1.findVideo("Star Wars: Attack of the Clones");
		System.out.println(searchingVideo.getFilm());
		store1.addVideo("Star Wars: Attack of the Clones");
		searchingVideo = store1.findVideo("Star Wars: Attack of the Clones");
		System.out.println(searchingVideo.getFilm());
	}
	
	@Test
	public void addBulkVideoTest() throws FileNotFoundException
	{
		Video searchingVideo = store1.findVideo("Star Wars: Attack of the Clones");
		System.out.println(searchingVideo.getFilm());
		store1.bulkImport("videoListSciFi.txt");
		searchingVideo = store1.findVideo("Star Wars: Attack of the Clones");
		System.out.println(searchingVideo.getFilm());
	}
	
	@Test
	public void availableTest() throws FileNotFoundException
	{
		System.out.println(store1.available("Star Wars: A New Hope"));
		store1.bulkImport("videoListSciFi.txt");
		System.out.println(store1.available("Star Wars: A New Hope"));
	}
	
	@Test
	public void rentTest() throws IllegalArgumentException, FilmNotInInventoryException, AllCopiesRentedOutException
	{
		//store1.videoRent("Revenge Of the Sith", 1);
		//store1.videoRent("Forrest Gump", 1);
		//store1.videoRent("Forrest Gump", 1);
	}
	
	/*
	 * Open this one if you are beginning to implement VideoStore class.
	 */
	//@Test
	//public void SetUpInventoryTest() throws FileNotFoundException
	//{
	//	store1.setUpInventory("videoList1.txt");
	//}
	
	@Test
	public void inventoryListTest()
	{
		System.out.println(store1.inventoryList());
	}
	
	@After
	public void AfterTestSeparator()
	{
		System.out.println();
		System.out.println("__________End Line__________");
		System.out.println();
	}
	
}
