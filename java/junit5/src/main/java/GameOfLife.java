import java.util.Random;
import java.util.Scanner;

public class GameOfLife {

	public static void main(String[] args) {
		int maxGenerations = 10;
		Board board = new Board(5, 4);
		randomizeBoard(board);
		BoardPrinter boardPrinter = new BoardPrinter();

		for (int i = 0; i < maxGenerations; i++) {
			String boardAsString = boardPrinter.print(board);
			System.out.println(boardAsString);
			System.out.println("Generation: " + i);
			board = board.calculateNextGeneration();
			waitForAnyKey();
		}
	}

	private static void waitForAnyKey() {
		System.out.println("Press any key to continue...");
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
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
