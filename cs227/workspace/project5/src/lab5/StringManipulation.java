package lab5;

public class StringManipulation
{
	public static String findInitials(String name)
	{
		String initials = name.charAt(0) + "";
		
		for (int i = 0; i <= name.length() - 1; ++i)
		{
			if (name.charAt(i) == ' ')
			{
				initials = initials + name.charAt(i + 1);
			}
		}
		
		return initials;
	}
	
	public static int findIndex(String line)
	{
		char ch = ' ';
		for (int index = 0; index <= line.length() - 1; ++index)
		{
			ch = line.charAt(index);
			if ("aeiouAEIOU".indexOf(ch) >= 0)
			{
				return index;
			}
		}
		
		return -1;
	}
}
