import java.util.Random;

public class GameOfLife {

	public static void main(String[] args) throws InterruptedException {
		int maxGenerations = 100;
		Board board = new Board(20, 15);
		randomizeBoard(board);
		BoardPrinter boardPrinter = new BoardPrinter();

		for (int i = 0; i < maxGenerations; i++) {
			String boardAsString = boardPrinter.print(board);
			System.out.println(boardAsString);
			System.out.println("Generation: " + i);
			board = board.calculateNextGeneration();
			Thread.sleep(500);
		}
	}

	private static void randomizeBoard(Board board) {
		Random random = new Random();
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getColumns(); j++) {
				if (random.nextBoolean()) {
					board.setCellAtPosition(i, j, CellState.ALIVE);
				} else {
					board.setCellAtPosition(i, j, CellState.DEAD);
				}
			}
		}
	}
}
