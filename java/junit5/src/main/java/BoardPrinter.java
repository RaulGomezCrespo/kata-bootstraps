
public class BoardPrinter {

	public String print(Board board) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < board.getColumns(); i++) {
			for (int j = 0; j < board.getRows(); j++) {
				if(board.isCellAtPositionAlive(i, j)) {
					sb.append("o");
				} else {
					sb.append(".");
				}
				
			}
			if (i + 1 != board.getColumns()) {
				sb.append("\r\n");
			}
		}
		return sb.toString();
	}
}
