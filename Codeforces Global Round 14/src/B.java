import java.util.*;
import java.io.*;

public class B {
    PrintWriter out;
    StringTokenizer st;
    BufferedReader br;
    final int imax = Integer.MAX_VALUE, imin = Integer.MIN_VALUE;
    final int mod = 1000000007;

    void solve() throws Exception {
        read();
        int t= ni();

        for(int ii=0;ii<t;ii++) {
            read();
            long n= ni();
            if(n%2== 1) {
                out.println("NO");
                continue;
            }

            long area= n/2;
            if(primeFactorization(area))
                out.println("YES");
            else
                out.println("NO");

        }
    }

    private boolean primeFactorization (long n){
        while (n % 2 == 0) {
            n= n/2;
        }

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            int count= 0;
            while (n % i == 0) {
                count++;
                n /= i;
            }

            if(count%2!= 0) return false;
        }

        if (n > 1) return false;

        return true;
    }


    public static void main(String[] args) throws Exception {
        new B().run();
    }

    void run() throws Exception {

        if (System.getProperty("ONLINE_JUDGE") == null) {
            File file= new File("C:\\college\\CodeForces\\inputf.txt");
            br = new BufferedReader(new FileReader(file));
            out= new PrintWriter("C:\\college\\CodeForces\\outputf.txt");
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