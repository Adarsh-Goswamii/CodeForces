import java.util.*;
import java.io.*;

public class C {
    PrintWriter out;
    StringTokenizer st;
    BufferedReader br;
    final int imax = Integer.MAX_VALUE, imin = Integer.MIN_VALUE;
    final int mod = 1000000007;

    /**
     *
     */

    void solve() throws Exception {
        read();
        int t= ni();
        for (int ii = 0; ii < t; ii++) {
            read();
            int n= ni();

            if(n== 2) {
                out.println(-1);
                continue;
            }

            int[][] ans= new int[n][n];
            int value= 1, diff= 0, i, j;
            boolean bool= true;
            while(diff!= n) {
                if(diff> 0) diff*= -1;
                else if(diff< 0) diff= diff*-1+ 1;
                else {
                    if(!bool) diff++;
                }

                if(diff>= 0) {i= Math.abs(diff); j= 0;}
                else {i=0; j= Math.abs(diff); }

                while(i!=n && j!= n) {
                    ans[i][j]= value++;
                    i++;
                    j++;
                }

                bool= false;
            }

            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++) {
                    out.print(ans[i][j]+" ");
                }
                out.println();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new C().run();
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

        solve();
        out.flush();
    }

    void read() throws Exception {
        st = new StringTokenizer(br.readLine());
    }

    int ni() {
        return Integer.parseInt(st.nextToken());
    }

    long nl() {
        return Long.parseLong(st.nextToken());
    }

    double nd() {
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
}