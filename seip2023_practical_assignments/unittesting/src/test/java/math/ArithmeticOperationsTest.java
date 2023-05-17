package math;

import org.junit.Test;
import org.junit.Assert;

/**
* The MathOperations provides simple arithmetic operations
* that serve as hands-on practice on Unit Testing.
*
* @author  steve12512
* @version 1.0
* @since   2023-05-16
*/


public class ArithmeticOperationsTest {
    



    @BeforeEach
    public static void  set_up() {
        ArithmeticOperations x = new ArithmeticOperations();
    }



    
    @Test
    public void test_divde_normal() {

        //test a normal division
        y = x.divide(10,2);
        Assertions.assertEquals(5,y);
    }



    @Test (expected = ArithmeticException.class)
    public void test_divide_zero() {

        //test what happens when dividing with 0
        try {
            x.divide(5, 0);
            Assertions.fail("Expected ArithmeticException to be thrown but didin't happen.");
        } catch (ArithmeticException e) {
            Assertions.assertEquals("Cannot divide with zero", e.getMessage());
        }
    }


    @Rule
    public ExpectedException ex = ExpectedException.none();



    @Test
    public void test_negative_multiplication() {
        
        // Test case 1: Valid multiplication
        int result1 = arithmeticOperations.multiply(5, 3);
        Assert.assertEquals(15, result1);

        // Test case 2: Negative input numbers
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("x & y should be >= 0");
        arithmeticOperations.multiply(-2, 4);

        // Test case 3: Product exceeding Integer.MAX_VALUE
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("The product does not fit in an Integer variable");
        arithmeticOperations.multiply(Integer.MAX_VALUE, 2);



    }


}
