import java.util.*;
import java.io.*;

public class tree_orders {
    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public class TreeOrders {
        int n;
        int[] key, left, right;

        void read() throws IOException {
            FastScanner in = new FastScanner();
            n = in.nextInt();
            key = new int[n];
            left = new int[n];
            right = new int[n];
            for (int i = 0; i < n; i++) {
                key[i] = in.nextInt();
                left[i] = in.nextInt();
                right[i] = in.nextInt();
            }
        }

        ArrayList<Integer> result;

        List<Integer> inOrder() {
            result = new ArrayList<>();

            InOrderTraversal(0);

            return result;
        }

        private void InOrderTraversal(int node) {
            if (-1 == node) {
                return;
            }

            InOrderTraversal(left[node]);
            result.add(key[node]);
            InOrderTraversal(right[node]);
        }

        List<Integer> preOrder() {
            result = new ArrayList<>();

            PreOrderTraversal(0);

            return result;
        }

        private void PreOrderTraversal(int node) {
            if (-1 == node) {
                return;
            }

            result.add(key[node]);
            PreOrderTraversal(left[node]);
            PreOrderTraversal(right[node]);
        }

        List<Integer> postOrder() {
            result = new ArrayList<>();

            PostOrderTraversal(0);

            return result;
        }

        private void PostOrderTraversal(int node) {
            if (-1 == node) {
                return;
            }

            PostOrderTraversal(left[node]);
            PostOrderTraversal(right[node]);
            result.add(key[node]);
        }
    }

    static public void main(String[] args) throws IOException {
        new Thread(null, () -> {
            try {
                new tree_orders().run();
            } catch (IOException e) {
            }
        }, "1", 1 << 26).start();
    }

    public void print(List<Integer> x) {
        for (Integer a : x) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public void run() throws IOException {
        TreeOrders tree = new TreeOrders();
        tree.read();
        print(tree.inOrder());
        print(tree.preOrder());
        print(tree.postOrder());
    }
}
