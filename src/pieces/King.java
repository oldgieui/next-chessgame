package pieces;

import java.util.List;

public class King extends Piece {
	public King(Color color, Position position) {
		super(color, Type.KING, position);
	}

	@Override
	List<Position> getPossibleMoves() {
		PositionController pc =  new PositionController(position);
		List<Position> possiblePositions = pc.findsPositionForKing();	//PositionController 클래스에 King을 옮길 수 있는 자리를 찾기 위한 메소드를 따로 만듦.
		return possiblePositions;
	}
}

