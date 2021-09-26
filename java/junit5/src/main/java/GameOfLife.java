
public class GameOfLife {

	public static void main(String[] args) {
		Board board = new Board(5, 4);
		BoardPrinter boardPrinter = new BoardPrinter();
		String boardAsString = boardPrinter.print(board);
		System.out.println(boardAsString);
		
	}

}
