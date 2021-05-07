import java.util.*;
import java.io.*;

public class RestrictedRPS {
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
            int n= ni();
            int a= ni(), b= ni(), c= ni();

            char[] arr= ns().toCharArray();
            int win= (int)Math.ceil(n/2.0d);

            int count= 0;
            char[] seq= new char[n];
            count+= helper(arr, seq, a, 'S', 'R');    // wins we can get with rocks
            count+= helper(arr, seq, b, 'R', 'P');    // wins we can get with paper
            count+= helper(arr, seq, c, 'P', 'S');    // wins we can get with scissors

            if(count>= win) {
                int[] freq= {0, 0, 0};
                for(char ch: seq) if(ch=='R') freq[0]++; else if(ch== 'P') freq[1]++; else if(ch== 'S') freq[2]++;

                for(int i=0;i<n;i++) {
                    if(seq[i]== '\u0000') {
                        if(a!= freq[0]) {
                            seq[i]= 'R';
                            freq[0]++;
                        }
                        else if(b!= freq[1]) {
                            seq[i]= 'P';
                            freq[1]++;
                        }
                        else {
                            seq[i]= 'S';
                            freq[2]++;
                        }
                    }
                }
                out.println("YES");
                out.println(new String(seq));
            }
            else {
                out.println("NO");
            }

        }
    }

    private int helper(char[] arr, char[] seq, int count, char win, char move) {
        int ret= 0;
        for(int i=0;i<arr.length;i++) {
            if(count== 0) return ret;
            if(arr[i]== win) { ret++; count--; seq[i]= move; }
        }

        return ret;
    }

    public static void main(String[] args) throws Exception {
        new RestrictedRPS().run();
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