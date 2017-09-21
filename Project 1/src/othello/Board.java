package othello;

public class Board extends Piece{

	final int BOARD_SIZE = 8;
	int rowNum = 1;
	int x = 0;
	int y = -1;
	String[][] boardLayout = new String[BOARD_SIZE][BOARD_SIZE];
	
		/**
		 * @param Specifies what color to pass through overridden constructor
		 */
		public Board(String color) {
			super(color);
		}
	
	/**
	 * @param x Indicates x coordinate desired when setting piece on board
	 * @param y Indicates y coordinate desired when setting piece on board
	 * @param c Indicates what color the piece should be when placed on board
	 */
	public void setSquare(int x, int y, String c) {
		setPiece(c);
		boardLayout[x][y] = getPiece();
	}
	

	/**
	 * @param x Indicates x coordinate to be read from boardLayout[][]
	 * @param y Indicates y coordinate to be read from boardLayout[][]
	 * @return Returns result of piece that is on the specified coordinates
	 */
	public String atPosition(int x, int y) {
		return boardLayout[x][y];
	}
	
	/**
	 * wipeBoard() erases the whole boardLayout[][] by writing blank
	 * characters to all coordinates using nested for loops
	 */
	public void wipeBoard() {
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				setSquare(i,j,BLANK);
			}
		}
	}
		
/*	horizLine() method is called during drawBoard() to 
	divide rows with a straight line of dash characters*/
	private void horizLine() {
		System.out.print("  ");
		for(int i = 0; i < 49; i++) {
			System.out.print("-");
		}
		System.out.println();
		y++;
	}
	
/*	columnDivide() method is called during drawBoard() to
	divide columns with whitespace and vertical lines*/
	private void columnDivide() {
		System.out.print("  |");
		for(int i = 0; i < 8; i++)	{
			System.out.print("     |");
		}
		System.out.println();
	}

/*	playSpace() method is called during drawBoard() to
	draw column dividers in the center row of each play
	space with either a blank space or a piece in the center*/
	private void playSpace() {
		x = 0;
		System.out.print(rowNum + " |");
		while(x < 8) {
			System.out.printf("  " + boardLayout[x][y] + "  |");
			x++;
		}
		x = 0;
		System.out.println();
		rowNum++;
	}

	/**
	 * drawBoard() method is called during each turn to draw
	 * an updated version of the current board
	 */
	public void drawBoard() {
		y = -1;
		x = 0;
		rowNum = 1;
		System.out.printf("%6d %5d %5d %5d %5d %5d %5d %5d  \n", 1, 2, 3, 4, 5, 6, 7, 8);
		int numRows = 1;
		while(numRows < 34) {
			switch (numRows) {
			case 1: case 5: case 9: case 13: case 17: 
			case 21: case 25: case 29: case 33: 
				horizLine();
			break;
			
			case 2: case 4: case 6: case 8: case 10:
			case 12: case 14: case 16: case 18: case 20:
			case 22: case 24: case 26: case 28: case 30:
			case 32:
				columnDivide();
			break;
			
			case 3: case 7: case 11: case 15: case 19:
			case 23: case 27: case 31:
				playSpace();
			break;
			}
			numRows++;
		}
	}
}