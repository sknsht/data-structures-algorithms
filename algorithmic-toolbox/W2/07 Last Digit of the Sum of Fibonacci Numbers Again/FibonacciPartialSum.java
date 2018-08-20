import java.util.*;

public class FibonacciPartialSum {
    private static final int PISANO_PERIOD_MOD10 = 60;

    private static int getFibonacciLastDigit(long n) {
        if (n <= 1)
            return (int) n;

        int prev = 0;
        int curr = 1;
        for (int i = 2; i <= n; i++) {
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
        int sumLastDigit = getLastDigitAfterSubtraction(lastDigit, 1);
        return sumLastDigit;
    }

    private static int getFibonacciPartialSum(long from, long to) {
        int fibonacciPartialSum = getLastDigitAfterSubtraction(getFibonacciSum(to), getFibonacciSum(from - 1));
        return fibonacciPartialSum;
    }

    private static int getLastDigitAfterSubtraction(int lastDigitMinuend, int lastDigitSubtrahend) {
        if (lastDigitMinuend < lastDigitSubtrahend)
            lastDigitMinuend = lastDigitMinuend + 10;
        return lastDigitMinuend - lastDigitSubtrahend;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSum(from, to));
    }
}
