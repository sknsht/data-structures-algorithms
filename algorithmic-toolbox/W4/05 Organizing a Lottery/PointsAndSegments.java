import java.util.Arrays;
import java.util.Scanner;

public class PointsAndSegments {

    private static int[] countSegments(int[] starts, int[] ends, int[] points) {
        int[] count = new int[points.length];

        Arrays.sort(starts);
        Arrays.sort(ends);

        for (int i = 0; i < points.length; i++) {
            int x, y;
            for (x = 0; x < starts.length; x++) {
                if (starts[x] > points[i]) {
                    break;
                }
            }

            for (y = 0; y < ends.length; y++) {
                if (ends[y] >= points[i]) {
                    break;
                }
            }
            count[i] = x - y;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        int[] cnt = countSegments(starts, ends, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }
    }
}