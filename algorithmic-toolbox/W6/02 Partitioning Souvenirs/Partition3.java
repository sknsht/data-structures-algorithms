import java.util.*;

public class Partition3 {
    private static int partition3(int[] A) {
        int sum = Arrays.stream(A).sum();
        if (sum == 0 || sum % 3 != 0)
            return 0;

        int n = A.length;
        int[][] tab = new int[sum / 3 + 1][n + 1];

        for (int i = 1; i <= sum / 3; i++) {
            for (int j = 1; j <= n; j++) {
                int diff = i - A[j - 1];
                if ((A[j - 1] == i) || (diff > 0 && tab[diff][j - 1] > 0)) {
                    tab[i][j] = (tab[i][j - 1] == 0) ? 1 : 2;
                } else {
                    tab[i][j] = tab[i][j - 1];
                }
            }
        }

        if (tab[sum / 3][n] == 2)
            return 1;
        else
            return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println(partition3(A));
    }
}