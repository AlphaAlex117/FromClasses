package exam2;

import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

public class Contact
{
	private String name = "";
	private String number = "";
	
	public Contact(String givenName, String givenNumber)
	{
		name = givenName;
		number = givenNumber;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getPhoneNumber()
	{
		return number;
	}
}

public class ContactDirectory
{
	private ArrayList<Contact> list = new ArrayList<Contact>();
	
	public ContactDirectory()
	{
		
	}
	
	public void addContact(Contact c)
	{
		list.add(c);
	}
	
	public void addFromFile(String filename) throws FileNotFoundException
	{
		File f = new File(filename);
		Scanner scan = new Scanner(f);
		while (scan.hasNextLine())
		{
			String line = scan.nextLine();
			Scanner separator = new Scanner(line);
			String name = separator.next();
			String phone = separator.next();
			
			Contact c = new Contact(name, phone);
			list.add(c);
		}
	}
	
	public String lookUp(String name)
	{
		for (Contact c : list)
		{
			if (c.getName() == name)
			{
				return c.getPhoneNumber();
			}
		}
		return null;
	}
}
