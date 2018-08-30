import java.util.Scanner;

public class PlacingParentheses {
    private static long getMaximValue(String exp) {
        int n = exp.length() / 2 + 1;
        int[][] min = new int[n][n];
        int[][] max = new int[n][n];

        for (int i = 0; i < n; i++) {
            min[i][i] = exp.charAt(i * 2) - '0';
            max[i][i] = exp.charAt(i * 2) - '0';
        }
        for (int size = 1; size <= n - 1; size++) {
            for (int i = 0; i <= n - 1 - size; i++) {
                int j = size + i;
                int[] minAndMax = getMinAndMax(exp, i, j, min, max);
                min[i][j] = minAndMax[0];
                max[i][j] = minAndMax[1];
            }
        }
        return max[0][n - 1];
    }

    private static int[] getMinAndMax(String exp, int i, int j, int[][] min, int[][] max) {
        int[] minAndMax = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};

        for (int k = i; k <= j - 1; k++) {
            char op = exp.charAt(k * 2 + 1);

            int a = eval(min[i][k], min[k + 1][j], op);
            int b = eval(min[i][k], max[k + 1][j], op);
            int c = eval(max[i][k], min[k + 1][j], op);
            int d = eval(max[i][k], max[k + 1][j], op);

            minAndMax[0] = Math.min(a, Math.min(b, Math.min(c, Math.min(d, minAndMax[0]))));
            minAndMax[1] = Math.max(a, Math.max(b, Math.max(c, Math.max(d, minAndMax[1]))));
        }
        return minAndMax;
    }

    private static int eval(int a, int b, int op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}