import java.util.*;
import java.io.*;

/**
 * SOLUTION:
 *
 * So we will get a matrix of 10^9* 10^9 and not just that we also have a testcase
 * that can be up to 10^4.
 *
 * So if we just traverse the whole the matrix then also it will get very large
 * 10^9* 10^9 * 10^4
 *
 * Approach 1: (Naive approach)
 * We can just do a breadth for search for the whole matrix and find out the time
 * required to accumulate all the prison into one target cell.
 *
 * But i don't think this approach will work. (Time Limit Exceeded).
 *
 * Approach 2: O(10^4)
 *     Observations:
 *         * if some how we can tell the cell of the prisoner which will take the
 *         max time and for sure every prisoner takes less time than that.
 *
 *         * So i think that cell will be the most farthest diagonal from the
 *         target cell given to us. Nah actually ans will be always the cell
 *         of the four corners of the matrix. (0, m), (0, 0), (n, 0), (n, m).
 *
 *         *  So we can calculate the distance by |r- corner_r|+ |c- corner_c|
 */

public class PrisonBreak {
    InputStream is;
    PrintWriter out;
    String INPUT = "";

    void solve() throws IOException {
        int t = ni();
        for (int ii = 0; ii < t; ii++) {
            int n= ni(), m= ni(), r= ni(), c= ni();

            int ans= r+c-2;
            ans= Math.max(ans, r-1+Math.abs(c- m));
            ans= Math.max(ans, c-1+Math.abs(r-n));
            ans= Math.max(ans, Math.abs(c-m)+Math.abs(r-n));

            out.println(ans);
        }
    }

    void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);

        solve();
        out.flush();
    }

    public static void main(String[] args) throws Exception {
        new PrisonBreak().run();
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

