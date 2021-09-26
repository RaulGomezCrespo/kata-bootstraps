import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class BoardPrinterTest {

	@Test
	public void printEmptyBoard() {
		BoardPrinter printer = new BoardPrinter();
		Board board = new Board(5,4);
		String actualBoard = printer.print(board );
		assertEquals(".....\r\n" + 
				".....\r\n" + 
				".....\r\n" + 
				".....", actualBoard );
	}
}
