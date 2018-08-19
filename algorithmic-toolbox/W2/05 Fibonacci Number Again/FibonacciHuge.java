import java.util.*;

public class FibonacciHuge {
    private static long pisanoPeriod(long mod) {
        long prev = 0;
        long curr = 1;

        long pisanoPeriod = 0;
        for (int i = 0; i < mod * mod; i++) {
            long next = (prev + curr) % mod;
            prev = curr;
            curr = next;
            if (prev == 0 && curr == 1) {
                pisanoPeriod = i + 1;
                break;
            }
        }
        return pisanoPeriod;
    }

    private static long getFibonacciHuge(long number, long mod) {
        long remainder = number % pisanoPeriod(mod);
        if (remainder < 1)
            return remainder;

        long prev = 0;
        long curr = 1;

        for (int i = 1; i < remainder; i++) {
            long next = (prev + curr) % mod;
            prev = curr;
            curr = next;
        }
        return curr % mod;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHuge(n, m));
    }
}