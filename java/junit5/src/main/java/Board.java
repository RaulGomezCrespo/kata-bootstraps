public class Board {

	private CellState[][] states;

	public Board(int rows, int columns) {
		this.states = new CellState[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				this.states[i][j] = CellState.DEAD;
			}
		}
	}

	public int getRows() {
		return states.length;
	}

	public int getColumns() {
		return states[0].length;
	}

	public Cell getCellAtPosition(int x, int y) {
		return new Cell(states[x][y]);
	}

	public void setCellAtPosition(int x, int y, CellState state) {
		states[x][y] = state;
	}

	public Board calculateNextGeneration() {
		Board nextGeneration = new Board(getRows(), getColumns());
		for (int i = 0; i < getRows(); i++) {
			for (int j = 0; j < getColumns(); j++) {
				nextGeneration.setCellAtPosition(i, j, calculateCellStateInNextGeneration(i, j));
			}
		}
		return nextGeneration;
	}

	private CellState calculateCellStateInNextGeneration(int x, int y) {
		int aliveNeighbours = numberOfAliveNeighbours(x, y);
		boolean currentCellIsAlive = getCellAtPosition(x, y).getState() == CellState.ALIVE;
		if ((currentCellIsAlive  && aliveNeighbours == 2) || aliveNeighbours == 3) {
			return CellState.ALIVE;
		}
		return CellState.DEAD;
	}

	private int numberOfAliveNeighbours(int x, int y) {
		// X X X
		// X O X
		// X X X
		int aliveNeighbours = 0;
		
		if(x - 1 >= 0 && y - 1 >= 0 && getCellAtPosition(x - 1, y - 1).getState() == CellState.ALIVE) {
			aliveNeighbours++;
		}
		
		if(y - 1 >= 0 && getCellAtPosition(x, y - 1).getState() == CellState.ALIVE) {
			aliveNeighbours++;
		}
		
		if(x + 1 < getRows() && y - 1 >= 0 && getCellAtPosition(x + 1, y - 1).getState() == CellState.ALIVE) {
			aliveNeighbours++;
		}
		
		if(x - 1 >= 0 && getCellAtPosition(x - 1, y).getState() == CellState.ALIVE) {
			aliveNeighbours++;
		}
		
		if(x + 1 < getRows() && getCellAtPosition(x + 1, y).getState() == CellState.ALIVE) {
			aliveNeighbours++;
		}
		
		if(y + 1 < getColumns() && x - 1 >= 0 && getCellAtPosition(x - 1, y + 1).getState() == CellState.ALIVE) {
			aliveNeighbours++;
		}
		
		if(y + 1 < getColumns() && getCellAtPosition(x, y + 1).getState() == CellState.ALIVE) {
			aliveNeighbours++;
		}
		
		if(x + 1 < getRows() && y + 1 < getColumns() && getCellAtPosition(x + 1, y + 1).getState() == CellState.ALIVE) {
			aliveNeighbours++;
		}
		
		return aliveNeighbours;
	}
}
