import java.util.*;

public class Inversions {

    private static long getNumberOfInversions(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    public static long mergeSort(int[] arr, int start, int end) {
        if (start == end)
            return 0;

        long count = 0;
        int mid = (start + end) / 2;

        count += mergeSort(arr, start, mid); //left inversions
        count += mergeSort(arr, mid + 1, end); //right inversions
        count += merge(arr, start, end); //split inversions

        return count;
    }

    public static long merge(int[] arr, int start, int end) {
        long count = 0;
        int mid = (start + end) / 2;

        int curr = 0;
        int i = start;
        int j = mid + 1;

        int[] newArr = new int[end - start + 1];

        while (i <= mid && j <= end) {
            if (arr[i] > arr[j]) {
                newArr[curr++] = arr[j++];
                count += mid - i + 1;
            } else {
                newArr[curr++] = arr[i++];
            }
        }

        while (i <= mid) {
            newArr[curr++] = arr[i++];
        }

        while (j <= end) {
            newArr[curr++] = arr[j++];
        }

        System.arraycopy(newArr, 0, arr, start, end - start + 1);
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(getNumberOfInversions(a));
    }
}