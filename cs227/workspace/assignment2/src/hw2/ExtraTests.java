package hw2;

public class ExtraTests
{

	public static void main(String[] args)
	{
		Corkball game = new Corkball(5);
		
		game.hit(250);
		game.hit(150);
		game.hit(200);
		System.out.println(game);
		game.strike(true);
		game.strike(true);
		game.strike(true);
		game.hit(250);
		System.out.println(game);

	}

}
