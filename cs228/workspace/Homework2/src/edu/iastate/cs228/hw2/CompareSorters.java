package edu.iastate.cs228.hw2;

/**
 *  
 * @author Alexander Lafontaine
 *
 */

/**
 * 
 * This class executes four sorting algorithms: selection sort, insertion sort, mergesort, and
 * quicksort, over randomly generated integers as well integers from a file input. It compares the 
 * execution times of these algorithms on the same input. 
 *
 */

import java.io.FileNotFoundException;
import java.util.Scanner; 
import java.util.Random; 


public class CompareSorters 
{
	/**
	 * Repeatedly take integer sequences either randomly generated or read from files. 
	 * Use them as coordinates to construct points.  Scan these points with respect to their 
	 * median coordinate point four times, each time using a different sorting algorithm.  
	 * 
	 * @param args
	 **/
	public static void main(String[] args) throws FileNotFoundException
	{		
		
		// For each input of points, do the following. 
		// 
		//     a) Initialize the array scanners[].  
		//
		//     b) Iterate through the array scanners[], and have every scanner call the scan() 
		//        method in the PointScanner class.  
		//
		//     c) After all four scans are done for the input, print out the statistics table from
		//		  section 2.
		//
		// A sample scenario is given in Section 2 of the project description. 
		
		PointScanner[] scanners = new PointScanner[4]; 
		
		System.out.println("Performances of Four Sorting Algorithms in Point Scanning");
		System.out.println();
		System.out.println("keys:  1 (random integers)  2 (file input)  3 (exit)");
		
		
		Scanner input = new Scanner(System.in);
		for (int i = 1; ; ++i)
		{
			System.out.print("Trial " + i + ": ");
			int selection = input.nextInt();
			if (selection == 1)
			{
				System.out.print("Enter number of random points: ");
				int amount = input.nextInt();
				Random r = new Random();
				Point[] arr = CompareSorters.generateRandomPoints(amount, r);
				scanners[0] = new PointScanner(arr, Algorithm.SelectionSort);
				scanners[1] = new PointScanner(arr, Algorithm.InsertionSort);
				scanners[2] = new PointScanner(arr, Algorithm.MergeSort);
				scanners[3] = new PointScanner(arr, Algorithm.QuickSort);
			}
			else if (selection == 2)
			{
				System.out.println("Points from a file");
				System.out.print("File name: ");
				String filename = input.next();
				scanners[0] = new PointScanner(filename, Algorithm.SelectionSort);
				scanners[1] = new PointScanner(filename, Algorithm.InsertionSort);
				scanners[2] = new PointScanner(filename, Algorithm.MergeSort);
				scanners[3] = new PointScanner(filename, Algorithm.QuickSort);
			}
			else
			{
				break;
			}
			
			System.out.println();
			System.out.println("algorithm	size	time (ns)");
			System.out.println("-----------------------------------");
			for (PointScanner p : scanners)
			{
				p.scan();
				System.out.println(p.stats());
			}
			System.out.println("-----------------------------------");
			System.out.println();
		}
		input.close();
	}
	
	
	/**
	 * This method generates a given number of random points.
	 * The coordinates of these points are pseudo-random numbers within the range 
	 * [-50,50] × [-50,50]. Please refer to Section 3 on how such points can be generated.
	 * 
	 * Ought to be private. Made public for testing. 
	 * 
	 * @param numPts  	number of points
	 * @param rand      Random object to allow seeding of the random number generator
	 * @throws IllegalArgumentException if numPts < 1
	 */
	private static Point[] generateRandomPoints(int numPts, Random rand) throws IllegalArgumentException
	{ 
		Point[] randomized = new Point[numPts];
		for (int i = 0; i < randomized.length; ++i)
		{
			int x = rand.nextInt(100 + 1) - 50;
			int y = rand.nextInt(100 + 1) - 50;
			randomized[i] = new Point(x, y);
		}
		
		return randomized; 
	}
	
}
