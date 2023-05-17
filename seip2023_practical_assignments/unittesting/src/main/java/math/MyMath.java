package math;

public class MyMath {
    
    public static int factorial(int n) {
        if (n < 0 || n > 12) {
            throw new IllegalArgumentException("Input should be between 0 and 12 (inclusive)");
        }
        
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        
        return result;
    }
}
