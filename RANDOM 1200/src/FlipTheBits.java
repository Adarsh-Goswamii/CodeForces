import java.util.*;
import java.io.*;

public class FlipTheBits {
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
            char[] arr= ns().toCharArray();
            char[] arr2= ns().toCharArray();

            int[] freq= {0, 0};
            List<Integer> list = new ArrayList<>();
            list.add(-1);
            for(int i=0;i<n;i++) {
                if(arr[i]== '0') freq[0]++;
                else freq[1]++;

                if(freq[0]== freq[1]) list.add(i);
            }

            for(int i=list.size()-1;i> 0;i--) {
                int index= list.get(i);
                if(arr[index]!= arr2[index]) {
                    toggle(arr, list.get(i-1), index);
                }
            }

            print(new String(arr).equals(new String(arr2)));
        }
    }

    private void toggle(char[] arr, Integer start, int last) {
        while(start++!= last) arr[start]= arr[start]== '0'? '1': '0';
    }

    public static void main(String[] args) throws Exception {
        new FlipTheBits().run();
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
        if(b) out.println("YES");
        else out.println("NO");
    }
}