import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class IsWonTests {

    @Test
    @FileParameters("src/test/test.csv")
    public void isIntegerParameterFromFileTest(int x1, int y1, char c1, int x2, int y2, char c2, int x3, int y3, char c3, int x4, int y4, char c4, boolean state) {
        ConnectFour connectFour = new ConnectFour();
        connectFour.board[x1][y1] = c1;
        connectFour.board[x2][y2] = c2;
        connectFour.board[x3][y3] = c3;
        connectFour.board[x4][y4] = c4;
        assertEquals(state, connectFour.isWon(x4, y4));
    }

}