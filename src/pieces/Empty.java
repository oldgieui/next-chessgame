package pieces;

import java.util.List;

public class Empty extends Piece {
	public Empty(Color color, Position position) {
		super(color, Type.EMPTY, position);
	}

	@Override
	List<Position> getPossibleMoves() {
		return null;
		//Empty 위치에서는 옮기고 말고 할 것이 없어서 null 리턴. 
		//이후 에러처리 추가할것 
	}
}
