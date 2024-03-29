import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import java.io.*;
import java.nio.ByteBuffer;

public class ConnectFourTests {
    private final ConnectFour connectFour = new ConnectFour();
    private final ConnectFour connectFour4x4 = new ConnectFour(4,4);
    private final ConnectFour connectFour3x3 = new ConnectFour(3,3);

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
        assertThat(baos.toString(), containsString("|_|_|_|_|_|_|_\n" +
                "|_|_|_|_|_|_|_\n" +
                "|_|_|_|_|_|_|_\n" +
                "|_|_|_|_|_|_|_\n" +
                "|_|_|_|_|_|_|_\n" +
                "|_|_|_|_|_|_|_\n" +
                "|=|=|=|=|=|=|=\n" +
                "|0|1|2|3|4|5|6\n"));
    }

    @Test
    void clearCustomBoardOutputTest() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);

        connectFour4x4.printBoard();
        assertThat(baos.toString(), containsString("|_|_|_|_\n" +
                "|_|_|_|_\n" +
                "|_|_|_|_\n" +
                "|_|_|_|_\n" +
                "|=|=|=|=\n" +
                "|0|1|2|3\n"));
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
        assertThat(baos.toString(), containsString("|X|X|X|X|X|X|X\n" +
                "|X|X|X|X|X|X|X\n" +
                "|X|X|X|X|X|X|X\n" +
                "|X|X|X|X|X|X|X\n" +
                "|X|X|X|X|X|X|X\n" +
                "|X|X|X|X|X|X|X\n" +
                "|=|=|=|=|=|=|=\n" +
                "|0|1|2|3|4|5|6\n"));
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
    void additionToEmptyColumnTest() throws IOException {
        connectFour.move(2,(char)88);
        assertThat(connectFour.board[5][2], equalTo((char)88));
    }

    @Test
    void additionToNotEmptyColumnTest() throws IOException {
        connectFour.move(2,(char)79);
        connectFour.move(2,(char)79);
        connectFour.move(2,(char)79);
        connectFour.move(2,(char)88);
        assertThat(connectFour.board[2][2], equalTo((char)88));
    }

    @Test
    void isWonHorizontalTest() throws IOException {
        connectFour.move(0,(char)79);
        connectFour.move(1,(char)79);
        connectFour.move(2,(char)79);
        connectFour.move(3,(char)79);
        assertTrue(connectFour.isWon(5,3));
    }

    @Test
    void isWonHorizontalFailureTest() {
        connectFour.board[5][0] = 88;
        connectFour.board[5][1] = 88;
        connectFour.board[5][2] = 88;
        connectFour.board[5][3] = 79;
        assertFalse(connectFour.isWon(5,2));
    }

    @Test
    void isWonVerticalTest() {
        connectFour.board[5][2] = 88;
        connectFour.board[4][2] = 88;
        connectFour.board[3][2] = 88;
        connectFour.board[2][2] = 88;
        assertTrue(connectFour.isWon(2,2));
    }

    @Test
    void isWonVerticalFailureTest() {
        connectFour.board[5][2] = 88;
        connectFour.board[4][2] = 79;
        connectFour.board[3][2] = 88;
        connectFour.board[2][2] = 88;
        assertFalse(connectFour.isWon(2,2));
    }

    @Test
    void isWonFirstDiagonalTest() {
        connectFour.board[2][1] = 88;
        connectFour.board[3][2] = 88;
        connectFour.board[4][3] = 88;
        connectFour.board[5][4] = 88;
        assertTrue(connectFour.isWon(3,2));
    }

    @Test
    void isWonFirstDiagonalFailureTest() {
        connectFour.board[2][1] = 88;
        connectFour.board[3][2] = 79;
        connectFour.board[4][3] = 88;
        connectFour.board[5][4] = 88;
        assertFalse(connectFour.isWon(3,2));
    }

    @Test
    void isWonSecondDiagonalTest() {
        connectFour.board[1][5] = 88;
        connectFour.board[2][4] = 88;
        connectFour.board[3][3] = 88;
        connectFour.board[4][2] = 88;
        assertTrue(connectFour.isWon(3,3));
    }

    @Test
    void isWonSecondDiagonalFailureTest() {
        connectFour.board[1][5] = 88;
        connectFour.board[2][4] = 79;
        connectFour.board[3][3] = 88;
        connectFour.board[4][2] = 88;
        assertFalse(connectFour.isWon(3,3));
    }

    @Test
    void horizontalTrueTest() {
        connectFour.board[5][0] = 88;
        connectFour.board[5][1] = 88;
        connectFour.board[5][2] = 88;
        connectFour.board[5][3] = 88;
        assertTrue(connectFour.horizontal(5,1, (char)88));
    }

    @Test
    void horizontalFalseTest() {
        connectFour.board[5][0] = 88;
        connectFour.board[5][1] = 88;
        connectFour.board[5][2] = 79;
        connectFour.board[5][3] = 88;
        assertFalse(connectFour.horizontal(5,1, (char)88));
    }

    @Test
    void gameIsTiedTest() throws IOException {
        connectFour3x3.move(0,(char)79);
        connectFour3x3.move(0,(char)88);
        connectFour3x3.move(0,(char)79);
        connectFour3x3.move(1,(char)88);
        connectFour3x3.move(1,(char)79);
        connectFour3x3.move(1,(char)88);
        connectFour3x3.move(2,(char)79);
        connectFour3x3.move(2,(char)88);
        connectFour3x3.move(2,(char)79);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);
        connectFour3x3.isTie();
        assertThat(baos.toString(), containsString("tie"));

    }

    @Test
    void gameIsNotTiedTest() throws IOException {
        connectFour3x3.move(0,(char)79);
        connectFour3x3.move(0,(char)88);
        connectFour3x3.move(0,(char)79);
        connectFour3x3.move(1,(char)88);
        connectFour3x3.move(1,(char)79);
        connectFour3x3.move(1,(char)88);
        connectFour3x3.move(2,(char)79);
        connectFour3x3.move(2,(char)88);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);
        connectFour3x3.isTie();
        assertThat(baos.toString(), not(containsString("tie")));

    }

    @Test
    void emptySpaceTest() {
        assertTrue(connectFour.emptySpace(1));
    }

    @Test
    void notEmptySpaceTest() {
        connectFour.board[0][1]=88;
        assertFalse(connectFour.emptySpace(1));
    }

    @Test
    void emptySpaceWithWrongColumnTest() {
        connectFour.board[0][1]=88;
        assertFalse(connectFour.emptySpace(10));
    }

    @Test
    void thrownExceptionOnStringTest() {
        connectFour.board[0][1]=88;
        ByteArrayInputStream in = new ByteArrayInputStream("My string".getBytes());
        System.setIn(in);
        assertThatThrownBy(ConnectFour::columnInput);
    }

    @Test
    void thrownExceptionOnEmptyStringTest() {
        connectFour.board[0][1]=88;
        ByteArrayInputStream in = new ByteArrayInputStream("".getBytes());
        System.setIn(in);
        assertThatThrownBy(ConnectFour::columnInput);
    }

    @Test
    void thrownExceptionOnTooLargeColumnNumberTest() {
        connectFour.board[0][1]=88;
        ByteArrayInputStream in = new ByteArrayInputStream(ByteBuffer.allocate(10).putInt(123).array());
        System.setIn(in);
        assertThatThrownBy(ConnectFour::columnInput);
    }

    @Test
    void isIntegerWithIntTest() {
        assertTrue(ConnectFour.isInteger("123"));
    }

    @Test
    void isIntegerWithStringTest() {
        assertFalse(ConnectFour.isInteger("string"));
    }

    @Test
    void isIntegerWithDoubleTest() {
        assertFalse(ConnectFour.isInteger("2.0"));
    }

    @Test
    void reverseTest() throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);
        connectFour.move(5,(char)88);
        connectFour.reverse();
        assertEquals(connectFour.board[5][5], 0);
    }

    @Test
    void notReversedTest() throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream("".getBytes());
        System.setIn(in);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);
        connectFour.move(5,(char)88);
        connectFour.reverse();
        assertEquals(connectFour.board[5][5], 88);
    }

    @Test
    void mxnRowsTest() throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        assertEquals(ConnectFour.mxn().boardRows, 6);
    }

    @Test
    void mxnColumnsTest() throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        assertEquals(ConnectFour.mxn().boardColumns, 7);
    }

}


