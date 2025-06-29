package JunitTest.AAA;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
        System.out.println("Before: Calculator created");
    }

    @After
    public void tearDown() {
        calculator = null;
        System.out.println("After: Calculator reset");
    }

    @Test
    public void testAddition() {
        int a = 10;
        int b = 20;

        int result = calculator.add(a, b);

        assertEquals(30, result);
    }

    @Test
    public void testSubtraction() {
       
        int a = 50;
        int b = 30;

       
        int result = calculator.subtract(a, b);

      
        assertEquals(20, result);
    }
}

