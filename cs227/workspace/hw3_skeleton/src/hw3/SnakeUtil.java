package hw3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import api.GridUtil;
import api.SnakeLayoutException;

/**
 * Utility methods for working with Snakes.
 * 
 * @author Alexander Lafontaine
 */
public class SnakeUtil
{
	/**
	 * Private constructor disables instantiation.
	 */
	private SnakeUtil()
	{
	}

	/**
	 * Given a descriptor array, return a list of all the snakes it contains. Snake
	 * pieces are represented in the descriptor array by id strings consisting of a
	 * single character followed by a number. All other text elements in the
	 * descriptor are single characters only and are ignored by this method. The
	 * first character of the id string becomes the "id" for the Snake. The number
	 * following the id becomes the actual list index for the corresponding piece of
	 * the snake. For example, if row 3 and column 5 of the descriptor is the string
	 * "g7", then the snake with id 'g' should have, at index 7 of its pieces list,
	 * a SnakePiece with row 3, column 5 .
	 * <p>
	 * This method first calls GridUtil.validateDescriptor, which may throw a
	 * SnakeLayoutException. In addition, after constructing the list of snakes,
	 * this method checks isValid() on each snake and throws SnakeLayoutException if
	 * any snake is found to be invalid.
	 * <p>
	 * The order of snakes within the returned list is unspecified.
	 * 
	 * @param desc descriptor array
	 * @return list of snakes in the descriptor
	 * @throws SnakeLayoutException if the descriptor fails to pass
	 *                              GridUtil.validateDescriptor or if any of the
	 *                              resulting snakes is invalid
	 */
	public static ArrayList<Snake> findSnakes(String[] desc)
	{
		/*
		 * 1) Calls GridUtil.validateDescriptor, which throws exception if something wrong.
		 * 		@input descriptor (string) array
		 * 2) Creates an ArrayList for Snake objects.
		 * 3) Reads through each symbol until it finds an id.
		 * 4) Creates a Snake and adds a SnakePiece with current coordinates.
		 * 5) Add snakepiece to the correct one.
		 * 6) After constructing each Snake, checks if they are valid with isValid()
		 */
		
		GridUtil.validateDescriptor(desc);
		ArrayList<Snake> snakeList = new ArrayList<>();
		
		for (int row = 0; row < desc.length; ++row)
		{
			// Separates tokens from string into an array.
			String[] tokens = desc[row].split("\\s+");
			
			for (int col = 0; col < tokens.length; ++col)
			{
				// Checks the length of the token.
				if (tokens[col].length() > 1)
				{
					// Separates the id and the number from the token.
					char id = tokens[col].charAt(0);
					String pieceNumber = tokens[col].substring(1, tokens[col].length());
					int index = Integer.parseInt(pieceNumber);
					
					// Resets these variables for the following process.
					boolean doesIdExist = false;
					int location = 0;
					
					// Iterates through ArrayList to check if there is a similar ID.
					for (location = 0; location < snakeList.size(); ++location)
					{
						// Grabs a snake from the array list and checks id.
						Snake locatedSnake = snakeList.get(location);
						
						// If there is a similar id, then it breaks out of the loop
						// and indicates that is has found a match.
						if (id == locatedSnake.getId())
						{
							doesIdExist = true;
							break;
						}
					}
					
					// If there was an ID match, then it adds the piece to the snake.
					// If no ID match was found, then it creates a new Snake.
					if (doesIdExist == true)
					{
						Snake snakeThatExists = snakeList.get(location);
						snakeThatExists.addPiece(index, row, col);
					}
					else
					{
						// Creates a new Snake with the given ID.
						Snake snake = new Snake(id);
						snake.addPiece(index, row, col);
						snakeList.add(snake);
					}
				}
			}
		}
		
		// Checks if every snake is valid.
		for (Snake checkSnake : snakeList)
		{
			boolean isSnakeValid = checkSnake.isValid();
			if (isSnakeValid == false)
			{
				throw new SnakeLayoutException("Snake " + checkSnake.getId() + " is not valid.");
			}
		}
		
		return snakeList;
	}

	/**
	 * Reads a the given file and creates a string array from each block of text
	 * separated by whitespace. The string arrays are returned in an ArrayList.
	 * Despite the name of this method, it does NO checking for whether a given
	 * block of text actually represents a descriptor for the game. The file is
	 * assumed to end with a blank line.
	 * 
	 * @param filename name of the file to read
	 * @return ArrayList of string arrays, one for each block of text
	 * @throws FileNotFoundException if the named file cannot be opened
	 */
	public static ArrayList<String[]> createDescriptorsFromFile(String filename) throws FileNotFoundException
	{
		// File object from the parameter.
		File file = new File(filename);

		// Scanner object with file as input stream.
		Scanner input = new Scanner(file);

		// ArrayList for descriptor arrays.
		ArrayList<String[]> descriptors = new ArrayList<>();

		// Temporal ArrayList to append lines of text.
		ArrayList<String> tempBlocks = new ArrayList<>();

		// Adds lines to the temporal ArrayList.
		while (input.hasNextLine()) 
		{
			String line = input.nextLine();

			if (line == "") 
			{
				// Checks the size of the temporal arraylist for String array.
				int size = tempBlocks.size();
				String[] block = new String[size];

				// Transfers the strings from the arraylist to the string array.
				for (int index = 0; index < block.length; ++index) 
				{
					block[index] = tempBlocks.get(index);
				}

				// Adds block to the descriptor arraylist.
				if (size != 0) 
				{
					descriptors.add(block);
				}
				tempBlocks.clear();
			} 
			else 
			{
				// Adds to the temporal arraylist.
				tempBlocks.add(line);
			}
		}

		input.close();
		return descriptors;
	}
}
