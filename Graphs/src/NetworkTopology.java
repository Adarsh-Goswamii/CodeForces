import java.util.*;
import java.io.*;

/**
 * SOLUTION:
 *
 * n computers {1...n}
 * non- directed graph
 *
 * So this is easy all we have to do is just find the in-degree(degree as
 * undirected) of all the nodes
 * and depending on the value we can find which kind of topology is formed by
 * the graph.
 *
 * If all nodes have 2 in-degree and only two have 1 = BUS
 * If all the nodes have 2 in-degree with no exception = RING
 * If all the nodes have 1  in-degree and one has n-1 = STAR
 */

public class NetworkTopology {
    InputStream is;
    PrintWriter out;
    String INPUT = "";

    void solve() throws IOException {
        int n= ni(), m= ni();
        int[] indegree= new int[n+1];

        for(int i=0;i<m;i++)
        {
            int a= ni(), b= ni();
            indegree[b]++;
            indegree[a]++;
        }

        String ans="unknown topology";
        int one=0, two=0, len=0;
        for(int i=1;i<=n;i++)
        {
            if(indegree[i]== 1)
                one++;
            else if(indegree[i]== 2)
                two++;
            else if(indegree[i]== n-1)
                len++;
        }

        if(one== 2 && two== n-2)
            ans= "bus topology";
        else if(one==0 && two== n)
            ans= "ring topology";
        else if(len==1 && one== n-1)
            ans= "star topology";

        out.println(ans);
    }

    void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);

        solve();
        out.flush();
    }

    public static void main(String[] args) throws Exception {
        new NetworkTopology().run();
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

