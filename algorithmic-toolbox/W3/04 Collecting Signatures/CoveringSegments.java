import java.util.*;

public class CoveringSegments {

    public static List<Integer> optimalPoints(Segment[] segments) {
        Arrays.sort(segments, (o1, o2) -> Integer.compare(o1.end, o2.end));

        int point = -1;
        List<Integer> points = new ArrayList<>();
        for (Segment segment : segments) {
            if (!segment.isInSegment(point)) {
                point = segment.end;
                points.add(point);
            }
        }
        return points;
    }

    public static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }

        boolean isInSegment(int point) {
            return point >= start && point <= end;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        List<Integer> points = optimalPoints(segments);
        System.out.println(points.size());
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}