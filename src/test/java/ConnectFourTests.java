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
    private final ConnectFour connectFour4x4 = new ConnectFour(4,4,0);

    @Test
    void connectFourIsNotNull() {
        assertNotNull(connectFour);
    }

    @Test
    void defaultBoardColumns() {
        assertEquals( 7,connectFour.boardColumns);
    }

    @Test
    void defaultBoardRows() {
        assertEquals(6,connectFour.boardRows);
    }

    @Test
    void customConnectFourIsNotNull() {
        assertNotNull(connectFour4x4);
    }

    @Test
    void customBoardColumns() {
        assertEquals( 4, connectFour4x4.boardColumns);
    }

    @Test
    void customBoardRows() {
        assertEquals(4,connectFour4x4.boardRows);
    }

    @Test
    void printBoardReturnsNotNull() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);
        connectFour.printBoard();
        assertNotNull(baos.toString());
    }

    @Test
    void clearDefaultBoardOutputTest() {
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
    void clearCustomBoardOutputTest() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);

        connectFour4x4.printBoard();

        assertEquals("|_|_|_|_\r\n" +
                "|_|_|_|_\r\n" +
                "|_|_|_|_\r\n" +
                "|_|_|_|_\r\n" +
                "|=|=|=|=\r\n" +
                "|0|1|2|3\r\n", baos.toString());
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

    @Test
    void additionToEmptyColumnTest() {
        connectFour.move(2,(char)88);
        assertThat(connectFour.board[5][2], equalTo((char)88));
    }

    @Test
    void additionToNotEmptyColumnTest() {
        connectFour.move(2,(char)79);
        connectFour.move(2,(char)79);
        connectFour.move(2,(char)79);
        connectFour.move(2,(char)88);
        assertThat(connectFour.board[2][2], equalTo((char)88));
    }
}


