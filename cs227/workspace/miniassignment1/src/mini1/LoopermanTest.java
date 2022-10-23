package mini1;

public class LoopermanTest
{

	public static void main(String[] args)
	{
		String test1 = Looperman.doubleAllVowels("Aardvark");
		System.out.println(test1);
		System.out.println("Expected: AAaardvaark");

		int test2 = Looperman.collatzCounter(6);
		System.out.println(test2);
		System.out.println("Expected: 8");
		test2 = Looperman.collatzCounter(0);
		System.out.println(test2);
		System.out.println("Expected: -1");
		test2 = Looperman.collatzCounter(-355);
		System.out.println(test2);
		System.out.println("Expected: -1");
		
		String test3 = Looperman.parseNameNumbers("Edna von Humboldt van der Scooch 10 20 30 40");
		System.out.println(test3);
		System.out.println("Expected: Edna von Humboldt van der Scooch: 25.0");
		
		boolean test4 = Looperman.differByTwoInsertions("banana", "bannanaa");
		System.out.println(test4);
		System.out.println("Expected: true");
		test4 = Looperman.differByTwoInsertions("lalalala", "lalalalala");
		System.out.println(test4);
		System.out.println("Expected: true");
		test4 = Looperman.differByTwoInsertions("aaa", "llll");
		System.out.println(test4);
		System.out.println("Expected: false");
		
		String test5 = Looperman.plusMode("aa+rdv-ark");
		System.out.println(test5);
		System.out.println("Expected: aaRDVark");
		test5 = Looperman.plusMode("++--+++");
		System.out.println(test5);
		System.out.println("Expected: ");
		
		String test6 = Looperman.doubleVowelsMaybe("beautiful");
		System.out.println(test6);
		System.out.println("Expected: beautiifuul");
		test6 = Looperman.doubleVowelsMaybe("aeinama");
		System.out.println(test6);
		System.out.println("Expected: aeinaamaa");
		
		Looperman.witchHat(10);
	}

}
