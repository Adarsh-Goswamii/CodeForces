import java.util.*;
import java.io.*;

public class ReplaceAndKeepSorted {
    PrintWriter out;
    StringTokenizer st;
    BufferedReader br;
    final int imax = Integer.MAX_VALUE, imin = Integer.MIN_VALUE;
    final int mod = 1000000007;

    /**
     *
     */

    void solve() throws Exception {
        int n= ni(), q= ni(), k= ni();
        int[] arr= new int[n+2];
        arr[0]= 0;
        arr[n+1]= k+1;
        for (int i = 1; i <= n; i++) {
            arr[i]= ni();
        }

        int[] ans= new int[n];
        for(int i=1;i<= n;i++) ans[i-1]= arr[i+1]- arr[i-1]- 2;

        long[] prefix= new long[n];
        for(int i=0 ;i< n;i++) prefix[i]= (i!= 0? prefix[i-1]: 0)+ ans[i];

//        print(arr);
//        print(ans);
//        print(prefix);

        for(int i=0;i<q;i++) {
            int l= ni(), r= ni();
            l--; r--;

            if(l== r) {
                out.println(k-1);
                continue;
            }

            long val= arr[l+2]- 2;
//            out.println(val);
            val+= k- arr[r]- 1;
//            out.println(val);
            val+= prefix[r-1]- prefix[l];
            out.println(val);
        }
    }

    public static void main(String[] args) throws Exception {
        new ReplaceAndKeepSorted().run();
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