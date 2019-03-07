import java.util.*;
import java.io.*;

public class TreeHeight {
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

    public class Tree {
        int n;
        int parent[];
        int heights[];

        void read() throws IOException {
            FastScanner in = new FastScanner();
            n = in.nextInt();
            heights = new int[n];
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = in.nextInt();
            }
        }

        int computeHeight() {
            int maxHeight = 0;

            for (int vertex = 0; vertex < n; vertex++) {
                int height = (heights[vertex] == 0) ?
                        getHeight(vertex) : heights[vertex];
                maxHeight = Math.max(maxHeight, height);
            }

            return maxHeight;
        }

        int getHeight(int i) {
            if (heights[i] == 0) {
                int parent = this.parent[i];

                if (parent == -1) {
                    heights[i] = 1;
                } else {
                    heights[i] = 1 + getHeight(parent);
                }
            }
            return heights[i];
        }
    }

    static public void main(String[] args) throws IOException {
        new Thread(null, () -> {
            try {
                new TreeHeight().run();
            } catch (IOException e) {
            }
        }, "1", 1 << 26).start();
    }

    public void run() throws IOException {
        Tree tree = new Tree();
        tree.read();
        System.out.println(tree.computeHeight());
    }
}
