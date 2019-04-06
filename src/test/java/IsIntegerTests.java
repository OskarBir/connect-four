import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class IsIntegerTests {
    @ParameterizedTest
    @CsvSource({
            "1,true",
            "2,true",
            "3.0, false",
            "string,false",
            "-1, true",
            ",false"
    })
    public void isIntegerTest(String input,Boolean expected) {
        assertEquals(expected, ConnectFour.isInteger(input));
    }
}