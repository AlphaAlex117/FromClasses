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
 * This class implements selection sort.   
 *
 */

public class SelectionSorter extends AbstractSorter
{
	// Other private instance variables if you need ... 
	
	/**
	 * Constructor takes an array of points.  It invokes the superclass constructor, and also 
	 * set the instance variables algorithm in the superclass.
	 *  
	 * @param pts  
	 */
	public SelectionSorter(Point[] pts)  
	{
		super(pts);
		super.algorithm = "selection sort";
	}	

	
	/** 
	 * Apply selection sort on the array points[] of the parent class AbstractSorter.  
	 * 
	 */
	@Override 
	protected void sort()
	{
		for (int indexI = 0; indexI < points.length; ++indexI)
		{
			int minIndex = indexI;
			for (int indexJ = indexI+1; indexJ < points.length; ++indexJ)
			{
				if (points[indexJ].compareTo(points[minIndex]) == -1)
				{
					minIndex = indexJ;
				}
			}
			swap(indexI, minIndex);
		}
	}	
}
