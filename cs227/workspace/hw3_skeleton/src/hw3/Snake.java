package hw3;

import java.util.ArrayList;

import api.Direction;
import api.SnakePiece;

/**
 * A Snake is a sequence of (row, column) pairs in which each (row, column) in
 * the sequence represents a 2d position that is horizontally or vertically
 * adjacent to the previous one. Each (row, column) is represented by an
 * instance of the class SnakePiece. The first piece in the sequence is called
 * the "head", and the last one is called the "tail". In addition to the list of
 * SnakePiece objects, a Snake has an id consisting of a single character.
 * <p>
 * A snake may or may not be <em>valid</em>. More precisely, a snake is defined
 * to be valid if:
 * <ul>
 * <li>It has at least two pieces
 * <li>There are no null elements in its pieces list
 * <li>There are no duplicates in its pieces list
 * <li>Each piece in the list has a row and column position that is horizontally
 * or vertically adjacent to the previous piece in the list
 * </ul>
 * The methods to add pieces to a snake do NOT do any error-checking. Instead,
 * clients can use the method isValid to check whether the snake is valid.
 * 
 * @author Alexander Lafontaine
 */
public class Snake
{

	/**
	 * Stores the SnakePieces of the Snake.
	 */
	private ArrayList<SnakePiece> snakePieces = new ArrayList<>();

	/**
	 * Stores the ID of the Snake.
	 */
	private char snakeId = 'a';

	/**
	 * Stores the Head Piece of the Snake.
	 */
	private SnakePiece snakeHead = null;

	/**
	 * Stores the Tail Piece of the Snake.
	 */
	private SnakePiece snakeTail = null;

	/**
	 * Helper Method for updating snakePieces for when the snake moves.
	 */
	private void updateSnake(char type, int row, int col)
	{
		if (type == 'h') 
		{
			SnakePiece headUpdated = new SnakePiece(row, col);
			snakePieces.add(0, headUpdated);
		} 
		else if (type == 't') 
		{
			SnakePiece tailUpdated = new SnakePiece(row, col);
			snakePieces.add(tailUpdated);
		}

	}

	/**
	 * Helper Method for updating Head and Tail instance variables.
	 */
	private void updateHeadAndTail()
	{
		snakeHead = getHead();
		snakeTail = getTail();
	}

	/**
	 * Constructs a Snake with an empty list of SnakePiece objects and with the
	 * given character as its ID.
	 * 
	 * @param givenId ID to use for this Snake
	 */
	public Snake(char givenId)
	{
		snakeId = givenId;
	}

	/**
	 * Adds a new SnakePiece to the end of this Snake's list of pieces. This method
	 * does no error-checking to ensure the given position is actually adjacent to
	 * the current tail.
	 * 
	 * @param row row for the new SnakePiece
	 * @param col column for the new SnakePiece
	 */
	public void addPiece(int row, int col)
	{
		SnakePiece piece = new SnakePiece(row, col);
		snakePieces.add(piece);
		updateHeadAndTail();
	}

	/**
	 * Sets this Snake's list of pieces at the given index to be a new SnakePiece
	 * with the given row and column. If the current list of pieces is shorter than
	 * the given index, it is padded with nulls so the given index can be set. This
	 * method does no error-checking to ensure the given (row, column) is actually
	 * adjacent to its neighbors in the list of pieces.
	 * 
	 * @param index index in the list of pieces where the new SnakePiece will be set
	 * @param row   row for the new SnakePiece
	 * @param col   column for the new SnakePiece
	 */
	public void addPiece(int index, int row, int col)
	{
		while (snakePieces.size() <= index)
		{
			snakePieces.add(null);
		}
		SnakePiece piece = new SnakePiece(row, col);
		snakePieces.set(index, piece);
		updateHeadAndTail();
	}

	/**
	 * Returns the ID for this Snake.
	 * 
	 * @return ID for this Snake
	 */
	public char getId()
	{
		return snakeId;
	}

	/**
	 * Returns true if the ID is one of the characters 'g' or 'G'.
	 * 
	 * @return true if ID is 'g' or 'G'
	 */
	public boolean isGreen()
	{
		return snakeId == 'g' || snakeId == 'G';
	}

	/**
	 * Returns the first piece in this Snake's list of pieces, or null if this snake
	 * has no pieces.
	 * 
	 * @return first piece
	 */
	public SnakePiece getHead()
	{
		return snakePieces.get(0);
	}

	/**
	 * Returns the last piece in this Snake's list of pieces, or null if this snake
	 * has no pieces.
	 * 
	 * @return last piece
	 */
	public SnakePiece getTail()
	{
		return snakePieces.get(snakePieces.size() - 1);
	}

	/**
	 * Returns true if given row and column match the row and column of this Snake's
	 * first piece. Returns false if this snake has no pieces.
	 * 
	 * @param row given row
	 * @param col given column
	 * @return true if the head of this Snake has the same row and column
	 */
	public boolean isHead(int row, int col)
	{
		return snakeHead.row() == row && snakeHead.col() == col;
	}

	/**
	 * Returns true if given row and column match the row and column of this Snake's
	 * last piece. Returns false if this snake has no pieces.
	 * 
	 * @param row given row
	 * @param col given column
	 * @return true if the tail of this Snake has the same row and column
	 */
	public boolean isTail(int row, int col)
	{
		return snakeTail.row() == row && snakeTail.col() == col;
	}

	/**
	 * Returns this Snake's list of pieces. Normally this method is used to render
	 * or display the game; clients should not directly modify the snakes through
	 * this method.
	 * 
	 * @return list of SnakePiece objects for this Snake
	 */
	public ArrayList<SnakePiece> getPieces()
	{
		return snakePieces;
	}

	/**
	 * Moves the head of this Snake in the given direction without changing its
	 * length. Does nothing if the snake has fewer than two pieces.
	 * 
	 * @param dir which direction
	 */
	public void moveHead(Direction dir)
	{
		// Checks if it has 2 or more pieces.
		if (snakePieces.size() >= 2)
		{
			
			// Moves UP or DOWN or LEFT or RIGHT
			if (dir == Direction.UP) 
			{
				updateSnake('h', snakeHead.row() - 1, snakeHead.col());
			} 
			else if (dir == Direction.DOWN) 
			{
				updateSnake('h', snakeHead.row() + 1, snakeHead.col());
			} 
			else if (dir == Direction.LEFT) 
			{
				updateSnake('h', snakeHead.row(), snakeHead.col() - 1);
			} 
			else if (dir == Direction.RIGHT) 
			{
				updateSnake('h', snakeHead.row(), snakeHead.col() + 1);
			}

			snakePieces.remove(snakePieces.size() - 1);
			updateHeadAndTail();
		}
	}

	/**
	 * Moves the tail of this Snake in the given direction without changing its
	 * length. Does nothing if the snake has fewer than two pieces.
	 * 
	 * @param dir which direction
	 */
	public void moveTail(Direction dir)
	{
		// Checks if it has 2 or more pieces.
		if (snakePieces.size() >= 2)
		{
			
			// Moves UP or DOWN or LEFT or RIGHT
			if (dir == Direction.UP) 
			{
				updateSnake('t', snakeTail.row() - 1, snakeTail.col());
			} 
			else if (dir == Direction.DOWN) 
			{
				updateSnake('t', snakeTail.row() + 1, snakeTail.col());
			} 
			else if (dir == Direction.LEFT) 
			{
				updateSnake('t', snakeTail.row(), snakeTail.col() - 1);
			} 
			else if (dir == Direction.RIGHT) 
			{
				updateSnake('t', snakeTail.row(), snakeTail.col() + 1);
			}
			
			snakePieces.remove(0);
			updateHeadAndTail();
		}
	}

	/**
	 * Moves the head of this Snake in the given direction, increasing its length by
	 * 1. Does nothing if the snake has fewer than two pieces.
	 * 
	 * @param dir which direction
	 */
	public void moveHeadAndGrow(Direction dir)
	{
		// Checks if it has 2 or more pieces.
		if (snakePieces.size() >= 2)
		{
			
			// Moves UP or DOWN or LEFT or RIGHT
			if (dir == Direction.UP) 
			{
				updateSnake('h', snakeHead.row() - 1, snakeHead.col());
			} 
			else if (dir == Direction.DOWN) 
			{
				updateSnake('h', snakeHead.row() + 1, snakeHead.col());
			} 
			else if (dir == Direction.LEFT) 
			{
				updateSnake('h', snakeHead.row(), snakeHead.col() - 1);
			} 
			else if (dir == Direction.RIGHT) 
			{
				updateSnake('h', snakeHead.row(), snakeHead.col() + 1);
			}
			updateHeadAndTail();
		}
	}

	/**
	 * Moves the head of this Snake in the given direction, decreasing its length by
	 * 1. Does nothing if this Snake fewer than three pieces.
	 * 
	 * @param dir which direction
	 */
	public void moveHeadAndShrink(Direction dir)
	{
		// Checks if it has 2 or more pieces.
		if (snakePieces.size() >= 3)
		{
			
			// Moves UP or DOWN or LEFT or RIGHT
			if (dir == Direction.UP) 
			{
				updateSnake('h', snakeHead.row() - 1, snakeHead.col());
			} 
			else if (dir == Direction.DOWN) 
			{
				updateSnake('h', snakeHead.row() + 1, snakeHead.col());
			} 
			else if (dir == Direction.LEFT) 
			{
				updateSnake('h', snakeHead.row(), snakeHead.col() - 1);
			} 
			else if (dir == Direction.RIGHT) 
			{
				updateSnake('h', snakeHead.row(), snakeHead.col() + 1);
			}

			snakePieces.remove(snakePieces.size() - 1);
			snakePieces.remove(snakePieces.size() - 1);
			updateHeadAndTail();
		}
	}

	/**
	 * Determines whether this snake is valid. A snake is <em>valid</em> if
	 * <ul>
	 * <li>It has at least two pieces
	 * <li>There are no null elements in its pieces list
	 * <li>There are no duplicates in its pieces list
	 * <li>Each piece in the list has a row and column position that is horizontally
	 * or vertically adjacent to the previous piece in the list
	 * </ul>
	 * 
	 * @return true if this snake is valid, false otherwise
	 */
	public boolean isValid()
	{
		// Checks if Snake is more than 2 pieces.
		if (snakePieces.size() >= 2)
		{
			for (int i = 0; i < snakePieces.size(); ++i)
			{
				SnakePiece test = snakePieces.get(i);
				
				// Checks if an element is null.
				if (test == null)
				{
					return false;
				}
				
				// Checks if the element is repeated.
				for (int j = 0; j < snakePieces.size(); ++j)
				{
					// Makes sure it isn't the same element.
					if (i == j)
					{
						continue;
					}
					if (test.equals(snakePieces.get(j)))
					{
						return false;
					}
				}
			}
			
			// Iterates through the array list and checks if the SnakePieces are adjacent.
			for (int k = 0; k < snakePieces.size() - 1; ++k)
			{
				SnakePiece firstPiece = snakePieces.get(k);
				SnakePiece secondPiece = snakePieces.get(k + 1);
				
				// Makes sure the second piece is at x - 1, x + 1, y - 1 or y + 1. If it fails, returns false.
				if (firstPiece.row() == secondPiece.row() - 1 || firstPiece.row() == secondPiece.row() + 1)
				{
					continue;
				}
				else if (firstPiece.col() == secondPiece.col() - 1 || firstPiece.col() == secondPiece.col() + 1)
				{
					continue;
				}
				else
				{
					return false;
				}
			}
		}
		
		return true;
	}

}
