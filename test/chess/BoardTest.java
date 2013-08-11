package chess;

import junit.framework.TestCase;
import pieces.Empty;
import pieces.Pawn;
import pieces.Piece;
import pieces.Piece.Color;
import pieces.Position;

public class BoardTest extends TestCase {
	private Board board;
	
	@Override
	protected void setUp() throws Exception {
		board = new Board();
	}
	
	public void testCreate() throws Exception {
		board.initialize();
		assertEquals(RankTest.WHITE_PAWN_RANK, board.generateRank(1));
		assertEquals(RankTest.BLACK_PAWN_RANK, board.generateRank(6));
	}
	
	public void testPrint() throws Exception {
		board.initialize();
		String expected = 
			RankTest.BLACK_EXCEPT_PAWN_RANK + Board.NEW_LINE +
			RankTest.BLACK_PAWN_RANK + Board.NEW_LINE +
			createEmptyRank() + 
			createEmptyRank() + 
			createEmptyRank() + 
			createEmptyRank() +
			RankTest.WHITE_PAWN_RANK + Board.NEW_LINE +
			RankTest.WHITE_EXCEPT_PAWN_RANK + Board.NEW_LINE;
		assertEquals(expected, board.generateBoard());
		System.out.println(board.generateBoard());
	}
	
	private String createEmptyRank() {
		return RankTest.EMPTY_RANK + Board.NEW_LINE;
	}
	
	public void testFindPiece() throws Exception {
		board.initialize();
		assertEquals('R', board.findPiece("a8").getSymbol());
		assertEquals('k', board.findPiece("e1").getSymbol());
	}
	
	public void testInitializeEmpty() throws Exception {
		board.initializeEmpty();
		System.out.println(board.generateBoard());
	}
	
	public void testMovePiece() throws Exception {
		board.initialize();
		Position source = new Position("a2");
		Piece sourcePiece = board.findPiece(source);
		assertEquals(new Pawn(Color.WHITE, source), sourcePiece);
		
		Position target = new Position("a3");
		board.movePiece(source, target);
		assertEquals(new Empty(Color.NOCOLOR, source), board.findPiece(source));
		assertEquals(new Pawn(Color.WHITE, target), board.findPiece(target));
		System.out.println(board.generateBoard());
	}

	/**
	 * 이동 목적지가 보드 바깥에 있는 경우 에러메시지가 출력되는 것을 확인하는 테스트
	 * 
	 * @throws Exception
	 */
	public void testMovePiece2() throws Exception {
		board.initialize();
		Position source = new Position("a2");
		Position target = new Position("a9");
		board.movePiece(source, target);
	}

	/**
	 * 소스의 위치에 말이 없을 경우 에러메시지가 출력되는 것을 확인하는 테스트
	 * 
	 * @throws Exception
	 */
	public void testMovePiece3() throws Exception {
		board.initialize();
		Position emptySource = new Position("a4");
		Piece emptySourcePiece = board.findPiece(emptySource);
		System.out.println("emptySourcePiece = " + emptySourcePiece);
		Position target = new Position("a5");
		board.movePiece(emptySource, target);
	}
	
	/**
	 * 타겟 위치에 자신의 말이 존재할 경우 에러메시지가 출력되는 것을 확인하는 테스트
	 * @throws Exception
	 */
	public void testMovePiece4() throws Exception {
		board.initialize();
		Position source = new Position("a1");
		Position target = new Position("a2");
		board.movePiece(source, target);
		System.out.println(board.generateBoard());
	}
	
	/**
	 * 타겟 위치가 이동 명령을 내린 말이 갈 수 있는 곳이 아니면 에러메시지가 출력되는 것을 확인하는 테스트
	 * @throws Exception
	 */
	public void testMovePiece5() throws Exception {
		board.initialize();
		Position source = new Position("c1");
		Position target = new Position("c5");
		board.movePiece(source, target);
		System.out.println(board.generateBoard());
		
	}
}
