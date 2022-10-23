package lab6;
import java.awt.Point;


import plotter.Plotter;
import plotter.Polyline;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class RunningPolylines
{
	private static Polyline parseOneLine(String line)
	{
		Scanner input = new Scanner(line);
		int width = 1;
		if (input.hasNextInt() == true)
		{
			width = input.nextInt();
		}
		String color = input.next();
		Polyline pl = new Polyline(color, width);
		
		while (input.hasNextInt() == true)
		{
			int x = input.nextInt();
			int y = input.nextInt();
			pl.addPoint(new Point(x, y));
		}
		input.close();
		return pl;
	}
	
	private static ArrayList<Polyline> readFile(String filename) throws FileNotFoundException
	{
		ArrayList<Polyline> polylines = new ArrayList<>();
		  
		  File file = new File(filename);    
		  Scanner scanner = new Scanner(file);
		  while (scanner.hasNextLine())
		  {
		     String line = scanner.nextLine();
		     if (line != "")
		     {
		    	 if (line.charAt(0) != '#')
			     {
			    	 polylines.add(parseOneLine(line));
			     }
		     }
		  }
		  scanner.close();

		  return polylines;
	}
	
	public static void main(String[] args) throws FileNotFoundException
	{
		ArrayList<Polyline> list = readFile("hello.txt");
	    Plotter plotter = new Plotter();

	    for (Polyline p : list)
	    {
	      plotter.plot(p);
	    }
	}

}
