
package hw2;

/**
 * Model of an obscure game called "Corkball" or sometimes "Fuzzball", generally
 * played in the St Louis area.  It is vaguely similar to baseball, except that
 * it is much simpler since there are no actual bases and the runners are imaginary.
 * See the assignment pdf for further explanation.
 * 
 * @author Alexander Lafontaine
 */
public class Corkball
{
  /**
   * Number of strikes causing a player to be out.
   */
  public static final int MAX_STRIKES = 2;

  /**
   * Number of balls causing a player to walk.
   */
  public static final int MAX_BALLS = 5;

  /**
   * Number of outs before the teams switch.
   */
  public static final int MAX_OUTS = 3;

  

  /*
   * Stores the maximum amount of innings.
   */
  private int maxNumInnings = 0;
  
  /*
   * Stores the current inning number. Starts at inning 1.
   */
  private int currentInning = 1;
  
  /*
   * Stores if team top is batter.
   */
  private boolean topOfInning = true;
  
  /*
   * Stores current number of balls of current batter.
   */
  private int ballCount = 0;
  
  /*
   * Stores current number of strikes of current batter.
   */
  private int calledStrikes = 0;
  
  /*
   * Stores current number of outs of team.
   */
  private int currentOuts = 0;
  
  /*
   * Stores if the game has ended.
   */
  private boolean endOfGame = false;
  
  /*
   * Stores score of team 0.
   */
  private int team0Score = 0;
  
  /*
   * Stores score of team 1.
   */
  private int team1Score = 0;
  
  /*
   * Stores if base 1 is occupied.
   */
  private boolean base1 = false;
  
  /*
   * Stores if base 2 is occupied.
   */
  private boolean base2 = false;
  
  /*
   * Stores if base 3 is occupied.
   */
  private boolean base3 = false;
  
  
  
  /*
   * Resets the ball and strike counters.
   */
  private void changePlayer()
  {
	  ballCount = 0;
	  calledStrikes = 0;
  }

  /*
   * Changes team and resets the counters and bases.
   */
  private void changeTeam()
  {
	  ballCount = 0;
	  calledStrikes = 0;
	  currentOuts = 0;
	  base1 = false;
	  base2 = false;
	  base3 = false;
	  if (topOfInning == true)
	  {
		  topOfInning = false;
	  }
	  else
	  {
		  topOfInning = true;
		  if (currentInning == maxNumInnings)
		  {
			  endOfGame = true;
		  }
		  currentInning = currentInning + 1;
		  
	  }
  }
  
  /*
   * Takes the collected score from the previous if statement and adds it to the correct team.
   * This is a helper method.
   * @param number of points for the score
   */
  private void awardPoints(int points)
  {
	  if (topOfInning == true)
	  {
		  team0Score = team0Score + points;
	  }
	  else
	  {
		  team1Score = team1Score + points;
	  }
  }
  
  
  
  /*
   * Constructs a game of corkball with and assigns the total number of innings for the game.
   * @param total number of innings
   */
  public Corkball(int givenNumInnings)
  {
	  maxNumInnings = givenNumInnings;
  }
  
  
  
  /*
   * Counts the number of balls and if it reaches the maximum, it activates a walk.
   */
  public void ball()
  {
	  if (endOfGame == false)
	  {
		  ballCount = ballCount + 1;
		  
		  if (ballCount == MAX_BALLS)
		  {  
			  changePlayer();
			  
			  // This nested if statement checks every position before moving players.
			  // This is for a walk.
			  if (runnerOnBase(1) == true) 					// (X--)
			  {
				  if (runnerOnBase(2) == true) 				// (XX-)
				  {
					  if (runnerOnBase(3) == true) 			// (XXX)
					  {
						  awardPoints(1);
					  }
					  else									// (XXo)
					  {
						  base3 = true;
					  }
				  }
				  else 										// (Xo-)
				  {
					  if (runnerOnBase(3) == true) 			// (XoX)	
					  {
						  base2 = true;
					  }
					  else 									// (Xoo)
					  {
						  base2 = true;
					  }
				  }
			  }
			  else 											// (o--)
			  {
				  if (runnerOnBase(2) == true) 				// (oX-)
				  {
					  if (runnerOnBase(3) == true) 			// (oXX)
					  {
						  base1 = true;
					  }
					  else									// (oXo)
					  {
						  base1 = true;
					  }
				  }
				  else 										// (oo-)
				  {
					  if (runnerOnBase(3) == true) 			// (ooX)	
					  {
						  base1 = true;
					  }
					  else 									// (ooo)
					  {
						  base1 = true;
					  }
				  }
			  }
		  }
	  }
  }
  
  /*
   * Counts an out after the ball is caught.
   */
  public void caughtFly()
  {
	  // Checks if game has ended before updating anything else.
	  if (endOfGame == false)
	  {
		  changePlayer();
		  currentOuts = currentOuts + 1;
				  
		  // Checks if the amount of current outs equals the maximum allowed.
		  // It also changes the team.
		  if (currentOuts == MAX_OUTS)
		  {
			  changeTeam();
		  }
	  }
	  
  }
  
  /*
   * Checks if the game has ended.
   */
  public boolean gameEnded()
  {
	  return endOfGame;
  }
  
  /*
   * Returns the amount of balls from batter.
   */
  public int getBallCount()
  {
	  return ballCount;
  }
  
  /*
   * Returns the amount of strikes from batter.
   */
  public int getCalledStrikes()
  {
	  return calledStrikes;
  }
  
  /*
   * Returns the amount of outs from team.
   */
  public int getCurrentOuts()
  {
	  return currentOuts;
  }
  
  /*
   * Returns team0's score.
   */
  public int getTeam0Score()
  {
	  return team0Score;
  }
  
  /*
   * Returns team1's score.
   */
  public int getTeam1Score()
  {
	  return team1Score;
  }
  
  /*
   * Move players according to the type of hit and the positions of the players.
   * @param distance the ball went.
   */
  public void hit(int distance)
  {
	  // Checks if game has ended before updating anything else.
	  if (endOfGame == false)
	  {
		  changePlayer();
		  
		  if (distance < 15)
		  {
			  // It is an out, so it resets everything and update the game if necessary.
			  currentOuts = currentOuts + 1;
					  
			  // Checks if the amount of current outs equals the maximum allowed.
			  // It also changes the team.
			  if (currentOuts == MAX_OUTS)
			  {
				  changeTeam();
			  }
		  }
		  else if (distance < 150)
		  {
			  // This nested if statement checks every position before moving players.
			  // This is for the single hit.
			  if (runnerOnBase(1) == true) 					// (X--)
			  {
				  if (runnerOnBase(2) == true) 				// (XX-)
				  {
					  if (runnerOnBase(3) == true) 			// (XXX)
					  {
						  awardPoints(1);
					  }
					  else									// (XXo)
					  {
						  base3 = true;
					  }
				  }
				  else 										// (Xo-)
				  {
					  if (runnerOnBase(3) == true) 			// (XoX)	
					  {
						  base2 = true;
						  base3 = false;
						  awardPoints(1);
					  }
					  else 									// (Xoo)
					  {
						  base2 = true;
					  }
				  }
			  }
			  else 											// (o--)
			  {
				  if (runnerOnBase(2) == true) 				// (oX-)
				  {
					  if (runnerOnBase(3) == true) 			// (oXX)
					  {
						  base1 = true;
						  base2 = false;
						  awardPoints(1);
					  }
					  else									// (oXo)
					  {
						  base1 = true;
						  base2 = false;
						  base3 = true;
					  }
				  }
				  else 										// (oo-)
				  {
					  if (runnerOnBase(3) == true) 			// (ooX)	
					  {
						  base1 = true;
						  base3 = false;
						  awardPoints(1);
					  }
					  else 									// (ooo)
					  {
						  base1 = true;
					  }
				  }
			  }
		  }
		  else if (distance < 200)
		  {
			  // This nested if statement checks every position before moving players.
			  // This is for the double hit.
			  if (runnerOnBase(1) == true) 					// (X--)
			  {
				  if (runnerOnBase(2) == true) 				// (XX-)
				  {
					  if (runnerOnBase(3) == true) 			// (XXX)
					  {
						  base1 = false;
						  awardPoints(2);
					  }
					  else									// (XXo)
					  {
						  base1 = false;
						  base3 = true;
						  awardPoints(1);
					  }
				  }
				  else 										// (Xo-)
				  {
					  if (runnerOnBase(3) == true) 			// (XoX)	
					  {
						  base1 = false;
						  base2 = true;
						  awardPoints(1);
					  }
					  else 									// (Xoo)
					  {
						  base1 = false;
						  base2 = true;
						  base3 = true;
					  }
				  }
			  }
			  else 											// (o--)
			  {
				  if (runnerOnBase(2) == true) 				// (oX-)
				  {
					  if (runnerOnBase(3) == true) 			// (oXX)
					  {
						  base3 = false;
						  awardPoints(2);
					  }
					  else									// (oXo)
					  {
						  awardPoints(1);
					  }
				  }
				  else 										// (oo-)
				  {
					  if (runnerOnBase(3) == true) 			// (ooX)	
					  {
						  base2 = true;
						  base3 = false;
						  awardPoints(1);
					  }
					  else 									// (ooo)
					  {
						  base2 = true;
					  }
				  }
			  }
		  }
		  else if (distance < 250)
		  {
			  // This nested if statement checks every position before moving players.
			  // This is for the triple hit.
			  if (runnerOnBase(1) == true) 					// (X--)
			  {
				  if (runnerOnBase(2) == true) 				// (XX-)
				  {
					  if (runnerOnBase(3) == true) 			// (XXX)
					  {
						  base1 = false;
						  base2 = false;
						  awardPoints(3);
					  }
					  else									// (XXo)
					  {
						  base1 = false;
						  base2 = false;
						  base3 = true;
						  awardPoints(2);
					  }
				  }
				  else 										// (Xo-)
				  {
					  if (runnerOnBase(3) == true) 			// (XoX)	
					  {
						  base1 = false;
						  awardPoints(2);
					  }
					  else 									// (Xoo)
					  {
						  base1 = false;
						  base3 = true;
						  awardPoints(1);
					  }
				  }
			  }
			  else 											// (o--)
			  {
				  if (runnerOnBase(2) == true) 				// (oX-)
				  {
					  if (runnerOnBase(3) == true) 			// (oXX)
					  {
						  base2 = false;
						  awardPoints(2);
					  }
					  else									// (oXo)
					  {
						  base2 = false;
						  base3 = true;
						  awardPoints(1);
					  }
				  }
				  else 										// (oo-)
				  {
					  if (runnerOnBase(3) == true) 			// (ooX)	
					  {
						  awardPoints(1);
					  }
					  else 									// (ooo)
					  {
						  base3 = true;
					  }
				  }
			  }
		  }
		  else
		  {
			  // This nested if statement checks every position before moving players.
			  // This is for the home run hit.
			  if (runnerOnBase(1) == true) 					// (X--)
			  {
				  if (runnerOnBase(2) == true) 				// (XX-)
				  {
					  if (runnerOnBase(3) == true) 			// (XXX)
					  {
						  base1 = false;
						  base2 = false;
						  base3 = false;
						  awardPoints(4);
					  }
					  else									// (XXo)
					  {
						  base1 = false;
						  base2 = false;
						  awardPoints(3);
					  }
				  }
				  else 										// (Xo-)
				  {
					  if (runnerOnBase(3) == true) 			// (XoX)	
					  {
						  base1 = false;
						  base3 = false;
						  awardPoints(3);
					  }
					  else 									// (Xoo)
					  {
						  base1 = false;
						  awardPoints(2);
					  }
				  }
			  }
			  else 											// (o--)
			  {
				  if (runnerOnBase(2) == true) 				// (oX-)
				  {
					  if (runnerOnBase(3) == true) 			// (oXX)
					  {
						  base2 = false;
						  base3 = false;
						  awardPoints(3);
					  }
					  else									// (oXo)
					  {
						  base2 = false;
						  awardPoints(2);
					  }
				  }
				  else 										// (oo-)
				  {
					  if (runnerOnBase(3) == true) 			// (ooX)	
					  {
						  base3 = false;
						  awardPoints(2);
					  }
					  else 									// (ooo)
					  {
						  awardPoints(1);
					  }
				  }
			  }
		  }
	  }  
  }
  
  /*
   * Returns if top is batter.
   */
  public boolean isTopOfInning()
  {
	  return topOfInning;
  }
  
  /*
   * Checks if current base is occupied.
   * @param number of base.
   */
  public boolean runnerOnBase(int which)
  {
	  boolean baseCheck = false;
	  
	  if (which == 1)
	  {
		  baseCheck = base1;
	  }
	  else if (which == 2)
	  {
		  baseCheck = base2;
	  }
	  else if (which == 3)
	  {
		  baseCheck = base3;
	  }
	  
	  return baseCheck;
  }
  
  /*
   * Indicates a strike for a batter. If 3 outs are reached, the whole team switches.
   * If the number of innings is reached, the game ends.
   * @param true is the batter swung. False otherwise.
   */
  public void strike(boolean swung)
  {
	  // Checks if game has ended before updating anything else.
	  if (endOfGame == false)
	  {
		  // Checks if it is a strike or a called strike.
		  if (swung == true)
		  {
			  changePlayer();
			  currentOuts = currentOuts + 1;
		  }
		  else
		  {
			  calledStrikes = calledStrikes + 1;
		  }
		  
		  // Checks if the amount of called strikes equals the maximum allowed.
		  if (calledStrikes == MAX_STRIKES)
		  {
			  changePlayer();
			  currentOuts = currentOuts + 1;
		  }
		  
		  // Checks if the amount of current outs equals the maximum allowed.
		  // It also changes the team.
		  if (currentOuts == MAX_OUTS)
		  {
			  changeTeam();
		  }
	  }
	  
  }
  
  /*
   * Returns the current inning or the total plus one.
   */
  public int whichInning()
  {
	  return currentInning;
  }
  
  /**
   * Returns a three-character string representing the players on base, in the
   * order first, second, and third, where 'X' indicates a player is present and
   * 'o' indicates no player. For example, the string "XXo" means that there are
   * players on first and second but not on third.
   * 
   * @return three-character string showing players on base
   */
  public String getBases()
  {
    return (runnerOnBase(1) ? "X" : "o") + (runnerOnBase(2) ? "X" : "o")
        + (runnerOnBase(3) ? "X" : "o");
  }

  /**
   * Returns a one-line string representation of the current game state. The
   * format is:
   * 
   * <pre>
   *    ooo Inning:1 (T) Score:0-0 Balls:0 Strikes:0 Outs:0
   * </pre>
   * 
   * The first three characters represent the players on base as returned by the
   * <code>getBases()</code> method. The 'T' after the inning number indicates
   * it's the top of the inning, and a 'B' would indicate the bottom. The score always
   * shows team 0 first.
   * 
   * @return one-line string representation of the game state
   */
  public String toString()
  {
    String bases = getBases();
    String topOrBottom = (isTopOfInning() ? "T" : "B");
    String fmt = "%s Inning:%d (%s) Score:%d-%d Balls:%d Strikes:%d Outs:%d";
    return String.format(fmt, bases, whichInning(), topOrBottom, getTeam0Score(),
        getTeam1Score(), getBallCount(), getCalledStrikes(), getCurrentOuts());
  }
}
