import java.util.*;
import java.io.*;

public class TwoCakes {
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
            int[] arr= new int[2*n];
            for (int i = 0; i < 2*n; i++) arr[i]= ni();

            Map<Integer, int[]> map = new HashMap<>();
            for(int i=0;i<2*n;i++) {
                if(map.containsKey(arr[i])) map.get(arr[i])[1]= i;
                else map.put(arr[i], new int[]{i, 0});
            }

            int tier= 2, cake1= map.get(1)[0], cake2= map.get(1)[1];
            long distance= cake1+ cake2;
            while(tier<= n) {
                int[] val= map.get(tier);
                if(abs(val[0],  cake1)+ abs(val[1], cake2)>= abs(val[1],  cake1)+ abs(val[0], cake2)) {
                    distance+= abs(cake1, val[1])+ abs(cake2, val[0]);
                    cake1= val[1];
                    cake2= val[0];
                }
                else {
                    distance+= abs(cake1, val[0])+ abs(cake2, val[1]);
                    cake1= val[0];
                    cake2= val[1];
                }

                tier++;
            }

            out.println(distance);
        }
    }

    private int abs(int a, int b) { return Math.abs(a- b); }

    public static void main(String[] args) throws Exception {
        new TwoCakes().run();
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