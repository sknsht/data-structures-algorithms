import java.util.*;

public class FibonacciSumLastDigit {
    private static final int PISANO_PERIOD_MOD10 = 60;

    private static int getFibonacciLastDigit(long n) {
        if (n < 1)
            return (int) n;

        int prev = 0;
        int curr = 1;
        for (long i = 2; i <= n; i++) {
            int next = (prev + curr) % 10;
            prev = curr;
            curr = next;
        }
        return curr % 10;
    }

    private static int getFibonacciSum(long n) {
        // Little trick:
        // Pisano period modulo 10 is 60
        // Sum of n Fibonacci numbers is F(n + 2) - 1
        int lastDigit = getFibonacciLastDigit((n + 2) % PISANO_PERIOD_MOD10);
        int sumLastDigit = (lastDigit == 0) ? 9 : (lastDigit - 1);
        return sumLastDigit;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSum(n);
        System.out.println(s);
    }
}