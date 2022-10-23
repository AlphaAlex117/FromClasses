package edu.iastate.cs228.hw2;

import java.io.FileNotFoundException;
import java.lang.NumberFormatException; 
import java.lang.IllegalArgumentException;
import java.util.Arrays;
import java.util.InputMismatchException;

/**
 *  
 * @author Alexander Lafontaine
 *
 */

/**
 * 
 * This class implements the mergesort algorithm.   
 *
 */

public class MergeSorter extends AbstractSorter
{
	// Other private instance variables if needed
	
	/** 
	 * Constructor takes an array of points.  It invokes the superclass constructor, and also 
	 * set the instance variables algorithm in the superclass.
	 *  
	 * @param pts   input array of integers
	 */
	public MergeSorter(Point[] pts) 
	{
		super(pts);
		super.algorithm = "merge sort";
	}


	/**
	 * Perform mergesort on the array points[] of the parent class AbstractSorter. 
	 * 
	 */
	@Override 
	protected void sort()
	{
		mergeSortRec(points);
	}

	
	/**
	 * This is a recursive method that carries out mergesort on an array pts[] of points. One 
	 * way is to make copies of the two halves of pts[], recursively call mergeSort on them, 
	 * and merge the two sorted subarrays into pts[].   
	 * 
	 * @param pts	point array 
	 */
	private void mergeSortRec(Point[] pts)
	{
		if (pts.length <= 1)
		{
			return;
		}
		else
		{
			Point[] left = Arrays.copyOfRange(pts, 0, pts.length / 2);
			mergeSortRec(left);
			Point[] right = Arrays.copyOfRange(pts, (pts.length / 2), pts.length);
			mergeSortRec(right);
			
			points = merge(left, right);
			getPoints(pts);
		}
	}

	
	// Other private methods if needed ...
	private Point[] merge(Point[] A, Point[] B)
	{
		int p = A.length;
		int q = B.length;
		Point[] D = new Point[p + q];
		
		int indexI = 0;
		int indexJ = 0;
		
		while (indexI < p && indexJ < q)
		{
			if (A[indexI].compareTo(B[indexJ]) <= 0)
			{
				D[indexI + indexJ] = A[indexI];
				indexI++;
			}
			else
			{
				D[indexI + indexJ] = B[indexJ];
				indexJ++;
			}
		}
		
		if (indexI >= p)
		{
			while (indexJ < q)
			{
				D[indexI + indexJ] = B[indexJ];
				indexJ++;
			}
		}
		else
		{
			while (indexI < p)
			{
				D[indexI + indexJ] = A[indexI];
				indexI++;
			}
		}
		
		return D;
	}

}
