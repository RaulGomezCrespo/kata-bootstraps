import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardPrinterTest {

	@Test
	public void printEmptyBoard() {
		BoardPrinter printer = new BoardPrinter();
		Board board = new Board(5,4);
		String actualBoard = printer.print(board);
		assertEquals(".....\r\n" + 
				".....\r\n" + 
				".....\r\n" + 
				".....", actualBoard);
	}

	@Test
	public void printBoardWithSomeCellsAlive() {
		BoardPrinter printer = new BoardPrinter();
		Board board = new Board(5,4);
		board.setCellAtPosition(1, 1, CellState.ALIVE);
		String actualBoard = printer.print(board);
		assertEquals(".....\r\n" +
				".o...\r\n" +
				".....\r\n" +
				".....", actualBoard);
	}
}
