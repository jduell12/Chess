

import java.awt.*;
import javax.swing.*;



public class ChessProgram extends JFrame {

	ChessProgram() {
		super("Chess Program");
		ChessPiece.readInImages();
		setSize(800, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		

	}

	public void paint(Graphics g) {
		super.paint(g);
		Insets insets = getInsets();
		int top = insets.top;
		int bottom = insets.bottom;
		int left = insets.left;
		int right = insets.right;

		int height = getHeight();
		int width = getWidth();

		int cell_h = (height - top - bottom) / 8;
		int cell_w = (width - left - right) / 8;
		
		BoardDimensions boardDimensions = new BoardDimensions(left, top, cell_w, cell_h);

		int x, y;

		for (int row = 0; row < 8; row++) {
			y = top + row * cell_h;
			for (int col = 0; col < 8; col++) {
				x = left + col * cell_w;
				boolean greenColor = (row + col) % 2 == 1;
				if (greenColor) {
					g.setColor(Color.GREEN);
				} else {
					g.setColor(Color.WHITE);
				}
				g.fillRect(x, y, cell_w, cell_h);
			}
		}
		
		//Order of king row on the chess board
		PieceType [] kingRow = {PieceType.Rook, PieceType.Knight, PieceType.Bishop, PieceType.Queen, PieceType.King, PieceType.Bishop, PieceType.Knight, PieceType.Rook};
		
		//draws black pawns on the chess board
		for (int col = 0; col < 8; col++) {
			Piece p = new Piece (ColorType.black, PieceType.Pawn, col, 1);
			p.drawInPosition(g, boardDimensions);
		}
		
		//draws the black king row on the chess board
		for (int col = 0; col < 8; col++) {
			Piece p = new Piece (ColorType.black, kingRow[col], col, 0);
			p.drawInPosition(g, boardDimensions);
		}
		
		//draws white pawns on the chess board
		for (int col = 0; col < 8; col++) {
			Piece p = new Piece (ColorType.white, PieceType.Pawn, col, 6);
			p.drawInPosition(g, boardDimensions);
		}
		
		//draws the white king row on the chess board
		for (int col = 0; col < 8; col++) {
			Piece p = new Piece (ColorType.black, kingRow[col], col, 7);
			p.drawInPosition(g, boardDimensions);
		}
		

	}

	public static void main(String[] args) {
		ChessProgram cp = new ChessProgram();
	}

}
