package hw3;

import java.util.ArrayList;
//import static Status;

import api.BasketCell;
import api.Direction;
import api.SnakeLayoutException;
import api.SnakePiece;
import api.GridUtil;

/**
 * This class represents the basic game state for a "Snake Escape" game,
 * including a 2d grid of cells and a list of snakes.
 * 
 * @author Alexander Lafontaine
 */
public class SnakeBasket
{
	/**
	 * The 2D array of cells.
	 */
	private BasketCell[][] grid;

	/**
	 * The list of snakes.
	 */
	private ArrayList<Snake> snakes;

	/**
	 * Stores the current Snake.
	 */
	private Snake currentSnake = null;
	
	/**
	 * Indicates whether the current Snake is grabbed by the head or tail.
	 */
	private boolean grabbedByHead = false;
	
	/**
	 * Indicates whether the game is over or not.
	 */
	private boolean gameOver = false;
	
	/**
	 * Stores the amount of successful Moves.
	 */
	private int moveCounter = 0;
	
	/**
	 * Helper Method to help the move() method when Snake is grabbed by the head.
	 * @param dir
	 * @param row
	 * @param col
	 */
	private void moveHeadHelper(Direction dir, int row, int col)
	{
		BasketCell adjacentCell = getCell(row, col);
		if (adjacentCell.isEmpty())
		{
			currentSnake.moveHead(dir);
			++moveCounter;
		}
		else if (adjacentCell.isExit() && currentSnake.isGreen())
		{
			currentSnake.moveHead(dir);
			gameOver = true;
			++moveCounter;
		}
		else if (adjacentCell.hasSnake() && currentSnake.getTail().row() == row && currentSnake.getTail().col() == col)
		{
			currentSnake.moveHead(dir);
			++moveCounter;
		}
		else if (adjacentCell.isApple())
		{
			adjacentCell.clearFood();
			currentSnake.moveHeadAndGrow(dir);
			++moveCounter;
		}
		else if (adjacentCell.isMushroom())
		{
			adjacentCell.clearFood();
			currentSnake.moveHeadAndShrink(dir);
			++moveCounter;
		}
	}
	
	/**
	 * Helper Method to help the move() method when Snake is grabbed by the tail.
	 * @param dir
	 * @param row
	 * @param col
	 */
	private void moveTailHelper(Direction dir, int row, int col)
	{
		BasketCell adjacentCell = getCell(row, col);
		if (adjacentCell.isEmpty())
		{
			currentSnake.moveTail(dir);
			++moveCounter;
		}
		else if (adjacentCell.isExit() && currentSnake.isGreen())
		{
			currentSnake.moveTail(dir);
			gameOver = true;
			++moveCounter;
		}
		else if (adjacentCell.hasSnake() && currentSnake.getHead().row() == row && currentSnake.getHead().col() == col)
		{
			currentSnake.moveTail(dir);
			++moveCounter;
		}
	}

	/**
	 * Constructs an instance of this game from the given string array and list of
	 * snakes. <em>Snake information, if any, in the given string array is
	 * ignored</em>.
	 * 
	 * @param desc        array of strings representing the initial grid layout
	 * @param givenSnakes array of snakes
	 */
	public SnakeBasket(String[] desc, ArrayList<Snake> givenSnakes)
	{
		grid = GridUtil.createGridFromDescriptor(desc);
		snakes = givenSnakes;
		resetAllSnakes();
	}

	/**
	 * Constructs an instance of this game from the given string array.
	 * 
	 * @param desc array of strings representing the initial grid layout, including
	 *             ids and placement of snakes
	 */
	public SnakeBasket(String[] desc)
	{
		grid = GridUtil.createGridFromDescriptor(desc);
		snakes = SnakeUtil.findSnakes(desc);
		resetAllSnakes();
		SnakeUtil.findSnakes(desc);
	}

	/**
	 * Returns the grid cell at the given row and column.
	 * 
	 * @param row given row
	 * @param col given column
	 * @return grid cell at the given row and column
	 */
	public BasketCell getCell(int row, int col)
	{
		return grid[row][col];
	}

	/**
	 * Returns the number of rows in this game.
	 * 
	 * @return number of rows
	 */
	public int getRows()
	{
		return grid.length;
	}

	/**
	 * Returns the number of columns in this game.
	 * 
	 * @return number of columns
	 */
	public int getCols()
	{
		return grid[0].length;
	}

	/**
	 * Returns the currently grabbed snake, if any. Returns null if there is no
	 * current snake.
	 * 
	 * @return current snake, if any
	 */
	public Snake currentSnake()
	{
		return currentSnake;
	}

	/**
	 * Returns true if there is a current snake and it was grabbed at the head end,
	 * false if it was grabbed by the tail.
	 * 
	 * @return true if current snake was grabbed by the head
	 */
	public boolean currentWasGrabbedByHead()
	{
		return grabbedByHead;
	}

	/**
	 * Returns this SnakeBasket's list of all snakes. Normally this method is used
	 * to easily render or display the game; clients should not modify the list or
	 * the snakes.
	 * 
	 * @return list of all snakes
	 */
	public ArrayList<Snake> getAllSnakes()
	{
		return snakes;
	}

	/**
	 * Returns true if the green snake is in the exit cell, false otherwise.
	 * 
	 * @return true if green snake is in the exit
	 */
	public boolean isOver()
	{
		return gameOver;
	}

	/**
	 * Returns the total number of moves that have been made so far in this game.
	 * 
	 * @return number of moves
	 */
	public int getMoves()
	{
		return moveCounter;
	}

	/**
	 * Attempts to grab a snake by the head or tail at the given position. If there
	 * is not already a current snake, and if the given position contains a snake
	 * head or tail, that becomes the current snake. If this game already has a
	 * current snake selected, this method does nothing.
	 * 
	 * @param row given row at which to grab a snake
	 * @param col given column at which to grab a snake
	 */
	public void grabSnake(int row, int col)
	{
		if (currentSnake == null) 
		{
			Snake localSnake = grid[row][col].getSnake();
			if (localSnake.isHead(row, col))
			{
				currentSnake = localSnake;
				grabbedByHead = true;
			}
			else if (localSnake.isTail(row, col))
			{
				currentSnake = localSnake;
				grabbedByHead = false;
			}
		}
	}

	/**
	 * Sets the current snake to null, if any.
	 */
	public void releaseSnake()
	{
		currentSnake = null;
	}

	/**
	 * Attempt to move the current snake (head or tail) to an adjacent cell in the
	 * given direction. If a move is possible, this method updates the current
	 * snake, the move count, and the grid cells (via resetAllSnakes).
	 * <p>
	 * It is only possible to move in the following cases:
	 * <ul>
	 * <li>The adjacent cell is empty; then the snake (head or tail) moves into the
	 * cell
	 * <li>The adjacent cell is the exit and the current snake is the green one;
	 * then the snake (head or tail) moves into the exit and the game ends
	 * <li>The current snake was grabbed by the head, and the adjacent cell is
	 * row/column of the current snake's tail; then the snake (head) moves into the
	 * cell
	 * <li>The current snake was grabbed by the tail, and the adjacent cell is
	 * row/column of the current snake's head; then the snake (tail) moves into the
	 * cell
	 * <li>The current snake was grabbed by the head and the adjacent cell is an
	 * apple; then the apple is removed and the snake (head) moves into the cell,
	 * increasing its size by one piece
	 * <li>The current snake was grabbed by the head, has at least three pieces, and
	 * the adjacent cell is a mushroom; then the mushroom is removed and the snake
	 * (head) moves into the cell, reducing its size by one piece
	 * </ul>
	 * If none of the above conditions is met, this method does nothing. If any of
	 * the conditions is met and a move occurs, the move count is increased by 1. If
	 * there is no currently grabbed snake, this method does nothing.
	 * 
	 * @param dir Direction in which to attempt to move
	 */
	public void move(Direction dir)
	{
		/*
		 * 1) Check whether the head or the tail was grabbed.
		 * 2) Get location and check the adjacent block.
		 * 3) 
		 */
		if (currentSnake != null)
		{
			int row = 0;
			int col = 0;
			
			// Checks whether the head or tail is selected.
			if (grabbedByHead == true)
			{
				row = currentSnake.getHead().row();
				col = currentSnake.getHead().col();
				
				// Checks Direction of adjacent cell with respect to the Head.
				if (dir == Direction.UP)
				{
					moveHeadHelper(dir, row - 1, col);
				}
				else if (dir == Direction.DOWN)
				{
					moveHeadHelper(dir, row + 1, col);
				}
				else if (dir == Direction.LEFT)
				{
					moveHeadHelper(dir, row, col - 1);
				}
				else if (dir == Direction.RIGHT)
				{
					moveHeadHelper(dir, row, col + 1);
				}
			}
			else if (grabbedByHead == false)
			{
				row = currentSnake.getTail().row();
				col = currentSnake.getTail().col();
				
				// Checks Direction of adjacent cell with respect to the Tail.
				if (dir == Direction.UP)
				{
					moveTailHelper(dir, row - 1, col);
				}
				else if (dir == Direction.DOWN)
				{
					moveTailHelper(dir, row + 1, col);
				}
				else if (dir == Direction.LEFT)
				{
					moveTailHelper(dir, row, col - 1);
				}
				else if (dir == Direction.RIGHT)
				{
					moveTailHelper(dir, row, col + 1);
				}
			}
			
			resetAllSnakes();
		}
	}

	/**
	 * Clears all snake information from the grid, if any, and then sets it from the
	 * current list of snakes. After executing this method, the information in the
	 * grid cells and the information in the snake list should be fully consistent.
	 */
	public void resetAllSnakes()
	{
		/*
		 * 1) Iterate through the entire grid, clearing any snakes 2) Iterate through
		 * the entire grid, setting snakes
		 */

		for (int row = 0; row < getRows(); ++row) 
		{
			for (int col = 0; col < getCols(); ++col)
			{
				grid[row][col].clearSnake();

				// Iterates through Snakes
				for (Snake resetSnakes : snakes) 
				{
					// Iterates through SnakePieces from Snake.
					for (SnakePiece pieces : resetSnakes.getPieces()) 
					{
						if (pieces.row() == row && pieces.col() == col) 
						{
							grid[row][col].setSnake(resetSnakes);
						}
					}
				}
			}
		}
	}
}
