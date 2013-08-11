package chess;

public class GenerateBoardInConsole implements GenerateBoard {
	
	@Override
	public String generateRank(int rankIndex) {
		Rank rank = Board.ranks.get(rankIndex);
		StringBuilder sb = new StringBuilder();
		sb.append(rank.generate());
		return sb.toString();
	}
	
	@Override
	public String generateBoard() {
		StringBuilder sb = new StringBuilder();
		for (int i = Board.ROW_SIZE; i > 0; i--) {
			sb.append(generateRank(i-1) + Board.NEW_LINE);
		}
		return sb.toString();
	}

}
