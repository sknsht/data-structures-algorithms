import java.util.*;

public class LCS3 {

    private static int lcs3(int[] a, int[] b, int[] c) {
        int n = a.length;
        int m = b.length;
        int l = c.length;
        int[][][] lcs = new int[n + 1][m + 1][l + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 1; k <= l; k++) {
                    if ((a[i - 1] == b[j - 1]) && (b[j - 1] == c[k - 1])) {
                        lcs[i][j][k] = lcs[i - 1][j - 1][k - 1] + 1;
                    } else {
                        lcs[i][j][k] = Math.max(lcs[i][j][k - 1], Math.max(lcs[i - 1][j][k], lcs[i][j - 1][k]));
                    }
                }
            }
        }
        return lcs[n][m][l];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int an = scanner.nextInt();
        int[] a = new int[an];
        for (int i = 0; i < an; i++) {
            a[i] = scanner.nextInt();
        }
        int bn = scanner.nextInt();
        int[] b = new int[bn];
        for (int i = 0; i < bn; i++) {
            b[i] = scanner.nextInt();
        }
        int cn = scanner.nextInt();
        int[] c = new int[cn];
        for (int i = 0; i < cn; i++) {
            c[i] = scanner.nextInt();
        }
        System.out.println(lcs3(a, b, c));
    }
}