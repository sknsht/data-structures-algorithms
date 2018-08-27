import java.util.Arrays;
import java.util.Scanner;

public class ChangeDP {
    private static int getMinimumChange(int m) {
        int[] denominations = {1, 3, 4};

        int[] minNumCoins = new int[m + 1];
        Arrays.fill(minNumCoins, 1, m + 1, Integer.MAX_VALUE);

        for (int i = 1; i <= m; i++) {
            for (int d : denominations) {
                if (i >= d) {
                    minNumCoins[i] = Math.min(minNumCoins[i], minNumCoins[i - d] + 1);
                }
            }
        }
        return minNumCoins[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int money = scanner.nextInt();
        System.out.println(getMinimumChange(money));
    }
}