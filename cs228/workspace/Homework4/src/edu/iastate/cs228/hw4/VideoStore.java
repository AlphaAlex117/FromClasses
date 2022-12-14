package edu.iastate.cs228.hw4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner; 

/**
 * 
 * @author Alexander Lafontaine
 *
 */

public class VideoStore 
{
	protected SplayTree<Video> inventory;     // all the videos at the store
	
	// ------------
	// Constructors 
	// ------------
	
    /**
     * Default constructor sets inventory to an empty tree. 
     */
    public VideoStore()
    {
    	// no need to implement. 
    }
    
    
	/**
	 * Constructor accepts a video file to create its inventory.  Refer to Section 3.2 of  
	 * the project description for details regarding the format of a video file. 
	 * 
	 * Calls setUpInventory(). 
	 * 
	 * @param videoFile  no format checking on the file
	 * @throws FileNotFoundException
	 */
    public VideoStore(String videoFile) throws FileNotFoundException  
    {
    	setUpInventory(videoFile);
    }
    
    
   /**
     * Accepts a video file to initialize the splay tree inventory.  To be efficient, 
     * add videos to the inventory by calling the addBST() method, which does not splay. 
     * 
     * Refer to Section 3.2 for the format of video file. 
     * 
     * @param  videoFile  correctly formated if exists
     * @throws FileNotFoundException 
     */
    public void setUpInventory(String videoFile) throws FileNotFoundException
    {
    	inventory = new SplayTree<Video>();
    	
    	/*
    	 * Loops through every movie ordered and adds them to the tree. Using private method and class.
    	 */
    	ArrayList<String> list = readVideoFile(videoFile);
    	for (String data : list)
    	{
    		FilmInfo info = filmInfoMaker(data);
    		addVideo(info.filmName, info.amount);
    	}
    }
	
    
    // ------------------
    // Inventory Addition
    // ------------------
    
    /**
     * Find a Video object by film title. 
     * 
     * @param film
     * @return
     */
	public Video findVideo(String film) 
	{
		 return inventory.findElement(new Video(film));
	}


	/**
	 * Updates the splay tree inventory by adding a number of video copies of the film.  
	 * (Splaying is justified as new videos are more likely to be rented.) 
	 * 
	 * Calls the add() method of SplayTree to add the video object.  
	 * 
	 *     a) If true is returned, the film was not on the inventory before, and has been added.  
	 *     b) If false is returned, the film is already on the inventory. 
	 *     
	 * The root of the splay tree must store the corresponding Video object for the film. Update 
	 * the number of copies for the film.  
	 * 
	 * @param film  title of the film
	 * @param n     number of video copies 
	 */
	public void addVideo(String film, int n)  
	{
		Video newVideo = new Video(film,n);
		boolean addValue = inventory.add(newVideo);
		if (!addValue)
		{
			inventory.getRoot().addNumCopies(n);
		}
	}
	

	/**
	 * Add one video copy of the film. 
	 * 
	 * @param film  title of the film
	 */
	public void addVideo(String film)
	{
		addVideo(film, 1);
	}
	

	/**
     * Update the splay trees inventory by adding videos.  Perform binary search additions by 
     * calling addBST() without splaying. 
     * 
     * The videoFile format is given in Section 3.2 of the project description. 
     * 
     * @param videoFile  correctly formated if exists 
     * @throws FileNotFoundException
     */
    public void bulkImport(String videoFile) throws FileNotFoundException 
    {
    	/*
    	 * Loops through every movie ordered and adds them to the tree. Using private method and class.
    	 */
    	ArrayList<String> list = readVideoFile(videoFile);
    	for (String data : list)
    	{
    		FilmInfo info = filmInfoMaker(data);
    		Video newVideo = new Video(info.filmName, info.amount);
    		inventory.addBST(newVideo);
    	}
    }

    
    // ----------------------------
    // Video Query, Rental & Return 
    // ----------------------------
    
	/**
	 * Search the splay tree inventory to determine if a video is available. 
	 * 
	 * @param  film
	 * @return true if available
	 */
	public boolean available(String film)
	{
		Video foundVideo = findVideo(film);
		// If the titles don't match, return false.
		if (foundVideo.getFilm().compareTo(film) != 0)
		{
			return false;
		}
		else if (foundVideo.getNumAvailableCopies() > 0)
		{
			return true;
		}
		else
		{
			return false; 
		}
	}

	
	
	/**
     * Update inventory. 
     * 
     * Search if the film is in inventory by calling findElement(new Video(film, 1)). 
     * 
     * If the film is not in inventory, prints the message "Film <film> is not 
     * in inventory", where <film> shall be replaced with the string that is the value 
     * of the parameter film.  If the film is in inventory with no copy left, prints
     * the message "Film <film> has been rented out".
     * 
     * If there is at least one available copy but n is greater than the number of 
     * such copies, rent all available copies. In this case, no AllCopiesRentedOutException
     * is thrown.  
     * 
     * @param film   
     * @param n 
     * @throws IllegalArgumentException      if n <= 0 or film == null or film.isEmpty()
	 * @throws FilmNotInInventoryException   if film is not in the inventory
	 * @throws AllCopiesRentedOutException   if there is zero available copy for the film.
	 */
	public void videoRent(String film, int n) throws IllegalArgumentException, FilmNotInInventoryException,  
									     			 AllCopiesRentedOutException 
	{
		// Just in case I have to correct user input (Based on PDF example).
		FilmInfo info = filmInfoMaker(film);
		film = info.filmName;
		n = info.amount;
		
				
		if (n <= 0 || film == null || film.isEmpty())
		{
			System.out.println("Film " + film + " has an invalid request");
		}
		
		Video foundVideo = findVideo(film);
		
		if (!available(film))
		{
			if (foundVideo.getFilm().compareTo(film) != 0)
			{
				System.out.println("Film " + film + " is not in inventory");
			}
			else
			{
				System.out.println("Film " + film + " has been rented out");
			}
		}
		
		foundVideo.rentCopies(n);
		
	}

	
	/**
	 * Update inventory.
	 * 
	 *    1. Calls videoRent() repeatedly for every video listed in the file.  
	 *    2. For each requested video, do the following: 
	 *       a) If it is not in inventory or is rented out, an exception will be 
	 *          thrown from videoRent().  Based on the exception, prints out the following 
	 *          message: "Film <film> is not in inventory" or "Film <film> 
	 *          has been rented out." In the message, <film> shall be replaced with 
	 *          the name of the video. 
	 *       b) Otherwise, update the video record in the inventory.
	 * 
	 * For details on handling of multiple exceptions and message printing, please read Section 3.4 
	 * of the project description. 
	 *       
	 * @param videoFile  correctly formatted if exists
	 * @throws FileNotFoundException
     * @throws IllegalArgumentException     if the number of copies of any film is <= 0
	 * @throws FilmNotInInventoryException  if any film from the videoFile is not in the inventory 
	 * @throws AllCopiesRentedOutException  if there is zero available copy for some film in videoFile
	 */
	public void bulkRent(String videoFile) throws FileNotFoundException, IllegalArgumentException, 
												  FilmNotInInventoryException, AllCopiesRentedOutException 
	{
		/*
    	 * Loops through every movie ordered and rents an amount of each of them. Using private method and class.
    	 */
		ArrayList<String> list = readVideoFile(videoFile);
    	for (String data : list)
    	{
    		videoRent(data, 1);
    	}
	}

	
	/**
	 * Update inventory.
	 * 
	 * If n exceeds the number of rented video copies, accepts up to that number of rented copies
	 * while ignoring the extra copies. 
	 * 
	 * @param film
	 * @param n
	 * @throws IllegalArgumentException     if n <= 0 or film == null or film.isEmpty()
	 * @throws FilmNotInInventoryException  if film is not in the inventory
	 */
	public void videoReturn(String film, int n) throws IllegalArgumentException, FilmNotInInventoryException 
	{	
		// Just in case I have to correct user input (Based on PDF example).
		FilmInfo info = filmInfoMaker(film);
		film = info.filmName;
		n = info.amount;
		
		
		if (n <= 0 || film == null || film.isEmpty())
		{
			System.out.println("Film " + film + " has an invalid request");
		}
		
		Video foundVideo = findVideo(film);
		
		if (foundVideo.getFilm().compareTo(film) != 0)
		{
			System.out.println("Film " + film + " is not in inventory");
		}
		
		// Accepts up to the amount of rented copies.
		if (n > foundVideo.getNumRentedCopies())
		{
			n = foundVideo.getNumRentedCopies();
		}
		
		foundVideo.returnCopies(n);
	}
	
	
	/**
	 * Update inventory. 
	 * 
	 * Handles excessive returned copies of a film in the same way as videoReturn() does.  See Section 
	 * 3.4 of the project description on how to handle multiple exceptions. 
	 * 
	 * @param videoFile
	 * @throws FileNotFoundException
	 * @throws IllegalArgumentException    if the number of return copies of any film is <= 0
	 * @throws FilmNotInInventoryException if a film from videoFile is not in inventory
	 */
	public void bulkReturn(String videoFile) throws FileNotFoundException, IllegalArgumentException,
													FilmNotInInventoryException												
	{
		/*
    	 * Loops through every movie ordered and returns an amount of each of them. Using private method and class.
    	 */
    	ArrayList<String> list = readVideoFile(videoFile);
    	for (String data : list)
    	{
    		videoReturn(data, 1);
    	}
	}
		
	

	// ------------------------
	// Methods without Splaying
	// ------------------------
		
	/**
	 * Performs inorder traversal on the splay tree inventory to list all the videos by film 
	 * title, whether rented or not.  Below is a sample string if printed out: 
	 * 
	 * 
	 * Films in inventory: 
	 * 
	 * A Streetcar Named Desire (1) 
	 * Brokeback Mountain (1) 
	 * Forrest Gump (1)
	 * Psycho (1) 
	 * Singin' in the Rain (2)
	 * Slumdog Millionaire (5) 
	 * Taxi Driver (1) 
	 * The Godfather (1) 
	 * 
	 * 
	 * @return
	 */
	public String inventoryList()
	{	
		Iterator<Video> iter = inventory.iterator();
		
		String list = "Films in inventory:\n\n";
		while (iter.hasNext())
		{
			Video video = iter.next();
			list += video.getFilm() + " (" + video.getNumCopies() + ")" + "\n";
		}
		
		return list; 
	}

	
	/**
	 * Calls rentedVideosList() and unrentedVideosList() sequentially.  For the string format, 
	 * see Transaction 5 in the sample simulation in Section 4 of the project description. 
	 *   
	 * @return 
	 */
	public String transactionsSummary()
	{
		String summary = rentedVideosList() + "\n" + unrentedVideosList();
		return summary; 
	}	
	
	/**
	 * Performs inorder traversal on the splay tree inventory.  Use a splay tree iterator.
	 * 
	 * Below is a sample return string when printed out:
	 * 
	 * Rented films: 
	 * 
	 * Brokeback Mountain (1)
	 * Forrest Gump (1) 
	 * Singin' in the Rain (2)
	 * The Godfather (1)
	 * 
	 * 
	 * @return
	 */
	public String rentedVideosList()
	{
		Iterator<Video> iter = inventory.iterator();
		
		String list = "Rented films:\n\n";
		while (iter.hasNext())
		{
			Video video = iter.next();
			
			if (video.getNumRentedCopies() != 0)
			{
				list += video.getFilm() + " (" + video.getNumRentedCopies() + ")" + "\n";
			}
		}
		
		return list; 
	}

	
	/**
	 * Performs inorder traversal on the splay tree inventory.  Use a splay tree iterator.
	 * Prints only the films that have unrented copies. 
	 * 
	 * Below is a sample return string when printed out:
	 * 
	 * 
	 * Films remaining in inventory:
	 * 
	 * A Streetcar Named Desire (1) 
	 * Forrest Gump (1)
	 * Psycho (1) 
	 * Slumdog Millionaire (4) 
	 * Taxi Driver (1) 
	 * 
	 * 
	 * @return
	 */
	public String unrentedVideosList()
	{
		Iterator<Video> iter = inventory.iterator();
		
		String list = "Films remaining in inventory:\n\n";
		while (iter.hasNext())
		{
			Video video = iter.next();
			
			if (video.getNumAvailableCopies() != 0)
			{
				list += video.getFilm() + " (" + video.getNumAvailableCopies() + ")" + "\n";
			}
		}
		
		return list; 
	}	

	
	/**
	 * Parse the film name from an input line. 
	 * 
	 * @param line
	 * @return
	 */
	public static String parseFilmName(String line) 
	{
		line = line.trim();
		return line; 
	}
	
	
	/**
	 * Parse the number of copies from an input line. 
	 * 
	 * @param line
	 * @return
	 */
	public static int parseNumCopies(String line) 
	{
		int amount = Integer.parseInt(line);
		return amount; 
	}
	
	/**
	 * Creates an ArrayList with information of the movie and the amount. Used in bulk methods.
	 * @param videoFile
	 * @return filmList
	 * @throws FileNotFoundException
	 */
	private ArrayList<String> readVideoFile(String videoFile) throws FileNotFoundException
	{
		ArrayList<String> filmList = new ArrayList<String>();
		
		File file = null;
    	Scanner input = null;
    	
    	/*
    	 *  Try to see if there is a file with the name.
    	 *  Then, while there are lines in the file, add them.
    	 */
    	try
    	{
    		// Finds file and then places it int he scanner.
    		file = new File(videoFile);
    		input = new Scanner(file);
    		
    		/*
    		 * While there are lines of films, keep iterating.
    		 * 		Separate the name from the amount.
    		 * 		Use this to add a new video film.
    		 */
    		while (input.hasNextLine())
    		{
    			String data = input.nextLine();
    			
    			// Adds to list.
    			filmList.add(data);
    		}
    	}
    	catch (FileNotFoundException e)
    	{
    		throw new FileNotFoundException();
    	}
    	finally
    	{
    		input.close();
    	}
		
		return filmList;
	}
	
	/**
	 * Separates the name and amount.
	 * @param data
	 * @return new FilmInfo
	 */
	private FilmInfo filmInfoMaker(String data)
	{
		/*
		 * If it doesn't have a ')' parenthesis, assume it is name only.
		 * Otherwise, find '(' parenthesis while creating the name. Then find number.
		 */
		if (data.charAt(data.length() - 1) != ')')
		{
			FilmInfo info = new FilmInfo(data,"1");
			return info;
		}
		else
		{
			String name = "";
			String number = "";
			
			int i = 0;
			// Make name
			for (i = 0; data.charAt(i) != '('; i++)
			{
				name += data.charAt(i);
			}
			
			// Make number
			for (i = i+1;data.charAt(i) != ')'; i++)
			{
				number += data.charAt(i);
			}
			FilmInfo info = new FilmInfo(name, number);
			return info;
		}
	}
	
	/**
	 * Stores film information that automatically parses the data.
	 * @author Alexander Lafontaine
	 *
	 */
	private class FilmInfo
	{
		private String filmName;
		private int amount;
		
		private FilmInfo(String name, String number)
		{
			filmName = parseFilmName(name);
			amount = parseNumCopies(number);
			if (amount < 0)
			{
				amount = 0;
			}
		}
	}
}
