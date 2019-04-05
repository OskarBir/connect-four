import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class isIntegerTests {
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "1", true }, { "2", true }, { "2.0", false }, { "3.0", false }, { "string", false }
        });
    }

    private String fInput;

    private Boolean fExpected;

    public isIntegerTests(String input, Boolean expected) {
        this.fInput = input;
        this.fExpected = expected;
    }

    @Test
    public void test() {
        ConnectFour c4 = new ConnectFour();
        assertEquals(fExpected, c4.isInteger(fInput));
    }
}