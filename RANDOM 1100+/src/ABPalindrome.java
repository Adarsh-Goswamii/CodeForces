import java.util.*;
import java.io.*;

public class ABPalindrome {
    PrintWriter out;
    StringTokenizer st;
    BufferedReader br;
    final int imax = Integer.MAX_VALUE, imin = Integer.MIN_VALUE;
    final int mod = 1000000007;

    /**
     *
     */

    void solve() throws Exception {
        int t= 1;
        t= ni();

        for(int ii=0;ii<t;ii++) {
            int[] a = new int[]{ni(), ni()};
            char[] arr = ns().toCharArray();

            for (int i = 0; i < arr.length; i++) {
                if(arr[i]== '?' && arr[arr.length-1-i]!= '?')
                    arr[i]= arr[arr.length-1-i];

                if(arr[i]!= '?')
                    a[arr[i]-'0']--;
            }

            int i= 0, j= arr.length-1;
            while(i<j) {
                if(!check(arr, i, j, a)) break;
                i++;
                j--;
            }

            if(i== j && arr[i]== '?') {
                arr[i]= a[0]== 1? '0': '1';
                a[arr[i]-'0']--;
            }

            if(palin(arr, a)) out.println(new String(arr));
            else out.println(-1);
        }
    }

    private boolean palin(char[] arr, int[] a) {
        int i= 0, j= arr.length-1;
        if(a[0]!= 0|| a[1]!= 0) return false;
        while(i<=j) {
            if(arr[i]!= arr[j] || arr[i]== '?' ) return false;
            i++;
            j--;
        }

        return true;
    }

    private boolean check(char[] arr, int i, int j, int[] a) {
        if(arr[i]== '?' || arr[j]== '?') {
            if(a[0]>= 2) {
                arr[i]= '0';
                arr[j]= '0';
                a[0]-= 2;
            }
            else {
                arr[i]= '1';
                arr[j]= '1';
                a[1]-= 2;
            }
        }

        return true;
    }

    public static void main(String[] args) throws Exception {
        new ABPalindrome().run();
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

        st= new StringTokenizer("");
        solve();
        out.flush();
    }

    void read() throws Exception {
        st = new StringTokenizer(br.readLine());
    }

    int ni() throws Exception {
        if(!st.hasMoreTokens())
            read();

        return Integer.parseInt(st.nextToken());
    }

    long nl() throws Exception {
        if(!st.hasMoreTokens())
            read();

        return Long.parseLong(st.nextToken());
    }

    double nd() throws Exception {
        if(!st.hasMoreTokens())
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
}