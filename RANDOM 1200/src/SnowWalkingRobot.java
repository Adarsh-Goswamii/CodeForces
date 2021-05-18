import java.util.*;
import java.io.*;

public class SnowWalkingRobot {
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
        t = ni();

        for (int ii = 0; ii < t; ii++) {
            char[] arr= ns().toCharArray();

            int[] freq= new int[4];
            int l= 0, r= 0, u= 0, d= 0;

            for(char c: arr) {
                if(c== 'L') l++;
                else if(c== 'R') r++;
                else if(c== 'U') u++;
                else d++;
            }

            l= Math.min(l, r);
            u= Math.min(d, u);

            if(u== 0&& l== 0) out.println(0);
            else if(u== 0 || l== 0) {
                out.println(2);
                if(u!= 0) out.print("UD");
                else out.print("LR");
            }
            else {
                out.println(l*2+ u*2);
                for (int i = 0; i < l; i++) out.print("L");
                for (int i = 0; i < u; i++) out.print("U");
                for (int i = 0; i < l; i++) out.print("R");
                for (int i = 0; i < u; i++) out.print("D");
            }

            out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        new SnowWalkingRobot().run();
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
        while(true) {
            solve();
            String s= br.readLine();
            if(s== null) break;
            else st= new StringTokenizer(s);
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