package edu.iastate.cs228.hw2;

import java.io.FileNotFoundException;
import java.lang.NumberFormatException; 
import java.lang.IllegalArgumentException; 
import java.util.InputMismatchException;


/**
 *  
 * @author Alexander Lafontaine
 *
 */

/**
 * 
 * This class implements insertion sort.   
 *
 */

public class InsertionSorter extends AbstractSorter 
{
	// Other private instance variables if you need ... 
	
	/**
	 * Constructor takes an array of points.  It invokes the superclass constructor, and also 
	 * set the instance variables algorithm in the superclass.
	 * 
	 * @param pts  
	 */
	public InsertionSorter(Point[] pts) 
	{
		super(pts);
		super.algorithm = "insertion sort";
	}	

	
	/** 
	 * Perform insertion sort on the array points[] of the parent class AbstractSorter.  
	 */
	@Override 
	protected void sort()
	{
		for (int indexI = 1; indexI < points.length; ++indexI)
		{
			Point temp = points[indexI];
			int indexJ = indexI-1;
			while (indexJ > -1 && points[indexJ].compareTo(temp) == 1)
			{
				points[indexJ+1] = points[indexJ];
				--indexJ;
			}
			points[indexJ+1] = temp;
		}
	}		
}
