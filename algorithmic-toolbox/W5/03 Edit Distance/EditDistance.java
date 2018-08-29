import java.util.*;

class EditDistance {
    public static int EditDistance(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] alignment = new int[n + 1][m + 1];

        for (int j = 1; j <= m; j++) {
            alignment[0][j] = j;
        }
        for (int i = 1; i <= n; i++) {
            alignment[i][0] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int insertion = alignment[i][j - 1] + 1;
                int deletion = alignment[i - 1][j] + 1;
                int substitution = alignment[i - 1][j - 1] + (s.charAt(i - 1) == t.charAt(j - 1) ? 0 : 1);
                alignment[i][j] = Math.min(insertion, Math.min(deletion, substitution));
            }
        }
        return alignment[n][m];
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        String s = scan.next();
        String t = scan.next();

        System.out.println(EditDistance(s, t));
    }
}
