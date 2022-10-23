package edu.iastate.cs228.hw2;

/**
 * 
 * @author Alexander Lafontaine
 *
 */

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.io.File;
import java.util.Scanner;


/**
 * 
 * This class sorts all the points in an array of 2D points to determine a reference point whose x and y 
 * coordinates are respectively the medians of the x and y coordinates of the original points. 
 * 
 * It records the employed sorting algorithm as well as the sorting time for comparison. 
 *
 */
public class PointScanner  
{
	private Point[] points; 
	
	private Point medianCoordinatePoint;  // point whose x and y coordinates are respectively the medians of 
	                                      // the x coordinates and y coordinates of those points in the array points[].
	private Algorithm sortingAlgorithm;    
	
		
	protected long scanTime; 	       // execution time in nanoseconds. 
	
	/**
	 * This constructor accepts an array of points and one of the four sorting algorithms as input. Copy 
	 * the points into the array points[].
	 * 
	 * @param  pts  input array of points 
	 * @throws IllegalArgumentException if pts == null or pts.length == 0.
	 */
	public PointScanner(Point[] pts, Algorithm algo) throws IllegalArgumentException
	{
		try
		{
			if (pts == null || pts.length == 0)
			{
				throw new IllegalArgumentException();
			}
			points = pts;
			sortingAlgorithm = algo;
		}
		catch (IllegalArgumentException e)
		{
			System.out.println("Array cannot be null or length 0");
		}
		
		
	}

	
	/**
	 * This constructor reads points from a file. 
	 * 
	 * @param  inputFileName
	 * @throws FileNotFoundException 
	 * @throws InputMismatchException   if the input file contains an odd number of integers
	 */
	protected PointScanner(String inputFileName, Algorithm algo) throws FileNotFoundException, InputMismatchException
	{
		sortingAlgorithm = algo;
		
		Scanner file = null;
		
		// Checks that that the file exist.
		try
		{
			File f = new File(inputFileName);
			file = new Scanner(f);
			
			// Counts the amount of integers for array.
			Scanner lengthCounter = new Scanner(f);
			int length = 0;
			while (lengthCounter.hasNextInt())
			{
				lengthCounter.nextInt();
				++length;
			}
			lengthCounter.close();
			if (length % 2 != 0)
			{
				throw new InputMismatchException();
			}
			
			
			// Adds to the array.
			points = new Point[length / 2];
			for (int i = 0; file.hasNextInt(); ++i)
			{
				int x = file.nextInt();
				int y = file.nextInt();
				
				points[i] = new Point(x, y);
			}
		}
		catch (FileNotFoundException e)
		{
			System.out.println("File not found.");
		}
		catch (InputMismatchException e2)
		{
			System.out.println("File contains an odd amount of integers.");
		}
		finally
		{
			file.close();
		}
	}

	
	/**
	 * Carry out two rounds of sorting using the algorithm designated by sortingAlgorithm as follows:  
	 *    
	 *     a) Sort points[] by the x-coordinate to get the median x-coordinate. 
	 *     b) Sort points[] again by the y-coordinate to get the median y-coordinate.
	 *     c) Construct medianCoordinatePoint using the obtained median x- and y-coordinates.     
	 *  
	 * Based on the value of sortingAlgorithm, create an object of SelectionSorter, InsertionSorter, MergeSorter,
	 * or QuickSorter to carry out sorting.       
	 * @param algo
	 * @return
	 */
	public void scan()
	{
		// create an object to be referenced by aSorter according to sortingAlgorithm. for each of the two 
		// rounds of sorting, have aSorter do the following: 
		// 
		//     a) call setComparator() with an argument 0 or 1. 
		//
		//     b) call sort(). 		
		// 
		//     c) use a new Point object to store the coordinates of the medianCoordinatePoint
		//
		//     d) set the medianCoordinatePoint reference to the object with the correct coordinates.
		//
		//     e) sum up the times spent on the two sorting rounds and set the instance variable scanTime. 
		AbstractSorter aSorter; 
		
		if (sortingAlgorithm == Algorithm.SelectionSort)
		{
			aSorter = new SelectionSorter(points);
			
			long startTime = System.nanoTime();
			// x-Sort
			aSorter.setComparator(0);
			aSorter.sort();
			int x = aSorter.getMedian().getX();
			// y-Sort
			aSorter.setComparator(1);
			aSorter.sort();
			int y = aSorter.getMedian().getY();
			// Time
			long elapsedTime = System.nanoTime();
			scanTime = elapsedTime - startTime;
			// Median initialization
			medianCoordinatePoint = new Point(x, y);
		}
		else if (sortingAlgorithm == Algorithm.InsertionSort)
		{
			aSorter = new InsertionSorter(points);
			
			long startTime = System.nanoTime();
			// x-Sort
			aSorter.setComparator(0);
			aSorter.sort();
			int x = aSorter.getMedian().getX();
			// y-Sort
			aSorter.setComparator(1);
			aSorter.sort();
			int y = aSorter.getMedian().getY();
			// Time
			long elapsedTime = System.nanoTime();
			scanTime = elapsedTime - startTime;
			// Median initialization
			medianCoordinatePoint = new Point(x, y);
		}
		else if (sortingAlgorithm == Algorithm.MergeSort)
		{
			aSorter = new MergeSorter(points);
			
			long startTime = System.nanoTime();
			// x-Sort
			aSorter.setComparator(0);
			aSorter.sort();
			int x = aSorter.getMedian().getX();
			// y-Sort
			aSorter.setComparator(1);
			aSorter.sort();
			int y = aSorter.getMedian().getY();
			// Time
			long elapsedTime = System.nanoTime();
			scanTime = elapsedTime - startTime;
			// Median initialization
			medianCoordinatePoint = new Point(x, y);
		}
		else if (sortingAlgorithm == Algorithm.QuickSort)
		{
			aSorter = new QuickSorter(points);
			
			long startTime = System.nanoTime();
			aSorter.sort();
			// x-Sort
			aSorter.setComparator(0);
			aSorter.sort();
			int x = aSorter.getMedian().getX();
			// y-Sort
			aSorter.setComparator(1);
			aSorter.sort();
			int y = aSorter.getMedian().getY();
			// Time
			long elapsedTime = System.nanoTime();
			scanTime = elapsedTime - startTime;
			// Median initialization
			medianCoordinatePoint = new Point(x, y);
		}
		
		try 
		{
			writeMCPToFile();
		} 
		catch (FileNotFoundException e) 
		{
			
		}

	}
	
	
	/**
	 * Outputs performance statistics in the format: 
	 * 
	 * <sorting algorithm> <size>  <time>
	 * 
	 * For instance, 
	 * 
	 * selection sort   1000	  9200867
	 * 
	 * Use the spacing in the sample run in Section 2 of the project description. 
	 */
	public String stats()
	{
		String stat = "";
		if (sortingAlgorithm == Algorithm.SelectionSort)
		{
			stat = "SelectionSort " + points.length + "  " + scanTime;
		}
		else if (sortingAlgorithm == Algorithm.InsertionSort)
		{
			stat = "InsertionSort " + points.length + "  " + scanTime;
		}
		else if (sortingAlgorithm == Algorithm.MergeSort)
		{
			stat = "MergeSort     " + points.length + "  " + scanTime;
		}
		else if (sortingAlgorithm == Algorithm.QuickSort)
		{
			stat = "QuickSort     " + points.length + "  " + scanTime;
		}
		return stat;
	}
	
	
	/**
	 * Write MCP after a call to scan(),  in the format "MCP: (x, y)"   The x and y coordinates of the point are displayed on the same line with exactly one blank space 
	 * in between. 
	 */
	@Override
	public String toString()
	{
		return "MCP: (" + medianCoordinatePoint.getX() + ", " + medianCoordinatePoint.getY() + ")"; 
	}

	
	/**
	 *  
	 * This method, called after scanning, writes point data into a file by outputFileName. The format 
	 * of data in the file is the same as printed out from toString().  The file can help you verify 
	 * the full correctness of a sorting result and debug the underlying algorithm. 
	 * 
	 * @throws FileNotFoundException
	 */
	public void writeMCPToFile() throws FileNotFoundException
	{
		PrintWriter writer = null;
		
		try 
		{
			writer = new PrintWriter("MCP.txt");
			writer.write(toString());
			
		}
		catch (FileNotFoundException e)
		{
			
		}
		finally
		{
			writer.close();
		}
		
	}	

	

		
}
