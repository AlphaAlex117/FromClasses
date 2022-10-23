package lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LineNumberer
{
	private static int printNumberOfWords(String line)
	  {   
	    // construct a temporary scanner, just to read data from this line
	    Scanner temp = new Scanner(line);
	    
	    // Word Count
	    int totalWordsLine = 0;
	    while (temp.hasNext())
	    {
	      temp.next();
	      totalWordsLine += 1;
	    }
	    temp.close();
	    return totalWordsLine;
	  }
	
	public static void main(String[] args) throws FileNotFoundException
	  {
	    File file = new File("..\\project5\\src\\lab5\\SimpleLoops.java");
	    System.out.println(file.exists());          // true if the file exists
	    System.out.println(file.getName());         // name of the file 
	    System.out.println(file.getAbsolutePath()); // absolute path to the file
	    System.out.println(file.length());          // size of the file
	    
	    Scanner scanner = new Scanner(file);
	    int lineCount = 1;

	    while (scanner.hasNextLine())
	    {
	      String line = scanner.nextLine();
	      System.out.print(lineCount + " ");
	      System.out.print(line);
	      System.out.print("  ||| Number of Words: " + printNumberOfWords(line));
	      System.out.println();
	      lineCount += 1;
	    }
	    scanner.close();
	  }
}
