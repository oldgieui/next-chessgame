package pieces;

import java.util.List;

public interface PieceOperations {
	char getSymbol();
	boolean isWhite();
	boolean isBlack();
	Piece leave();
	Piece move(Position target);
	List <Position> getPossibleMoves2();
	String getTypeName();
}
