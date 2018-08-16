import java.util.Scanner;

public class FibonacciLastDigit {
    private static long getFibonacciLastDigit(int n) {
        if (n <= 1)
            return n;

        long prev = 0;
        long curr = 1;
        for (int i = 2; i <= n; i++) {
            long next = (prev + curr) % 10;
            prev = curr;
            curr = next;
        }
        return curr % 10;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(getFibonacciLastDigit(n));
    }
}
