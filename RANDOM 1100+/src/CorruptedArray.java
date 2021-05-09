import java.util.*;
import java.io.*;

public class CorruptedArray {
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
            long[] arr= new long[n+2];

            long sum= 0l;
            Map<Long, Integer> map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                arr[i]= ni();
                sum+= arr[i];
                map.put(arr[i], map.getOrDefault(arr[i], 0)+ 1);
            }

            boolean found= false;
            for(int i=0;i<arr.length;i++) {
                long key= sum- arr[i];
                if(map.get(arr[i])== 1) map.remove(arr[i]);

                if(key%2== 0 && map.containsKey(key/2)) {
                    boolean bool= true;
                    for (int j = 0; j < arr.length; j++) {
                        if(i!= j) {
                            if(arr[j]== key/2) {
                                if(bool) {
                                    bool= false;
                                    continue;
                                }
                            }
                            out.print(arr[j]+" ");
                        }
                    }
                    out.println();
                    found= true;
                    break;
                }

                if(!map.containsKey(arr[i]))
                map.put(arr[i], 1);
            }

            if(!found) out.println(-1);
        }
    }

    public static void main(String[] args) throws Exception {
        new CorruptedArray().run();
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