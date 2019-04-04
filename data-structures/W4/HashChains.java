import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class HashChains {

    private FastScanner in;
    private PrintWriter out;
    // store all strings in one list
    private ArrayList<ArrayList<String>> elems;
    // for hash function
    private int bucketCount;
    private int prime = 1000000007;
    private int multiplier = 263;

    public static void main(String[] args) throws IOException {
        new HashChains().processQueries();
    }

    private int hashFunction(String s) {
        long hash = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            hash = (hash * multiplier + s.charAt(i)) % prime;
        }
        return (int) hash % bucketCount;
    }

    private Query readQuery() throws IOException {
        String type = in.next();
        if (!type.equals("check")) {
            String s = in.next();
            return new Query(type, s);
        } else {
            int ind = in.nextInt();
            return new Query(type, ind);
        }
    }

    private void writeSearchResult(boolean wasFound) {
        out.println(wasFound ? "yes" : "no");
    }

    private void processQuery(Query query) {
        switch (query.type) {
            case "add":
                if (!elems.get(hashFunction(query.s)).contains(query.s)) {
                    elems.get(hashFunction(query.s)).add(0, query.s);
                }
                break;
            case "del":
                if (elems.get(hashFunction(query.s)).contains(query.s)) {
                    elems.get(hashFunction(query.s)).remove(query.s);
                }
                break;
            case "find":
                writeSearchResult(elems.get(hashFunction(query.s)).contains(query.s));
                break;
            case "check":
                for (String cur : elems.get(query.ind)) {
                    out.print(cur + " ");
                }
                out.println();
                break;
            default:
                throw new RuntimeException("Unknown query: " + query.type);
        }
    }

    public void processQueries() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        bucketCount = in.nextInt();
        int queryCount = in.nextInt();
        elems = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) {
            elems.add(new ArrayList<>());
        }
        for (int i = 0; i < queryCount; i++) {
            processQuery(readQuery());
        }
        out.close();
    }

    static class Query {
        String type;
        String s;
        int ind;

        public Query(String type, String s) {
            this.type = type;
            this.s = s;
        }

        public Query(String type, int ind) {
            this.type = type;
            this.ind = ind;
        }
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