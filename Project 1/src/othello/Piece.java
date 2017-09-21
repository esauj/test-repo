package othello;

public class Piece {
	
	public static final String BLACK = "B";
	public static final String WHITE = "W";
	public static final String BLANK = " ";
	private String color = BLANK;
	
	/**
	 * @param color2 Specifies the color of Piece used
	 */
	public Piece(String color2) {
		super();
		this.color = color2;
	}

	/**
	 * @return Returns current piece color
	 */
	public String getPiece() {
		return color;
	}
	
	/**
	 * @param c Specifies what color to set
	 * @return Returns color specified if needed
	 */
	public String setPiece(String c) {
		color = c;
		return color;
	}
	
	/**
	 * flipPiece() method reassigns color when necessary
	 */
	public void flipPiece(){
		if(color == BLACK)
			color = WHITE;
		else
			color=BLACK;
	
	}
	
}