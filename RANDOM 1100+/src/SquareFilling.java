import java.util.*;
import java.io.*;

public class SquareFilling {
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
            int n= ni(), m= ni();

            int[][] arr= new int[n][m];
            int[][] ans= new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    ans[i][j]= ni();
                }
            }

            int count= 0;
            StringBuilder str= new StringBuilder("");
            for (int i = 0; i < n-1; i++) {
                for (int j = 0; j < m-1; j++) {
                    if(square(arr, ans, i, j)) {
                        count++;
                        fill(arr, i, j);
                        str.append((i+1)+" "+(j+1)+"\n");
                    }
                }
            }

            if(equal(arr, ans))
                out.print(count+"\n"+str.toString());
            else
                out.println(-1);
        }
    }

    private boolean square(int[][] arr, int[][] ans, int i, int j) {
        return (ans[i][j]+ ans[i+1][j]+ ans[i][j+1]+ ans[i+1][j+1])== 4;
    }

    private void fill(int[][] ans, int i, int j) {
        ans[i][j]= 1;
        ans[i+1][j]= 1;
        ans[i][j+1]= 1;
        ans[i+1][j+1]= 1;
    }

    private boolean equal(int[][] arr, int[][] ans) {
        for(int i=0;i<arr.length;i++)
            for (int j = 0; j < arr[0].length; j++) {
                if(arr[i][j]!= ans[i][j]) return false;
            }

        return true;
    }

    public static void main(String[] args) throws Exception {
        new SquareFilling().run();
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
        solve();
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