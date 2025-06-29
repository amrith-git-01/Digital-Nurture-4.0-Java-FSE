package JunitTest.Junit;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void testAddition() {
        int a = 2;
        int b = 3;
        int result = a + b;
        assertEquals("Addition result should be 5", 5, result);
    }
}

