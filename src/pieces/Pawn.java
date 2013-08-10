package pieces;

import java.util.List;

public class Pawn extends Piece {
	public Pawn(Color color, Position position) {
		super(color, Type.PAWN, position);
	}

	@Override
	List<Position> getPossibleMoves() {
		PositionController pc = new PositionController(position);
		List<Position> possiblePositions = null;
		if (this.color == Color.BLACK) {
			possiblePositions = pc.findsPositionforBlackPawn();
		} else if (this.color == Color.WHITE) {
			possiblePositions = pc.findsPositionforWhitePawn();
		}
		return possiblePositions;
	}
}
