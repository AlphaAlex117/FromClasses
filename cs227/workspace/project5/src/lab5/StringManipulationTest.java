package lab5;

public class StringManipulationTest
{

	public static void main(String[] args)
	{
		String test1 = StringManipulation.findInitials("Edna del Humboldt von der Schooch");

		System.out.println(test1);
		
		int test2 = StringManipulation.findIndex("gggggggg");
		
		System.out.println(test2);
	}

}
