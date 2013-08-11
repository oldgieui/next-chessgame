package chess;

import java.util.ArrayList;
import java.util.List;

import pieces.PieceOperations;
import pieces.Position;

public class Board {
	public static final String NEW_LINE = System.getProperty("line.separator");
	public static final int ROW_SIZE = 8;
	public static final int COLUMN_SIZE = 8;
	
	static List<Rank> ranks = new ArrayList<Rank>();
	
	Board() {
	}

	void initialize() {
		for (int i = 0; i < ROW_SIZE; i++) {
			Rank rank = new Rank(i);
			if (i==0) {
				rank.initializeWhiteExceptPawn();
			} else if (i==1) {
				rank.initializeWhitePawn();
			} else if (i==6) {	
				rank.initializeBlackPawn();
			} else if (i==7) {
				rank.initializeBlackExceptPawn();
			} else {
				rank.initializeEmpty();
			}
			ranks.add(rank);
		}
	}
	
	void initializeEmpty() {
		for (int i = 0; i < ROW_SIZE; i++) {
			Rank rank = new Rank(i);
			rank.initializeEmpty();
			ranks.add(rank);
		}
	}

	PieceOperations findPiece(String xy) {
		Position position = new Position(xy);
		return findPiece(position);
	}

	PieceOperations findPiece(Position position) {
		Rank rank = ranks.get(position.getY());
		return rank.findPiece(position);
	}

	void movePiece(String source, String target) {
		movePiece(new Position(source), new Position(target));
	}

	/**
	 * 최우선 조건에서 원 위치가 빈 자리가 아님을 확인했으므로 소스와 타겟의 색이 같은지만 확인하면 됨. 
	 * 흰색이건 검은색이건 어느 한 쪽만 확인하면 Boolean 타입이므로 같은 결과값이 나왔을 때 같은 색. 따라서 두 값이 서로 다를 때만 옮길 수 있도록 한다.
	 * 최종적으로 원 위치의 심볼이 '.'이 아니면서 소스와 타겟의 색이 다른 경우에만 말을 옮기게 된다.
	 * 
	 * @param source
	 * @param target
	 */
	void movePiece(Position source, Position target) {
		if (findPiece(source).getSymbol() != '.') {
			if (target.isValid()) {
				if (findPiece(target).isWhite() != findPiece(source).isWhite()) {
					if (findPiece(source).getPossibleMoves2().contains(target)) {
						PieceOperations targetPiece = findPiece(source);
						PieceOperations sourcePiece = targetPiece.leave();

						Rank sourceRank = ranks.get(source.getY());
						sourceRank.move(sourcePiece, source);

						Rank targetRank = ranks.get(target.getY());
						targetRank.move(targetPiece, target);
					} else
						System.out.println(findPiece(source).getTypeName()
								+ " cannot go there.");
				} else
					System.out.println("Your another piece is there.");
			} else
				System.out.println("The target position is invaild.");
		} else
			System.out.println("There is no piece to move.");
	}

	
	
	String generateBoard(GenerateBoardInConsole consoleBoard){
		return consoleBoard.generateBoard();
	}
	
	String generateBoard(GenerateBoardInHtml htmlBoard){
		return htmlBoard.generateBoard();
	}

	String generateRank(GenerateBoardInConsole consoleBoard, int i) {
		return consoleBoard.generateRank(i);
	}
	
	String generateRank(GenerateBoardInHtml htmlBoard, int i) {
		return htmlBoard.generateRank(i);
	}
}
