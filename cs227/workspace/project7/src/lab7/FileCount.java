package lab7;

import java.io.File;

public class FileCount
{

	public static void main(String[] args)
	{
		File rootDirectory = new File(".");

	    countAllFiles(rootDirectory);
	}

	public static int countAllFiles(File f)
	{
		if (!f.isDirectory())
	    {
	      // Base case: f is a file, so just print its name
	      return 1;
	    }
	    else
	    {
	      // Recursive case: f is a directory, so go through the 
	      // files and directories it contains, and recursively call
	      // this method on each one
	    	int count = 0;
	    	
	    	File[] files = f.listFiles();
	    	for (int i = 0; i < files.length; ++i)
	    	{
	    		count = count + countAllFiles(files[i]);	
	    	}
	    	System.out.println("+ " + f.getName() + " | " + count);
	    	return count;
	    }
	}
}
