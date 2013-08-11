package pieces;

import java.util.List;

public class Knight extends Piece {
	public Knight(Color color, Position position) {
		super(color, Type.KNIGHT, position);
	}

	@Override
	List<Position> getPossibleMoves() {
		PositionController pc = new PositionController(position);
		List<Position> possiblePositions = pc.findPositionForKnight();
		return possiblePositions;
	}
}
