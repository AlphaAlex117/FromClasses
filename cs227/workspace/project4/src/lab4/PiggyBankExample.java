package lab4;

public class PiggyBankExample
{

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    PiggyBank piggy = new PiggyBank(5);
    piggy.addCoins(1);
    piggy.addCoins(1);
    System.out.println("Should contain 2 coins: " + piggy.getNumCoins());
    System.out.println("Should be false (not smashed): " + piggy.isSmashed());
    piggy.addCoins(1);
    System.out.println("Should now contain 3 coins: " + piggy.getNumCoins());
  }

}

/* 
 * The errors I found were a an assign symbol in the if-statement instead of equal 
 * and a missing variable for updating the coin instance variable.
 */