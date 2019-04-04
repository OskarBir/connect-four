import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ConnectFourTests {
    private final ConnectFour connectFour = new ConnectFour();

    @Test
    void connectFourIsNotNull() {
        assertNotNull(connectFour);
    }

    @Test
    void defaultBoardColumns() {
        assertEquals(connectFour.boardColumns, 7);
    }

    @Test
    void defaultBoardRows() {
        assertEquals(connectFour.boardRows, 6);
    }

    @Test
    void testsIfPrintBoardReturnsNull() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);
        connectFour.printBoard();
        assertNotNull(baos.toString());

    }

    @Test
    void clearBoardOutputTest() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);

        connectFour.printBoard();

        assertEquals("|_|_|_|_|_|_|_\r\n" +
                "|_|_|_|_|_|_|_\r\n" +
                "|_|_|_|_|_|_|_\r\n" +
                "|_|_|_|_|_|_|_\r\n" +
                "|_|_|_|_|_|_|_\r\n" +
                "|_|_|_|_|_|_|_\r\n" +
                "|=|=|=|=|=|=|=\r\n" +
                "|0|1|2|3|4|5|6\r\n", baos.toString());
    }

    @Test
    void fullBoardOutputTest() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);
        for(int i=0; i<6; i++) {
            for(int j=0; j<7; j++) {
                connectFour.board[i][j] = 88;
            }
        }
        connectFour.printBoard();
        assertEquals("|X|X|X|X|X|X|X\r\n" +
                "|X|X|X|X|X|X|X\r\n" +
                "|X|X|X|X|X|X|X\r\n" +
                "|X|X|X|X|X|X|X\r\n" +
                "|X|X|X|X|X|X|X\r\n" +
                "|X|X|X|X|X|X|X\r\n" +
                "|=|=|=|=|=|=|=\r\n" +
                "|0|1|2|3|4|5|6\r\n", baos.toString());
    }

    @Test
    void emptyBoardArrayTest() {
        assertThat(connectFour.board, arrayWithSize(6));
    }

    @Test
    void fullBoardArrayTest() {
        for(int i=0; i<6; i++) {
            for(int j=0; j<7; j++) {
                connectFour.board[i][j] = 88;
            }
        }
        char[][] chars = {{88,88,88,88,88,88,88},{88,88,88,88,88,88,88},{88,88,88,88,88,88,88},{88,88,88,88,88,88,88},{88,88,88,88,88,88,88},{88,88,88,88,88,88,88}};
        assertArrayEquals(connectFour.board, chars);
    }
}


