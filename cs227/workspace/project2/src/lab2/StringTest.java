package lab2;

public class StringTest {

	public static void main(String[] args) {
		String message = "Hello, world!";
		System.out.println(message);
		
		int theLength = message.length();
		System.out.println(theLength);
		
		char theChar = message.charAt(0);
		System.out.println(theChar);

		theChar = message.charAt(12);
		System.out.println(theChar);
		
		String theSubstring = message.substring(0, 5);
		System.out.println(theSubstring);
		

	}

}
