import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
        int n = w.length;
        int[][] knapsack = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                knapsack[i][j] = knapsack[i - 1][j];
                if (w[i - 1] <= j) {
                    knapsack[i][j] = Math.max(knapsack[i - 1][j - w[i - 1]] + w[i - 1], knapsack[i][j]);
                }
            }
        }

        return knapsack[n][W];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}