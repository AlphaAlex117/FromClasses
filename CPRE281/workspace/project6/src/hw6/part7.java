package hw6;

import java.util.Scanner;

/*
 * @author Alexander Lafontaine
 */
public class part7 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		String binaryNum = input.next();
		input.close();
		
		int decimalNum = 0;
		
		for (int i = 0; i <= binaryNum.length() - 1; ++i)
		{	
			if (binaryNum.charAt(i) == '1')
			{
				decimalNum = decimalNum + (int)Math.pow(2, (binaryNum.length() - 1) - i);
			}
		}
		
		System.out.println(decimalNum);
	}

}
