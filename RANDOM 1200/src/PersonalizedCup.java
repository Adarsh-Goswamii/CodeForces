import java.util.*;
import java.io.*;

public class PersonalizedCup {
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
            char[] arr= ns().toCharArray();
            int row= (int)Math.ceil(arr.length/20.0);
            int col= (int)Math.ceil(arr.length*1.0/row);

            int extra= row*col- arr.length;
            char[][] ans= new char[row][col];
//            for(int i=0;i<row;i++) {
//                int temp= extra/ row;
//                for(int j=0;j<temp;j++) ans[i][j]= '*';
//            }

            for(int i=0;i<extra- (extra/row)*row;i++) ans[i][col-1]= '*';

            int index= 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if(ans[i][j]== '*') continue;
                    ans[i][j]= arr[index++];
                }
            }

            out.println(row+" "+col);
            for(char[] i: ans)
                out.println(new String(i));
        }
    }

    public static void main(String[] args) throws Exception {
        new PersonalizedCup().run();
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

    private void sort(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i : arr) list.add(i);

        Collections.sort(list);
        for (int i = 0; i < arr.length; i++) arr[i] = list.get(i);
    }
}