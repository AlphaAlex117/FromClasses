package lab6;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class textTest2
{
	public static void main(String[] args) throws FileNotFoundException
	  {
	    Scanner in = new Scanner(System.in);
	    File outFile = new File("mydocument.txt");
	    PrintWriter out = new PrintWriter(outFile);

	    // Echo keyboard input out to the file.
	    while (in.hasNextLine())
	    {
	      String line = in.nextLine();
	      out.println(line);
	    }
	    
	    System.out.println("Done");
	    in.close();
	    out.close(); // Important: don't forget to close!
	  }
}
