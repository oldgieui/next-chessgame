package pieces;

import java.util.List;

import pieces.Piece.Color;
import junit.framework.TestCase;

public class PositionControllerTest extends TestCase {
	public void testFindsLinearPositionAll() throws Exception {
		int startX = 4;
		int startY = 5;
		Position position = new Position(startX, startY);

		PositionController controller = new PositionController(position);
		List<Position> positions = controller.findsLinearPositionAll();
		assertEquals(14, positions.size());
	}

	public void testFindsDiagonalPositionAll() throws Exception {
		int startX = 4;
		int startY = 5;
		Position position = new Position(startX, startY);

		PositionController controller = new PositionController(position);
		List<Position> positions = controller.findsDiagonalPositionAll();
		assertEquals(11, positions.size());
	}
	
	/**
	 * Rook 이동 가능한 위치 확인하는 테스트 함수
	 * 
	 * @throws Exception
	 */
	public void testMoveRook() throws Exception {
		Position source = new Position("a1");
		Position target = new Position("a2");
		Piece whiteRook = new Rook(Color.WHITE, source);
		assertTrue(whiteRook.getPossibleMoves().contains(target));
		// System.out.println(whiteRook.getPossibleMoves());
	}

	/**
	 * Bishop 이동 가능한 위치 확인하는 테스트 함수
	 * 
	 * @throws Exception
	 */
	public void testMoveBishop() throws Exception {
		Position source = new Position("a1");
		Position target = new Position("b2");
		Piece whiteBishop = new Bishop(Color.WHITE, source);
		assertTrue(whiteBishop.getPossibleMoves().contains(target));
		// System.out.println(whiteBishop.getPossibleMoves());
	}

	/**
	 * Queen 이동 가능한 위치 확인하는 테스트 함수
	 * 
	 * @throws Exception
	 */
	public void testMoveQueen() throws Exception {
		Position source = new Position("a1");
		Position target = new Position("a2");
		Piece whiteQueen = new Queen(Color.WHITE, source);
		assertTrue(whiteQueen.getPossibleMoves().contains(target));
		// System.out.println(whiteQueen.getPossibleMoves());
		target = new Position("b2");
		// target.setNewPosition("b2"); - 인스턴스를 새로 만드는 것과 setter 메소드를 만드는 것의 차이.
		// 테스트코드만을 위한 메소드를 만들어 사용하는 것은 본말전도
		assertTrue(whiteQueen.getPossibleMoves().contains(target));
		// System.out.println(whiteQueen.getPossibleMoves());
	}

	public void testMoveKing() throws Exception {
		Position source = new Position("a1");
		Position target = new Position("b2");
		Piece whiteKing = new King(Color.WHITE, source);
		assertTrue(whiteKing.getPossibleMoves().contains(target));
		System.out.println(whiteKing.getPossibleMoves());
	}

	public void testMovePawn() throws Exception {
		Position whiteSource = new Position("b1");
		Position whiteTarget = new Position("b2");
		Position blackSource = new Position("g7");
		Position blackTarget = new Position("g5");
		Piece whitePawn = new Pawn(Color.WHITE, whiteSource);
		Piece blackPawn = new Pawn(Color.BLACK, blackSource);
		System.out.println("whitePawn now : " + whitePawn.position);
		System.out.println("blackPawn now : " + blackPawn.position);
		System.out.println("whitePawn can go to : "
				+ whitePawn.getPossibleMoves());
		System.out.println("blackPawn can go to : "
				+ blackPawn.getPossibleMoves());
		assertTrue(whitePawn.getPossibleMoves().contains(whiteTarget));
		assertTrue(blackPawn.getPossibleMoves().contains(blackTarget));
	}
	
	public void testMoveKnight() throws Exception {
		Position source = new Position("e5");
		Piece whiteKnight = new Knight(Color.WHITE, source);
		System.out.println("whiteKnight now : "+ whiteKnight.position);
		System.out.println("whiteKnight can go to : "+ whiteKnight.getPossibleMoves());
	}
}
