package math;

import math.MyMath;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class FactorialTest {
    private int input;
    private int expectedOutput;

    public FactorialTest(int input, int expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, 1},
                {1, 1},
                {2, 2},
                {12, 479_001_600}
        });
    }

    @Test
    public void testFactorial() {
        Assert.assertEquals(expectedOutput, MyMath.factorial(input));
    }
}
