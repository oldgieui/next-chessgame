package pieces;

import java.util.ArrayList;
import java.util.List;

public class PositionController {
	private Position position;;

	public PositionController(Position position) {
		this.position = position;
	}

	public List<Position> findsLinearPositionAll() {
		Direction[] linears = Direction.linearDirection();
		List<Position> positions = new ArrayList<Position>();
		for (Direction direction : linears) {
			positions.addAll(position.findsPosition(direction));
		}
		return positions;
	}

	public List<Position> findsDiagonalPositionAll() {
		Direction[] diagonals = Direction.diagonalDirection();
		List<Position> positions = new ArrayList<Position>();
		for (Direction direction : diagonals) {
			positions.addAll(position.findsPosition(direction));
		}
		return positions;
	}

	public List<Position> findsPositionForKing() { //King 클래스에만 사용하는 메소드. 한 군데만 사용하는 메소드를 따로 만들지 않고 해결하는 방법은 없는가?
		Direction[] linears = Direction.linearDirection();
		Direction[] diagonals = Direction.diagonalDirection();
		List<Position> positions = new ArrayList<Position>();
		for (Direction direction : linears) {
			positions.addAll(position.findsPositionForKing(direction));
		}
		for (Direction direction : diagonals) {
			positions.addAll(position.findsPositionForKing(direction));
		}
		return positions;
	}
	
	public List<Position> findsPositionForBlackPawn() {
		List<Position> positions = new ArrayList<Position>();
		positions.addAll(position.findsPositionForBlackPawn(position));
		return positions;
	}

	public List<Position> findsPositionForWhitePawn() {
		List<Position> positions = new ArrayList<Position>();
		positions.addAll(position.findsPositionForWhitePawn(position));
		return positions;
	}

	public List<Position> findPositionForKnight() {
		List<Position> positions = new ArrayList<Position>();
		Direction[] linears = Direction.linearDirection();
		Direction[] diagonal = Direction.diagonalDirection();
		for (Direction linearDirection : linears) {
			for (Direction diagonalDirection : diagonal) {
				positions.addAll(position.findsPositionForKnight(position, linearDirection, diagonalDirection));
			}
		}
		return positions;
	}

}
