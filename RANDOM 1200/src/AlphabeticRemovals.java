import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class AlphabeticRemovals {
    PrintWriter out;
    StringTokenizer st;
    BufferedReader br;
    final int imax = Integer.MAX_VALUE, imin = Integer.MIN_VALUE;
    final int mod = 1000000007;

    /**
     *
     */

    void solve() throws Exception {
        int n= ni(), k= ni();
        char[] arr= ns().toCharArray();
        char[] ans= new char[n];

        List<Integer>[] map= new ArrayList[26];
        for (int i = 0; i < 26; i++) map[i]= new ArrayList<>();

        int index= 0;
        for(char c: arr) map[c-'a'].add(index++);

        for(int i=0;i<26;i++) {
            if(map[i].size()<= k) {
                k-= map[i].size();
                map[i]= new ArrayList<>();

                if(k== 0) break;
            }
            else {
                List<Integer> temp= new ArrayList<>();
                for(int j= k;j<map[i].size();j++)
                    temp.add(map[i].get(j));

                map[i]= temp;
                break;
            }
        }

        for(int i=0;i<26;i++) {
            for(int j: map[i]) ans[j]= (char)(i+'a');
        }

        for(char c: ans) if(c!= '\u0000') out.print(c);
        out.println();
    }

    public static void main(String[] args) throws Exception {
        new AlphabeticRemovals().run();
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