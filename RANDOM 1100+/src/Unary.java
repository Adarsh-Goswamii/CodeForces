import java.util.*;
import java.io.*;

public class Unary {
    PrintWriter out;
    StringTokenizer st;
    BufferedReader br;
    final int imax = Integer.MAX_VALUE, imin = Integer.MIN_VALUE;
    final int mod = (int)(1e6+ 3);

    /**
     * ">"  →  1000,
     * "<"  →  1001,
     * "+"  →  1010,
     * "-"  →  1011,
     * "."  →  1100,
     * ","  →  1101,
     * "["  →  1110,
     * "]"  →  1111.
     */

    void solve() throws Exception {
        int t = 1;
//        t = ni();

        for (int ii = 0; ii < t; ii++) {
            Map<Character, String> map= new HashMap<>();
            map.put('>', "1000");
            map.put('<', "1001");
            map.put('+', "1010");
            map.put('-', "1011");
            map.put('.', "1100");
            map.put(',', "1101");
            map.put('[', "1110");
            map.put(']', "1111");

            char[] arr= ns().toCharArray();
            StringBuilder ans= new StringBuilder();
            for(char c: arr) ans.append(map.get(c));

            int power= 1, ans_num= 0;
            for(int i=ans.length()-1;i>=0;i--) {
                if(i!= ans.length()-1) power= mul(power, 2);

                if(ans.charAt(i)== 49) ans_num= add(ans_num, power);
            }

            out.println(ans_num);
        }
    }

    public static void main(String[] args) throws Exception {
        new Unary().run();
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

    int add(int a, int b) {
        if (a + b >= mod)
            return (a + b) - mod;
        else
            return a + b >= 0 ? a + b : a + b + mod;
    }

    int mul(int a, int b) {
        return (a * b) % mod;
    }

    void print(boolean b) {
        if (b) out.println("YES");
        else out.println("NO");
    }
}