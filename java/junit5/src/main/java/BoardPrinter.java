
public class BoardPrinter {

	public String print(Board board) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < board.getColumns(); i++) {
			for (int j = 0; j < board.getRows(); j++) {
				sb.append(".");
			}
			if (i + 1 != board.getColumns()) {
				sb.append("\r\n");
			}
		}
		return sb.toString();
	}
}
