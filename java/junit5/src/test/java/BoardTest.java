import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

	@Test
	public void createBoard() {
		Board board = new Board(5, 4);
		assertEquals(5, board.getRows());
		assertEquals(4, board.getColumns());
	}

	@Test
	public void cellIsInitiallyAlive() {
		Board board = new Board(5, 4);
		Cell cell = board.getCellAtPosition(1, 1);
		assertEquals(CellState.ALIVE, cell.getState());
	}
}
