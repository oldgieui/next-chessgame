package pieces;

import pieces.Piece.Color;
import junit.framework.TestCase;

public class PieceTest extends TestCase {
	public void testIsWhite() throws Exception {
		Piece whitePawn = new Pawn(Color.WHITE, null);
		assertTrue(whitePawn.isWhite());
	}

	public void testIsBlack() throws Exception {
		Piece blackPawn = new Pawn(Color.BLACK, null);
		assertTrue(blackPawn.isBlack());
	}
	
	public void testMove() throws Exception {
		Position source = new Position("a1");
		Position target = new Position("a2");
		Piece whitePawn = new Pawn(Color.WHITE, source);
		assertEquals(new Pawn(Color.WHITE, target), whitePawn.move(target));
	}
	
	/**
	 * Rook 이동 가능한 위치 확인하는 테스트 함수
	 * @throws Exception
	 */
	public void testMoveRook() throws Exception {
		Position source = new Position("a1");
		Position target = new Position("a2");
		Piece whiteRook = new Rook(Color.WHITE, source);
		assertTrue(whiteRook.getPossibleMoves().contains(target));
	}
	
	/**
	 * Bishop 이동 가능한 위치 확인하는 테스트 함수
	 * @throws Exception
	 */
	public void testMoveBishop() throws Exception {
		Position source = new Position("a1");
		Position target = new Position("b2");
		Piece whiteBishop = new Bishop(Color.WHITE, source);
		assertTrue(whiteBishop.getPossibleMoves().contains(target));
	}
	
	public void testLeave() throws Exception {
		Position source = new Position("a1");
		Piece whitePawn = new Pawn(Color.WHITE, source);
		assertEquals(new Empty(Color.NOCOLOR, source), whitePawn.leave());
	}
}
