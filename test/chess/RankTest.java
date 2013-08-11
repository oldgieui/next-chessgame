package chess;

import junit.framework.TestCase;
import pieces.King;
import pieces.Pawn;
import pieces.PieceOperations;
import pieces.Piece.Color;
import pieces.Position;
import pieces.Queen;

public class RankTest extends TestCase {
	static final String EMPTY_RANK = "........";
	static final String WHITE_EXCEPT_PAWN_RANK = "rnbqkbnr";
	static final String BLACK_EXCEPT_PAWN_RANK = "RNBQKBNR";
	static final String WHITE_PAWN_RANK = "pppppppp";
	static final String BLACK_PAWN_RANK = "PPPPPPPP";
	
	private Rank rank;
	
	@Override
	protected void setUp() throws Exception {
		rank = new Rank(0);
	}
	
	public void testInitializeEmpty() throws Exception {
		rank.initializeEmpty();
		assertEquals(EMPTY_RANK, rank.generate());
	}
	
	public void testInitializeWhitePawn() throws Exception {
		rank.initializeWhitePawn();
		assertEquals(WHITE_PAWN_RANK, rank.generate());
	}
	
	
	public void testInitializeBlackPawn() throws Exception {
		rank.initializeBlackPawn();
		assertEquals(BLACK_PAWN_RANK, rank.generate());
	}
	
	public void testInitializeWhiteExceptPawn() throws Exception {
		rank.initializeWhiteExceptPawn();
		assertEquals(WHITE_EXCEPT_PAWN_RANK, rank.generate());
	}
	
	public void testInitializeBlackExceptPawn() throws Exception {
		rank.initializeBlackExceptPawn();
		assertEquals(BLACK_EXCEPT_PAWN_RANK, rank.generate());
	}
	
	public void testFindPiece() throws Exception {
		rank.initializeWhiteExceptPawn();
		Position position = new Position("d1");
		assertEquals(new Queen(Color.WHITE, position), rank.findPiece(position));
		
		position = new Position("e1");
		assertEquals(new King(Color.WHITE, position), rank.findPiece(position));
	}
	
	public void testMove() throws Exception {
		rank = new Rank(1);
		rank.initializeWhitePawn();
		Position source = new Position("d2");
		Position target = new Position("d3");
		
		PieceOperations sourcePiece = rank.findPiece(source);
		assertEquals(new Pawn(Color.WHITE, source), sourcePiece);
		
		PieceOperations targetPiece = rank.move(sourcePiece, target);
		assertEquals(new Pawn(Color.WHITE, target), targetPiece);
	}
}
