package edu.iastate.cs228.hw4;


import java.io.FileNotFoundException;
import java.util.Scanner; 

/**
 *  
 * @author Alexander Lafontaine
 *
 */

/**
 * 
 * The Transactions class simulates video transactions at a video store. 
 *
 */
public class Transactions 
{
	
	/**
	 * The main method generates a simulation of rental and return activities.  
	 *  
	 * @param args
	 * @throws FileNotFoundException
	 * @throws AllCopiesRentedOutException 
	 * @throws FilmNotInInventoryException 
	 * @throws IllegalArgumentException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IllegalArgumentException, FilmNotInInventoryException, AllCopiesRentedOutException
	{	 
		// 1. Construct a VideoStore object.
		// 2. Simulate transactions as in the example given in Section 4 of the 
		//    the project description. 
		VideoStore store = new VideoStore("videoList1.txt");
		boolean storeSwitch = true;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Transactions at a Video Store");
		System.out.println("keys: 1 (rent)     2 (bulk rent)\n"
						 + "      3 (return)   4 (bulk return)\n"
						 + "      5 (summary)  6 (exit)");
		
		while(storeSwitch)
		{
			// Beginning
			System.out.println();
			System.out.print("Transaction: ");
			int choice = input.nextInt();
			
			/*
			 * 1) 1 for rent
			 * 2) 2 for bulk rent
			 * 3) 3 for return
			 * 4) 4 for bulk return
			 * 5) 5 summary
			 * 6) any other number for exit
			 */
			if (choice == 1)
			{
				System.out.print("Film to rent: ");
				String name = input.nextLine();
				store.videoRent(name, 1);
			}
			else if (choice == 2)
			{
				System.out.print("Video file (rent): ");
				String filename = input.next();
				store.bulkRent(filename);
			}
			else if (choice == 3)
			{
				System.out.print("Film to return: ");
				String name = input.nextLine();
				store.videoReturn(name, 1);
			}
			else if (choice == 4)
			{
				System.out.print("Video file (return): ");
				String filename = input.next();
				store.bulkReturn(filename);
			}
			else if (choice == 5)
			{
				System.out.print(store.transactionsSummary());
			}
			else
			{
				storeSwitch = false;
			}
			
		}
		input.close();
	}
}
