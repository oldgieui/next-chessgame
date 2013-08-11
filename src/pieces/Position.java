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
	
	/**
	 * Knight의 현재 위치, 십자방향, 사선방향을 입력받음.
	 * 십자방향으로 1회 이동한 뒤 사선방향으로 1회 이동하고 그 위치가 존재하면 이동가능으로 표시. 
	 * 하지만 모든 방향에 대해 위 작업을 실행하면 원래 위치의 바로 인접한 칸도 이동가능한 위치에 포함되는 문제가 발생함.
	 * 따라서 해당 위치를 제외하기 위해 X좌표값의 차이가 1이고 Y좌표값이 같거나 Y좌표값의 차이가 1이고 X좌표값이 같은 경우를 제외하고 동작하도록 조건문을 사용해야 한다.
	 * @param position
	 * @param linearDirection
	 * @param diagonalDirection
	 * @return
	 */
	List<Position> findsPositionForKnight(Position position, Direction linearDirection, Direction diagonalDirection) {
		ArrayList <Position> positions = new ArrayList<Position>();
		Position currentPosition = move(linearDirection).move(diagonalDirection);
		int differenceX = Math.abs(currentPosition.getX() - position.getX());
		int differenceY = Math.abs(currentPosition.getY() - position.getY());
		boolean isSameX = (currentPosition.getX()==position.getX());
		boolean isSameY = (currentPosition.getY()==position.getY());
		
		if (currentPosition.isValid()) {
			if (!(differenceX == 1 && isSameY || differenceY == 1 && isSameX)) {
				positions.add(currentPosition);
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
