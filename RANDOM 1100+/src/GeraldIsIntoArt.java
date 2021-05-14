import java.util.*;
import java.io.*;

public class GeraldIsIntoArt {
    PrintWriter out;
    StringTokenizer st;
    BufferedReader br;
    final int imax = Integer.MAX_VALUE, imin = Integer.MIN_VALUE;
    final int mod = 1000000007;

    /**
     *
     */

    void solve() throws Exception {
        int t = 1;
//        t = ni();

        for (int ii = 0; ii < t; ii++) {
            int n= ni(), m= ni(); if(n< m) { n= n^m; m= n^m; n= n^m; }
            int a= ni(), b= ni(); if(a< b) { a= a^b; b= a^b; a= a^b; }
            int c= ni(), d= ni(); if(c< d) { c= c^d; d= c^d; c= c^d; }

            if(n< a || n< c || m< b || m< d) out.println("NO");
            else {
                if(check(n, m, a, b, c, d) || check(n, m, c, d, a, b))
                    out.println("YES");
                else if(check(n, m, b, a, c, d) || check(n, m, d, c, a, b))
                    out.println("YES");
                else
                    out.println("NO");

            }
        }
    }

    private boolean check(int n, int m, int a, int b, int c, int d) {
        if(n< a || n< c || m< b || m< d) return false;
        int len= n-a, breadth= m;
        if(len< breadth) { len= len^breadth; breadth= len^breadth; len= len^breadth; }

        if(len>= c && breadth>= d) return true;

        len= n; breadth= m-b;
        if(len< breadth) { len= len^breadth; breadth= len^breadth; len= len^breadth; }

        if(len>= c && breadth>= d) return true;

        return false;
    }

    public static void main(String[] args) throws Exception {
        new GeraldIsIntoArt().run();
    }

    void run() throws Exception {
        if (System.getProperty("ONLINE_JUDGE") == null) {
            File file = new File("C:\\college\\CodeForces\\inputf.txt");
            br = new BufferedReader(new FileReader(file));
            out = new PrintWriter("C:\\college\\CodeForces\\outputf.txt");
        } else {
            out = new PrintWriter(System.out);
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        st = new StringTokenizer("");
        while (true) {
            solve();
            String s = br.readLine();
            if (s == null) break;
            else st = new StringTokenizer(s);
        }
        out.flush();
    }

    void read() throws Exception {
        st = new StringTokenizer(br.readLine());
    }

    int ni() throws Exception {
        if (!st.hasMoreTokens())
            read();

        return Integer.parseInt(st.nextToken());
    }

    long nl() throws Exception {
        if (!st.hasMoreTokens())
            read();

        return Long.parseLong(st.nextToken());
    }

    double nd() throws Exception {
        if (!st.hasMoreTokens())
            read();

        return Double.parseDouble(st.nextToken());
    }

    String ns() throws Exception {
        String s = br.readLine();
        return s.length() == 0 ? br.readLine() : s;
    }

    void print(int[] arr) {
        for (int i : arr)
            out.print(i + " ");
        out.println();
    }

    void print(long[] arr) {
        for (long i : arr)
            out.print(i + " ");
        out.println();
    }

    void print(int[][] arr) {
        for (int[] i : arr) {
            for (int j : i)
                out.print(j + " ");
            out.println();
        }
    }

    void print(long[][] arr) {
        for (long[] i : arr) {
            for (long j : i)
                out.print(j + " ");
            out.println();
        }
    }

    long add(long a, long b) {
        if (a + b >= mod)
            return (a + b) - mod;
        else
            return a + b >= 0 ? a + b : a + b + mod;
    }

    long mul(long a, long b) {
        return (a * b) % mod;
    }

    void print(boolean b) {
        if (b) out.println("YES");
        else out.println("NO");
    }
}