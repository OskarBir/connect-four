import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

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
}


