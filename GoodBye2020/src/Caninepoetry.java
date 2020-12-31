import java.util.*;
import java.io.*;

public class Caninepoetry {
    InputStream is;
    PrintWriter out;
    String INPUT = "";

    void solve() throws IOException {
        int t = ni();
        for (int ii = 0; ii < t; ii++) {
            String s= ns();
            out.println(s+" "+minPalPartion(s));
        }
    }

    static int minPalPartion(String str)
    {
        // Get the length of the string
        int n = str.length();

        /* Create two arrays to build the solution
        in bottom up manner
           C[i] = Minimum number of cuts needed for
           palindrome partitioning of substring
           str[0..i]
           P[i][j] = true if substring str[i..j] is
           palindrome, else false
           Note that C[i] is 0 if P[0][i] is true */
        int[] C = new int[n];
        boolean[][] P = new boolean[n][n];

        int i, j, k, L; // different looping variables

        // Every substring of length 1 is a palindrome
        for (i = 0; i < n; i++) {
            P[i][i] = true;
        }

        /* L is substring length. Build the solution
        in bottom up manner by considering all substrings
        of length starting from 2 to n. */
        for (L = 2; L <= n; L++) {
            // For substring of length L, set different
            // possible starting indexes
            for (i = 0; i < n - L + 1; i++) {
                j = i + L - 1; // Set ending index

                // If L is 2, then we just need to
                // compare two characters. Else need to
                // check two corner characters and value
                // of P[i+1][j-1]
                if (L == 2)
                    P[i][j] = (str.charAt(i) == str.charAt(j));
                else
                    P[i][j] = (str.charAt(i) == str.charAt(j)) && P[i + 1][j - 1];
            }
        }

        for (i = 0; i < n; i++) {
            if (P[0][i] == true)
                C[i] = 0;
            else {
                C[i] = Integer.MAX_VALUE;
                for (j = 0; j < i; j++) {
                    if (P[j + 1][i] == true && 1 + C[j] < C[i])
                        C[i] = 1 + C[j];
                }
            }
        }

        // Return the min cut value for complete
        // string. i.e., str[0..n-1]
        return C[n - 1];
    }

    void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);

        solve();
        out.flush();
    }

    public static void main(String[] args) throws Exception {
        new Caninepoetry().run();
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

