import java.util.*;
import java.io.*;

public class D {
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
            int n = ni();

            read();
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int key= ni()-i;
                map.put(key, map.getOrDefault(key, 0)+ 1);
            }

            long ans= 0;
            for(int i: map.keySet()) ans+= map.get(i)*1l*(map.get(i)-1)/2;
            out.println(ans);
        }
    }

    public static void main(String[] args) throws Exception {
        new D().run();
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