import java.util.*;
import java.io.*;

public class Prize {
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
            int n= ni();
            int[] arr= new int[n];
            for (int i = 0; i < n; i++) arr[i]= ni();

            int a= ni(), b= ni(), c= ni(), d= ni(), e= ni();
            // a= mugs, b= towel, c= bag, d= bicycle, e= car

            long curr= 0l;
            long[] ans= {0l, 0l, 0l, 0l, 0l};
            for(int i: arr) {
                curr+= i;

                if(curr>= e) { long freq= curr/e; curr-= freq*e; ans[4]+= freq; }
                if(curr>= d) { long freq= curr/d; curr-= freq*d; ans[3]+= freq; }
                if(curr>= c) { long freq= curr/c; curr-= freq*c; ans[2]+= freq; }
                if(curr>= b) { long freq= curr/b; curr-= freq*b; ans[1]+= freq; }
                if(curr>= a) { long freq= curr/a; curr-= freq*a; ans[0]+= freq; }
            }

            out.println(ans[0]+" "+ans[1]+" "+ans[2]+" "+ans[3]+" "+ans[4]);
            out.println(curr);
        }
    }

    public static void main(String[] args) throws Exception {
        new Prize().run();
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