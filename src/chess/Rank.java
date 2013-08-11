package chess;

import java.util.ArrayList;
import java.util.List;

import pieces.Bishop;
import pieces.Empty;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.PieceOperations;
import pieces.Piece.Color;
import pieces.Position;
import pieces.Queen;
import pieces.Rook;

public class Rank {
	private List<PieceOperations> rank = new ArrayList<PieceOperations>();
	
	private int rankPosition;
	
	Rank(int yPosition) {
		this.rankPosition = yPosition;
	}

	void initializeEmpty() {
		for (int i = 0; i < Board.COLUMN_SIZE; i++) {
			rank.add( new Empty(Color.NOCOLOR, new Position(i, rankPosition)) );
		}
	}
	
	void initializeWhitePawn() {
		for (int i = 0; i < Board.COLUMN_SIZE; i++) {
			rank.add(new Pawn(Color.WHITE, new Position(i, rankPosition)) );
		}
	}
	
	void initializeBlackPawn() {
		for (int i = 0; i < Board.COLUMN_SIZE; i++) {
			rank.add(new Pawn(Color.BLACK, new Position(i, rankPosition)) );
		}
	}
	
	void initializeWhiteExceptPawn() {
		rank.add(new Rook(Color.WHITE, new Position(0, rankPosition)) );
		rank.add(new Knight(Color.WHITE, new Position(1, rankPosition)) );
		rank.add(new Bishop(Color.WHITE, new Position(2, rankPosition)) );
		rank.add(new Queen(Color.WHITE, new Position(3, rankPosition)) );
		rank.add(new King(Color.WHITE, new Position(4, rankPosition)) );
		rank.add(new Bishop(Color.WHITE, new Position(5, rankPosition)) );
		rank.add(new Knight(Color.WHITE, new Position(6, rankPosition)) );
		rank.add(new Rook(Color.WHITE, new Position(7, rankPosition)) );
	}
	

	void initializeBlackExceptPawn() {
		rank.add(new Rook(Color.BLACK, new Position(0, rankPosition)) );
		rank.add(new Knight(Color.BLACK, new Position(1, rankPosition)) );
		rank.add(new Bishop(Color.BLACK, new Position(2, rankPosition)) );
		rank.add(new Queen(Color.BLACK, new Position(3, rankPosition)) );
		rank.add(new King(Color.BLACK, new Position(4, rankPosition)) );
		rank.add(new Bishop(Color.BLACK, new Position(5, rankPosition)) );
		rank.add(new Knight(Color.BLACK, new Position(6, rankPosition)) );
		rank.add(new Rook(Color.BLACK, new Position(7, rankPosition)) );
	}

	String generate() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Board.COLUMN_SIZE; i++) {
			sb.append(rank.get(i).getSymbol());
		}
		return sb.toString();
	}

	PieceOperations findPiece(Position position) {
		return rank.get(position.getX());
	}

	void changePiece(int xPosition, PieceOperations targetPiece) {
		rank.set(xPosition, targetPiece);
	}

	PieceOperations move(PieceOperations sourcePiece, Position target) {
		sourcePiece.move(target);
		rank.set(target.getX(), sourcePiece);
		return sourcePiece;
	}
}
