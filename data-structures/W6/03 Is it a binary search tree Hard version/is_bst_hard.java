import java.util.*;
import java.io.*;

public class is_bst_hard {
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

    public class IsBST {
        class Node {
            int key;
            int left;
            int right;

            Node(int key, int left, int right) {
                this.left = left;
                this.right = right;
                this.key = key;
            }
        }

        int nodes;
        Node[] tree;

        void read() throws IOException {
            FastScanner in = new FastScanner();
            nodes = in.nextInt();
            tree = new Node[nodes];
            for (int i = 0; i < nodes; i++) {
                tree[i] = new Node(in.nextInt(), in.nextInt(), in.nextInt());
            }
        }

        boolean isBinarySearchTree() {
            if (tree.length == 0)
                return true;
            return check(0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        boolean check(int idx, int min, int max) {
            if (idx == -1)
                return true;
            if (tree[idx].key < min || tree[idx].key >= max && max != Integer.MAX_VALUE)
                return false;
            return check(tree[idx].left, min, tree[idx].key) && check(tree[idx].right, tree[idx].key, max);
        }
    }

    static public void main(String[] args) {
        new Thread(null, () -> {
            try {
                new is_bst_hard().run();
            } catch (IOException e) {
            }
        }, "1", 1 << 26).start();
    }

    public void run() throws IOException {
        IsBST tree = new IsBST();
        tree.read();
        if (tree.isBinarySearchTree()) {
            System.out.println("CORRECT");
        } else {
            System.out.println("INCORRECT");
        }
    }
}
