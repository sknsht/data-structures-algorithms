import java.util.Scanner;

public class Fibonacci {
    private static long calcFibonacci(int n) {
        if (n < 1)
            return n;
        
        long prev = 0;
        long curr = 1;
        for (int i = 2; i <= n; i++) {
            long next = prev + curr;
            prev = curr;
            curr = next;
        }
        return curr;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(calcFibonacci(n));
    }
}
