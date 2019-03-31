import java.io.*;
import java.util.*;

public class JobQueue {
    private int numWorkers;
    private int[] jobs;

    private int[] assignedWorker;
    private long[] startTime;

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new JobQueue().solve();
    }

    private void readData() throws IOException {
        numWorkers = in.nextInt();
        int m = in.nextInt();
        jobs = new int[m];
        for (int i = 0; i < m; ++i) {
            jobs[i] = in.nextInt();
        }
    }

    private void writeResponse() {
        for (int i = 0; i < jobs.length; ++i) {
            out.println(assignedWorker[i] + " " + startTime[i]);
        }
    }

    private class Worker {
        private int id;
        private long nextFreeTime;

        private Worker(int id) {
            this.id = id;
            this.nextFreeTime = 0;
        }
    }

    private void assignJobs() {
        int n = jobs.length;
        assignedWorker = new int[n];
        startTime = new long[n];

        Queue<Worker> queue = new PriorityQueue<>(numWorkers,
                (w1, w2) -> {
                    if (w1.nextFreeTime == w2.nextFreeTime)
                        return w1.id - w2.id;
                    else
                        return (int) (w1.nextFreeTime - w2.nextFreeTime);
                });

        for (int i = 0; i < numWorkers; i++) {
            queue.offer(new Worker(i));
        }
        for (int i = 0; i < n; i++) {
            Worker worker = queue.poll();
            assignedWorker[i] = worker.id;
            startTime[i] = worker.nextFreeTime;
            worker.nextFreeTime += jobs[i];
            queue.offer(worker);
        }
    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        assignJobs();
        writeResponse();
        out.close();
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
