package edu.iastate.cs228.hw1;

import java.io.FileNotFoundException;
import java.util.Scanner; 

/**
 *  
 * @author Alexander Lafontaine
 *
 */

/**
 * 
 * The Wildlife class performs a simulation of a grid plain with
 * squares inhabited by badgers, foxes, rabbits, grass, or none. 
 *
 */
public class Wildlife 
{
	/**
	 * Update the new plain from the old plain in one cycle. 
	 * @param pOld  old plain
	 * @param pNew  new plain 
	 */
	public static void updatePlain(Plain pOld, Plain pNew)
	{	
		for (int i = 0; i < pOld.getWidth(); ++i)
		{
			for (int j = 0; j < pOld.getWidth(); ++j)
			{
				pNew.grid[i][j] = pOld.grid[i][j].next(pNew);
			}
		}
	}
	
	/**
	 * Repeatedly generates plains either randomly or from reading files. 
	 * Over each plain, carries out an input number of cycles of evolution. 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException
	{	
		// Generate wildlife simulations repeatedly like shown in the 
		// sample run in the project description. 
		// 
		// 1. Enter 1 to generate a random plain, 2 to read a plain from an input
		//    file, and 3 to end the simulation. (An input file always ends with 
		//    the suffix .txt.) 
		
		System.out.println("Simulation of Wildlife of the Plain");
		System.out.println("keys: 1 (random plain)  2 (file input)  3 (exit)");
		System.out.println();
		Scanner input = new Scanner(System.in);
		
		for (int trial = 1; ; ++trial)
		{
			System.out.print("Trial " + trial + ": ");
			int selection = input.nextInt();
			if (selection == 1)
			{
				System.out.println("Random plain");
				System.out.print("Enter grid width: ");
				int width = 0;
				int cycles = 0;
				while (width < 1)
				{
					width = input.nextInt();
				}
				System.out.print("Enter the number of cycles: ");
				while (cycles < 1)
				{
					cycles = input.nextInt();
				}
				System.out.println();
				
				Plain even = new Plain(width);
				even.randomInit();
				Plain odd = new Plain(width);
				System.out.println("Initial plain:");
				System.out.println();
				System.out.println(even.toString());
				
				int index = 0;
				for (index = 0; index < cycles; ++index)
				{
					if (index % 2 == 0)
					{
						updatePlain(even, odd);
					}
					else
					{
						updatePlain(odd, even);
					}
				}
				System.out.println("Final plain:");
				System.out.println();
				if (index % 2 == 0)
				{
					System.out.println(even.toString());
				}
				else
				{
					System.out.println(odd.toString());
				}
			}
			else if (selection == 2)
			{
				System.out.println("Plain input from a file");
				System.out.print("File name: ");
				String filename = input.next();
				int cycles = 0;
				System.out.print("Enter the number of cycles: ");
				while (cycles < 1)
				{
					cycles = input.nextInt();
				}
				System.out.println();
				
				Plain even = new Plain(filename);
				Plain odd = new Plain(even.getWidth());
				System.out.println("Initial plain:");
				System.out.println();
				System.out.println(even.toString());
				
				int index = 0;
				for (index = 0; index < cycles; ++index)
				{
					if (index % 2 == 0)
					{
						updatePlain(even, odd);
					}
					else
					{
						updatePlain(odd, even);
					}
				}
				System.out.println("Final plain:");
				System.out.println();
				if (index % 2 == 0)
				{
					System.out.println(even.toString());
				}
				else
				{
					System.out.println(odd.toString());
				}
			}
			else
			{
				break;
			}
		}
		input.close();
	}
}
