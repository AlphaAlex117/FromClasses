package exam2;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class questionTwo
{
	public static void main(String[] args)
	{
		System.out.print("Enter filename: ");
		Scanner input = new Scanner(System.in);
		String filename = input.nextLine();
		File file = new File(filename);
		Scanner javaFile = new Scanner(file);
		
		ArrayList<String> undocumentedCode = new ArrayList<String>();
		while (javaFile.hasNextLine())
		{
			String line = javaFile.nextLine();
			int index = line.indexOf("//");
			
			if (index == -1)
			{
				undocumentedCode.add(line);
			}
			else
			{
				undocumentedCode.add(line.substring(0, index));
			}
		}
		
		String outputFileName = filename.substring(0, filename.length() - 5) + ".out";
		PrinterWriter output = new PrinterWriter(new File(outputFileName));
		
		for (String line : undocumentedCode)
		{
			output.println(line);
		}
	}
}
