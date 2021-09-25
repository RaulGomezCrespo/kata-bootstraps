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
	public void cellIsInitiallyDead() {
		Board board = new Board(5, 4);
		Cell cell = board.getCellAtPosition(1, 1);
		assertEquals(CellState.DEAD, cell.getState());
	}
	
	@Test
	public void setCellAlive() {
		Board board = new Board(5, 4);
		board.setCellAtPosition(1,1, CellState.ALIVE);
		Cell cell = board.getCellAtPosition(1, 1);
		assertEquals(CellState.ALIVE, cell.getState());
	}
	
	@Test
	public void cellWithLessThanTwoNeighboursDies() {
		Board board = new Board(5, 4);
		board.setCellAtPosition(1,1, CellState.ALIVE);
		Board nextGeneration = board.calculateNextGeneration();
		Cell cell = nextGeneration.getCellAtPosition(1, 1);
		assertEquals(CellState.DEAD, cell.getState());
	}
	
	@Test
	public void cellWithTwoNeighboursSurvives() {
		Board board = new Board(5, 4);
		board.setCellAtPosition(1,1, CellState.ALIVE);
		board.setCellAtPosition(0,1, CellState.ALIVE);
		board.setCellAtPosition(1,0, CellState.ALIVE);
		Board nextGeneration = board.calculateNextGeneration();
		Cell cell = nextGeneration.getCellAtPosition(1, 1);
		assertEquals(CellState.ALIVE, cell.getState());
	}

	@Test
	public void cellWithThreeNeighboursSurvives() {
		// given
		Board board = new Board(5, 4);
		board.setCellAtPosition(1,1, CellState.ALIVE);
		board.setCellAtPosition(0,1, CellState.ALIVE);
		board.setCellAtPosition(1,0, CellState.ALIVE);
		board.setCellAtPosition(1,2, CellState.ALIVE);

		// when
		Board nextGeneration = board.calculateNextGeneration();

		// then
		Cell cell = nextGeneration.getCellAtPosition(1, 1);
		assertEquals(CellState.ALIVE, cell.getState());
	}
}
