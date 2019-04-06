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
            "-10.0, false",
            "-1, true",
            "3.14F, false",
            "-3.14F, false",
            "0, true",
            ",false",
            "-1000, true",
            "true, false",
            "false, false",
            "null, false",
    })
    public void isIntegerTest(String input,Boolean expected) {
        assertEquals(expected, ConnectFour.isInteger(input));
    }
}