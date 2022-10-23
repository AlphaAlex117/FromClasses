package hw2.tests;
import org.junit.Test;

import edu.iastate.cs228.hw2.*;

import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class SortersTest {
	
	Point[] arr = new Point[5];
	
	@Before
	public void SorterSetUp()
	{
		arr[0] = new Point(2, 3);
		arr[1] = new Point(4, -5);
		arr[2] = new Point(2, 3);
		arr[3] = new Point(-7, 0);
		arr[4] = new Point(-2, 10);
		Point.setXorY(true);
	}
	
	@Test
	public void SelectionSort()
	{
		SelectionSorter sorter = new SelectionSorter(arr);
		sorter.sort();
		sorter.getPoints(arr);
		System.out.println("Selection: ");
	}
	
	@Test
	public void InsertionSort()
	{
		InsertionSorter sorter = new InsertionSorter(arr);
		sorter.sort();
		sorter.getPoints(arr);
		System.out.println("Insertion: ");
	}
	
	@Test
	public void MergeSort()
	{
		MergeSorter sorter = new MergeSorter(arr);
		sorter.sort();
		sorter.getPoints(arr);
		System.out.println("Merge: ");
	}
	
	@Test
	public void QuickSort()
	{
		QuickSorter sorter = new QuickSorter(arr);
		sorter.sort();
		sorter.getPoints(arr);
		System.out.println("Quick: ");
	}
	
	@After
	public void PrintAll()
	{
		for (Point p : arr)
		{
			System.out.println(p.toString());
		}
		System.out.println();
	}
}
