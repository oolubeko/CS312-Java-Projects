/*
  File: TestMineSweeper.java

  Description: Implements the minesweeper class and interfaces GUI

  Student Name: Tomi Olubeko

  Student UT EID: oeo227

  Partner's Name: Travis Driver

  Partner's UT EID: 

  Course Name: CS 312

  Unique Numbers: 87525

  Date Created: 8/10/16

  Date Last Modified: 8/14/16

*/

class minesweeper 
{
  /** 
    mine and clue values, 9 - mine, 0-8 clue values
  */
  public int[][] mines;

  /** 
    tile values:
       0 - open 
       1 - closed
       2 - question 
       3 - mine
  */
  public int[][] tiles;

  /** 
    Game status - win, lose, play
  */
  private String status;

  /** 
    Default constructor
      *	board size 9 x 9
      * create mines and tile arrays
      * place mines
      * calculate clues
      * set game status to play   
  */
  public minesweeper() 
  {
    initGame(9, 9);
  }

  /** 
    Non-default constructor
      * use specifies board size
      * create mines and tile arrays
      * place mines
      * calculate clues
      * set game status to play
      * newRows number of rows for grid
      * newCols number of columns for grid
  */
  public minesweeper (int newRows, int newCols) 
  {
    initGame(newRows, newCols);
  }

  /** 
    Returns the game status - "play", "win", or "lose"
  */
  public String getStatus () 
  {
    return status;
  }

  /** 
    Returns number of rows in the board
  */
  public int getRows () 
  {
    return mines.length;
  }

  /** 
    Returns the number of columns in the board
  */
  public int getCols () 
  {
    return mines[0].length;
  }

  /** 
    Returns the value of the mines array at r,c
    * -1 is returned if invalid r,c
    * r row index
    * c column index
  */
  public int getMines (int r, int c) 
  {
    if (validIndex(r, c)) 
    {
      return mines[r][c];
    } 
    else 
    {
      return -1;
    }
  }

  /** 
    Returns the value of the tiles array at r,c
    * -1 is returned if invalid r,c
    * r row index
    * c column index
  */
  public int getTiles (int r, int c) 
  {
    if (validIndex(r, c)) 
    {
      return tiles[r][c];
    } 
    else 
    {
      return -1;
    }
  }

  /** 
    Mark tile - 
    * open tile 
    * flag tile as mine 
    * set tile as question mark 
    * close tile
    * r row index
    * c column index
    * t: 0 - open, 1 - close, 2 - question, 3 - mine
    * invalid r,c values must be ignored
    * a tile that is opened must stay open
    * a tile that is marked as a flag (ie. tile[][] value 3) can not be opened
    * tile values can only change when game status is "play"
    * game status must be updated after a tile is opened
    * implementation must be recursive; you can use a helper method
  */
  public void markTile (int r, int c, int t) 
  {
    // add your code here
	if((status.equals("win")) || (status.equals("lose")))
	{
		return;
	}
	int getMines = getMine(r,c);
	int getTiles = getTile(r,c);
	if(t == 0)
	{
		if(getMines == 0)
		{
			tile[r][c] = t;
			if((validIndex(r + 1 , c))  && (getTiles != 0))
			{
				markTile(r + 1, c, 0);
			}
			if((validIndex(r - 1 , c)) && (getTiles != 0))
			{
				markTile(r - 1, c, 0);
			}
			if((validIndex(r, c + 1)) && (getTiles != 0));
			{
				markTile(r, c + 1, 0);
			}
			if((validIndex(r, c - 1)) && (getTiles != 0))
			{
				markTile(r, c - 1, 0);
			}
			if((validIndex(r - 1, c + 1)) && (getTiles != 0))
			{
				markTile(r - 1, c + 1, 0);
			}
			if((validIndex(r - 1; c - 1)) && (getTiles != 0))
			{
				markTile(r - 1, c - 1, 0);
			}
			if((validIndex(r + 1, c + 1)) && (getTiles != 0))
			{
				markTile(r + 1, c + 1, 0);
			}
			if((validIndex(r + 1, c - 1)) && (getTiles != 0))
			{
				markTile(r + 1, c - 1, 0);
			}
		}	
			
		else if((getMines >= 1) && (getMine <= 8))
		{
			tile[r][c] = t;
		}
		else
		{
			tiles[r][c] = t;
			status = "lose";
			return;
		}
			
	}
	if(t == 1)
	{
		if(getTiles == 2)
		{
			tiles[r][c] = t;
		}
	}
	if(t == 2)
	{
		if(getTiles != 0)
		{
			tiles[r][c] = t;
		}
	}
	if(t == 3)
	{
		if(getTiles != 0)
		{
			tiles[r][c] = t;
		}
	}
	if(gameWon())
	{
		status = "win";
	}
  }

  /** 
    Returns mines array as a String
  */
  public String toStringMines() 
  {
    String result = "\n";

    for (int r = 0; r < mines.length; r++) 
    {
      for (int c = 0; c < mines[r].length; c++)
	result = result + mines[r][c];

      result += "\n";
    }

    return result;
  }

  /**
    Returns tiles array as a String
  */
  public String toStringTiles() 
  {
    String result = "\n";

    for (int r = 0; r < tiles.length; r++) 
    {
      for (int c = 0; c < tiles[r].length; c++)
	result = result + tiles[r][c];

      result += "\n";
    }

    return result;
  }

  /** 
    Returns game board as String
  */
  public String toStringBoard () 
  {
    String result = "";

    for (int r = 0; r < tiles.length; r++) 
    {
      for (int c = 0; c < tiles[r].length; c++) 
      {
	result += this.getBoard(r, c);
      }
      result += "\n"; //advance to next line
    }

    return result;
  }

  /** 
    getBoard - determines current game board character for r,c position 
    * using the value of the mines[][] and tiles[][]array
    * '1'-'8'  opened tile showing clue value
    * ' '      opened tile blank
    * 'X'      tile closed
    * '?'      tile closed marked with ?
    * 'F'      tile closed marked with flag
    * '*'      mine
    * 
    * '-'      if game lost, mine that was incorrectly flagged
    * '!'      if game lost, mine that ended game
    * 'F'      if game won, all mines returned with F
  */
  public char getBoard (int r, int c) 
  {
    //	add your code here
	char game = ' ';
	int isMine = getMines(r,c);
	int onTile = getTiles(r,c);
	if(status.equals("play"))
	{
		if((onTile == 0) && (isMine == 0))
		{
			game = ' ';
		}
		else if((onTile == 0) && (isMine >= 1) && (isMine <= 8))
		{
			game = Integer.toString(isMine).charAt(0);
		}
		else if(onTile == 1)
		{
			game = 'X';
		}
		else if(onTile == 2)
		{
			game = '?';
		}
		else if(onTile == 3)
		{
			game == 'F';
		}
	}
	else if(status.equals("lose"))
	{
		if((onTile == 0) && (isMine == 9))
		{
			game = '!';
		}
		if((onTile == 0) && (isMine != 9))
		{
			game = Integer.toString(isMine).charAt(0);
		}
		else if((onTile == 1) || (onTile == 2))
		{
			if(isMine == 9)
			{
				game = '*';
			}
			else
			{
				game = 'X';
			}
		}
		else if(onTile == 3)
		{
			if((isMine >= 0) && (isMine <= 8))
			{
				game = '-';
			}
			else
			{
				game = '*';
			}
		}
	}
	else if(status.equals("win"))
	{
		if(isMines == 9)
		{
			game = 'F';
		}
		if((isMine != 9) && (onTile == 0))
		{
			game = Integer.toString(isMine).charAt(0);
		}
	}
    return game; //this line must be modified
  }

  /** 
    Create mines & tiles array
    * place mines
    * update clues
    * newRows number of rows for grid
    * newCols number of columns for grid
  */
  private void initGame (int newRows, int newCols) 
  {
    //allocate space for mines and tiles array
    if ((newRows >= 1) && (newCols >= 1)) 
    {
      mines = new int[newRows][newCols];
      tiles = new int[newRows][newCols];

      //init tiles array
      resetTiles();

      //place mines
      placeMines();

      //update clues
      calculateClues();

      //set game status
      status = "play";
    }
  }

  /** 
    Sets all tiles to 1 - closed
  */
  private void resetTiles () 
  {
    // add your code here
	for(int i = 0; i < tiles.length; i++)
	{
		for(int j = 0; j < tiles[0].length; j++)
		{
			tiles[i][j] = 1;
		}
	}
	
  }

  /** 
    Places mines randomly on grid
    * integer value 9 represents a mine
    * number of mines = 1 + (number of columns * number rows) / 10
    * minimum number of mines = 1
  */
  private void placeMines () 
  {
    // add your code here
	int numMines = 1 + (mines.length * mines[0].length) / 10;
	for(int i = 0; i < numMines; i++)
	{
		double randX = Math.random();
		double randY = Math.random();
		int indRow = (int) (mines.length * randX);
		int indCol = (int) (mines[0].length *randY);
		mines[indRow][indCol] = 9;
	}
  }

  /** 
    Calculates clue values and updates
    * clue values in mines array
    * integer value 9 represents a mine
    * clue values will be 0 ... 8
  */
  private void calculateClues () 
  {
    // add your code here
	for(int i = 0; i < mine.length; i++)
	{
		for(int j = 0; j < mines[0].length; j++)
		{
			int count = 0;
			int space = mines[i][j];
			if(space != 9)
			{	
				if(validIndex(i + 1, j ))
				{
					if((getMines(i + 1, j) == 9))
						count++;
				}
				if(validIndex(i - 1, j))
				{
					if((getMines(i - 1, j) == 9))
						count++;
				}
				if(validIndex(i, j + 1))
				{
					if((getMines(i, j + 1) == 9))
						count++;
				}
				if(validIndex(i, j - 1))
				{
					if((getMines(i, j - 1) == 9))
						count++;
				}
				if(validIndex(i + 1, j + 1))
				{
					if((getMines(i + 1, j + 1) == 9))
						count++;
				}
				if(validIndex(i + 1, j - 1))
				{
					if((getMines(i + 1, j - 1) == 9))
						count++;
				}
				if(validIndex(i - 1, j - 1))
				{
					if((getMines(i - 1, j - 1) == 9))
						count++;
				}
				if(validIndex(i - 1, j + 1))
				{	
					if((getMines(i - 1, j + 1) == 9))
						count++;
				}		
				mines[i][j] = count;
			}
		}
	}
  }

  /** 
    Determines if x,y is valid position
    * x row index
    * y column index
    * true if valid position on board,
    * false if not valid board position
  */
  private boolean validIndex (int x, int y) 
  {
    //add your code here
	return((x < mines.length) && (x >= 0) && (y >= 0) && (y < mines[0].length));
  }

  /** 
    Returns game status - true if game won or false
                          if game not won
  */
  private boolean gameWon() 
  {
    //add your code here
	int numClosed = 0;
	int numMines = 1 + (getRows() * getCols()) / 10;
	for(int i = 0; i < mine.length; i++)
	{
		for(int j = 0; j < mines[0].length; j++)
		{
			if((tiles[i][j] == 1) || (tiles[i][j] == 2) || (tiles[i][j] == 3))
			{
				numClosed++;
			}
		}
	}
	return (numClosed == numMines);
  }

}
public class TestMineSweeper 
{
  public static void main(String[] args) 
  {
    // create new minesweeper instance 2 rows by 5 columns
    minesweeper game = new minesweeper (2, 5);

    // display mines
    System.out.println ( game.toStringMines() );
        
    // display tiles
    System.out.println ( game.toStringTiles() );
	    
    // display board
    System.out.println ( game.toStringBoard() );
		
    // mark tile at (0, 0) as Open
    game.markTile (0, 0, 0);
	
    // mark tile at (0, 1) as Question Mark
    game.markTile (0, 1, 2);
			
    // mark tile at (0, 0) as Mine
    game.markTile (0, 2, 3);
		  
    // display tiles 
    System.out.println ( game.toStringTiles() );
	   
    // display board
    System.out.println ( game.toStringBoard() );
		
  }
}