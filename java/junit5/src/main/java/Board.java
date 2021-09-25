
public class Board {

	private int rows;
	private int columns;

	public Board(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public Cell getCellAtPosition(int x, int y) {
		return new Cell(CellState.ALIVE);
	}
}
