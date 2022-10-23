package edu.iastate.cs228.hw1;

/**
 *  
 * @author Alexander Lafontaine
 *
 */

import java.io.File; 
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner; 
import java.util.Random;

/**
 * 
 * The plain is represented as a square grid of size width x width. 
 *
 */
public class Plain 
{
	private int width; // grid size: width X width 
	
	public Living[][] grid; 
	
	/**
	 *  Default constructor reads from a file 
	 */
	public Plain(String inputFileName) throws FileNotFoundException
	{		
		
		// 3) Fills in the grid according to the input file. 
		// 
		// Be sure to close the input file when you are done. 
		
		
		// Opens File
		File file = new File(inputFileName);
		
		int widthCount = 0;
		Scanner scan = null;
		
		try 
		{
			// Opens First Scanner
			scan = new Scanner(file);

			// Counts the width to create grid
			while (scan.hasNextLine())
			{
				scan.nextLine();
				++widthCount;
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			scan.close();
		}
		
		// Creates a new grid
		width = widthCount;
		grid = new Living[width][width];
		
		// Opens the file again to assign to the grid.
		scan = new Scanner(file);
		
		for (int i = 0; scan.hasNextLine() && i < width; ++i)
		{
			
			for (int j = 0; scan.hasNext() && j < width; ++j)
			{
				String livingThing = scan.next();
				char livingState = livingThing.charAt(0);
				if (livingState == 'B')
				{
					int age = Character.getNumericValue(livingThing.charAt(1));
					grid[i][j] = new Badger(this, i, j, age);
				}
				else if (livingState == 'F')
				{
					int age = Character.getNumericValue(livingThing.charAt(1));
					grid[i][j] = new Fox(this, i, j, age);
				}
				else if (livingState == 'R')
				{
					int age = Character.getNumericValue(livingThing.charAt(1));
					grid[i][j] = new Rabbit(this, i, j, age);
				}
				else if (livingState == 'G')
				{
					grid[i][j] = new Grass(this, i, j);
				}
				else if (livingState == 'E')
				{
					grid[i][j] = new Empty(this, i, j);
				}
			}
			scan.nextLine();
		}
		scan.close();
	}
	
	/**
	 * Constructor that builds a w x w grid without initializing it. 
	 * @param width  the grid 
	 */
	public Plain(int w)
	{
		width = w;
		grid = new Living[width][width];
	}
	
	
	public int getWidth()
	{  
		return width;
	}
	
	/**
	 * Initialize the plain by randomly assigning to every square of the grid  
	 * one of BADGER, FOX, RABBIT, GRASS, or EMPTY.  
	 * 
	 * Every animal starts at age 0.
	 */
	public void randomInit()
	{
		Random generator = new Random(); 
		 
		for (int i = 0; i < grid.length; ++i)
		{
			for (int j = 0; j < grid[0].length; ++j)
			{
				// Get random number
				int randomNumber = generator.nextInt(Living.NUM_LIFE_FORMS);
				// Compare with each variable and assign a Living object to the grid.
				if (randomNumber == Living.BADGER)
				{
					grid[i][j] = new Badger(this, i, j, 0);
				}
				else if (randomNumber == Living.EMPTY)
				{
					grid[i][j] = new Empty(this, i, j);
				}
				else if (randomNumber == Living.FOX)
				{
					grid[i][j] = new Fox(this, i, j, 0);
				}
				else if (randomNumber == Living.GRASS)
				{
					grid[i][j] = new Grass(this, i, j);
				}
				else if (randomNumber == Living.RABBIT)
				{
					grid[i][j] = new Rabbit(this, i, j, 0);
				}
			}
		}
	}
	
	
	/**
	 * Output the plain grid. For each square, output the first letter of the living form
	 * occupying the square. If the living form is an animal, then output the age of the animal 
	 * followed by a blank space; otherwise, output two blanks.  
	 */
	public String toString()
	{
		String currentPlain = "";
		
		for (int i = 0; i < width; ++i)
		{
			for (int j = 0; j < width; ++j)
			{
				Living livingThing = grid[i][j];
				
				if (livingThing.who() == State.BADGER)
				{
					currentPlain += "B" + ((Badger) livingThing).myAge() + " ";
				}
				else if (livingThing.who() == State.EMPTY)
				{
					currentPlain += "E" + "  ";
				}
				else if (livingThing.who() == State.FOX)
				{
					currentPlain += "F" + ((Fox) livingThing).myAge() + " ";
				}
				else if (livingThing.who() == State.GRASS)
				{
					currentPlain += "G" + "  ";
				}
				else if (livingThing.who() == State.RABBIT)
				{
					currentPlain += "R" + ((Rabbit) livingThing).myAge() + " ";
				}
			}
			currentPlain += "\n";
		}
		
		return currentPlain; 
	}
	

	/**
	 * Write the plain grid to an output file.  Also useful for saving a randomly 
	 * generated plain for debugging purpose. 
	 * @throws FileNotFoundException
	 */
	public void write(String outputFileName) throws FileNotFoundException
	{
		// TODO 
		// 
		// 1. Open the file. 
		// 
		// 2. Write to the file. The five life forms are represented by characters 
		//    B, E, F, G, R. Leave one blank space in between. Examples are given in
		//    the project description. 
		// 
		// 3. Close the file. 
		PrintWriter print = null;
		
		try
		{
			print = new PrintWriter(outputFileName);
			
			print.write(this.toString());
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			print.flush();
			print.close();
		}
		
		
		
	}			
}
