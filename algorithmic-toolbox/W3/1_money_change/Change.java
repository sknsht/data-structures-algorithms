import java.util.Scanner;

public class Change {
    private static int getChange(int money) {
        int[] denominations = {10, 5, 1};
        int minNumCoins = 0;

        for (int i = 0; money > 0; i++) {
            minNumCoins += money / denominations[i];
            money %= denominations[i];
        }
        return minNumCoins;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int money = scanner.nextInt();
        System.out.println(getChange(money));

    }
}

