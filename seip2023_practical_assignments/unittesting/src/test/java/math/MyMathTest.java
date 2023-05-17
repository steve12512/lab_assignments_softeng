package math;

package math;

import org.junit.Assert;
import org.junit.Test;

public class MyMathTest {

    @Test
    public void testFactorial() {
        // Test case 1: n = 0
        int result1 = MyMath.factorial(0);
        Assert.assertEquals(1, result1);

        // Test case 2: n = 1
        int result2 = MyMath.factorial(1);
        Assert.assertEquals(1, result2);

        // Test case 3: n = 2
        int result3 = MyMath.factorial(2);
        Assert.assertEquals(2, result3);

        // Test case 4: n = 12
        int result4 = MyMath.factorial(12);
        Assert.assertEquals(479_001_600, result4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFactorialNegativeInput() {
        // Test case: n = -1 (negative input)
        MyMath.factorial(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFactorialLargeInput() {
        // Test case: n = 13 (input exceeding the limit)
        MyMath.factorial(13);
    }
}
