package pieces;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece {
	public Queen(Color color, Position position) {
		super(color, Type.QUEEN, position);
	}

	@Override
	List<Position> getPossibleMoves() {
		PositionController pc = new PositionController(position);
//		List<Position> possiblePlacesLinear = pc.findsLinearPositionAll();
//		List<Position> possiblePlacesDiagonal = pc.findsDiagonalPositionAll();
		List<Position> possiblePlaces = new ArrayList<Position>(pc.findsLinearPositionAll());
		possiblePlaces.addAll(pc.findsDiagonalPositionAll());
		
		return possiblePlaces;
		
	}
}
