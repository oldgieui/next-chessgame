package pieces;

import java.util.ArrayList;
import java.util.List;

import chess.Board;

public class Position {
	private static final char COLUMN_START_CHAR = 'a';

	private int x;
	private int y;

	public Position(String position) {
		// 에러 상태에 대한 처리 필요함.
		this.x = generateColumnIndex(position.charAt(0));
		this.y = Integer.parseInt(position.substring(1)) - 1;
	}

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	private int generateColumnIndex(char columnIndex) {
		int target = Character.getNumericValue(columnIndex);
		int source = Character.getNumericValue(COLUMN_START_CHAR);
		return target - source;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

//	Queen 위치 확인 테스트를 위해 만든 메소드이나 테스트코드만을 위한 메소드를 만드는 것은 본말전도라는 조언에 따라 뺌.
//	public void setNewPosition(String position){
//		this.x = generateColumnIndex(position.charAt(0));
//		this.y = Integer.parseInt(position.substring(1)) - 1;
//	}
	
	Position move(Direction direction) {
		return new Position(this.x + direction.getXDegree(), this.y + direction.getYDegree());
	}

	List<Position> findsPosition(Direction direction) {
		ArrayList<Position> positions = new ArrayList<Position>();
		Position currentPosition = move(direction);
		while(currentPosition.isValid()) {
			positions.add(currentPosition);
			currentPosition = currentPosition.move(direction);
		}
		return positions;
	}

	List<Position> findsPositionForKing(Direction direction) { //King 클래스에만 사용. 한 칸씩만 이동하면 되므로 반복문 사용할 필요 없고 보드 밖(좌표값이 -1인 영역)으로 나가지 않게 if문 사용해서 처리해야함
		ArrayList<Position> positions = new ArrayList<Position>();
		Position currentPosition = move(direction);
		if (currentPosition.isValid()) {
			positions.add(currentPosition);
		}
		return positions;
	}
	
	List<Position> findsPositionForBlackPawn(Position position) {
		ArrayList<Position> positions = new ArrayList<Position>();
		Position currentPosition = move(Direction.SOUTH);
		if (currentPosition.isValid()) {
			positions.add(currentPosition);
			if (position.getY() == 6) {
				positions.add(currentPosition.move(Direction.SOUTH));
			}
		}
		return positions;
	}
	
	List<Position> findsPositionForWhitePawn(Position position) {
		ArrayList<Position> positions = new ArrayList<Position>();
		Position currentPosition = move(Direction.NORTH);
		if (currentPosition.isValid()) {
			positions.add(currentPosition);
			if (position.getY() == 1) {
				positions.add(currentPosition.move(Direction.NORTH));
			}
		}
		return positions;
	}
	
	
	boolean isValid() {
		if ( y < 0 || y >= Board.ROW_SIZE) {
			return false;
		}

		if ( x < 0 || x >= Board.COLUMN_SIZE) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Position [x=" + x + ", y=" + y + "]";
	}



}
