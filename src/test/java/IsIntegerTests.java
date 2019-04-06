import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class IsIntegerTests {
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"1", true}, {"2", true}, {"2.0", false}, {"3.0", false}, {"string", false}, {"-1", true}, {"", false}
        });
    }

    private String fInput;

    private Boolean fExpected;

    public IsIntegerTests(String input, Boolean expected) {
        this.fInput = input;
        this.fExpected = expected;
    }

    @Test
    public void test() {
        assertEquals(fExpected, ConnectFour.isInteger(fInput));
    }
}