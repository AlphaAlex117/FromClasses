package exam2;

import java.util.Scanner;

public class questionFive
{

	public static void main(String[] args)
	{
		getPassword();
	}
	
	public static String getPassword()
	{
		Scanner input = new Scanner(System.in);
		String firstPass = "";
		String secondPass = ".";
		while (!firstPass.equals(secondPass))
		{
			System.out.print("Type Password: ");
			firstPass = input.next();
			System.out.print("ReType Password: ");
			secondPass = input.next();
		}
		input.close();
		return firstPass;
	}

}
