import java.util.*;
import java.io.*;

/**
 * SOLUTION:
 *
 * So we have a graph(tree) and we are supposed to add the max no of edges
 * to it while still retaining it as bipartite graph.
 *
 * So basically if we can divide the vertex of the graph into two disjoint sets
 * then we can find the no of edges missing as we can simply find the
 * edges in a complete bipartite graph with that no of vertex and subtract the
 * edges that we currently have.
 */

public class MahmoudandEhabandthebipartiteness {
    InputStream is;
    PrintWriter out;
    String INPUT = "";
    ArrayList<ArrayList<Integer>> colors;

    void solve() throws IOException {
        int n = ni();
        ArrayList<ArrayList<Integer>> arrayLists= new ArrayList<>();
        for(int i=0;i<=n;i++)
            arrayLists.add(new ArrayList<>());

        for (int i = 1; i < n; i++) {
            int from= ni(), to= ni();
            arrayLists.get(from).add(to);
            arrayLists.get(to).add(from);
        }

        boolean[] visited= new boolean[n+1];
        colors.add(new ArrayList<>());
        colors.add(new ArrayList<>());

        DFSREC(arrayLists, visited, 1, 0);
        out.println((colors.get(0).size()*(long)colors.get(1).size()-n+1l));
        //out.println(colors);
    }

    private void DFSREC(ArrayList<ArrayList<Integer>> arrayLists, boolean[] visited, int curr, int color)
    {
        visited[curr]= true;
        colors.get(color).add(curr);

        for(Integer integer: arrayLists.get(curr))
        {
            if(visited[integer]) continue;

            DFSREC(arrayLists, visited, integer, (color==1?0:1));
        }
    }

    void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);
        colors= new ArrayList<>();

        solve();
        out.flush();
    }

    public static void main(String[] args) throws Exception {
        new MahmoudandEhabandthebipartiteness().run();
    }

    private byte[] inbuf = new byte[1024];
    public int lenbuf = 0, ptrbuf = 0;

    private int readByte() {
        if (lenbuf == -1) throw new InputMismatchException();
        if (ptrbuf >= lenbuf) {
            ptrbuf = 0;
            try {
                lenbuf = is.read(inbuf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (lenbuf <= 0) return -1;
        }
        return inbuf[ptrbuf++];
    }

    private boolean isSpaceChar(int c) {
        return !(c >= 33 && c <= 126);
    }

    private int skip() {
        int b;
        while ((b = readByte()) != -1 && isSpaceChar(b)) ;
        return b;
    }

    private double nd() {
        return Double.parseDouble(ns());
    }

    private char nc() {
        return (char) skip();
    }

    private String ns() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != ' ')
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    private char[] ns(int n) {
        char[] buf = new char[n];
        int b = skip(), p = 0;
        while (p < n && !(isSpaceChar(b))) {
            buf[p++] = (char) b;
            b = readByte();
        }
        return n == p ? buf : Arrays.copyOf(buf, p);
    }

    private char[][] nm(int n, int m) {
        char[][] map = new char[n][];
        for (int i = 0; i < n; i++) map[i] = ns(m);
        return map;
    }

    private int[] na(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = ni();
        return a;
    }

    private int ni() {
        int num = 0, b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
        if (b == '-') {
            minus = true;
            b = readByte();
        }

        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    private long nl() {
        long num = 0;
        int b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
        if (b == '-') {
            minus = true;
            b = readByte();
        }

        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    private void tr(Object... o) {
        if (INPUT.length() > 0) System.out.println(Arrays.deepToString(o));
    }
}

