import java.util.*;
import java.io.*;

public class A {
    PrintWriter out;
    StringTokenizer st;
    BufferedReader br;
    final int imax = Integer.MAX_VALUE, imin = Integer.MIN_VALUE;
    final int mod = 1000000007;

    void solve() throws Exception {
        int t = 1;
        t = ni();
        for (int ii = 0; ii < t; ii++) {
            int n= ni(), m= ni();
            char[][] a= new char[n][];
            for (int i = 0; i < n; i++) a[i]= ns().toCharArray();

            bfs(a);
            if(check(a)) {
                out.println("YES");
                for(char[] c: a) out.println(new String(c));
            }
            else out.println("NO");
        }
    }

    private boolean check(char[][] a) {
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[0].length; j++) {
                if(i!= 0 &&a [i-1][j]== a[i][j]) return false;
                if(i+1!= a.length && a[i+1][j]== a[i][j]) return false;
                if(j!= 0 && a[i][j-1]== a[i][j]) return false;
                if(j+1!= a[0].length && a[i][j+1]== a[i][j]) return false;
            }
        return true;
    }

    private void bfs(char[][] a) {
        Queue<int[]> q= new LinkedList<>();
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[0].length; j++)
                if(a[i][j]!= '.') q.add(new int[]{i, j});

        if(q.isEmpty()) { q.add(new int[]{0, 0}); a[0][0]= 'R'; }
        while(!q.isEmpty()) {
            int size= q.size();
            for (int ii = 0; ii < size; ii++) {
                int[] curr= q.poll();
                int i= curr[0], j= curr[1];
                char color= a[i][j]== 'W'? 'R': 'W';

                if(i!= 0 && a[i-1][j]== '.') { a[i-1][j]= color; q.add(new int[]{i-1, j}); }
                if(i+1!= a.length && a[i+1][j]== '.') { a[i+1][j]= color; q.add(new int[]{i+1, j}); }
                if(j+1!= a[0].length && a[i][j+1]== '.') { a[i][j+1]= color; q.add(new int[]{i, j+1}); }
                if(j!= 0 && a[i][j-1]== '.') { a[i][j-1]= color; q.add(new int[]{i, j-1}); }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new A().run();
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

        long ss = System.currentTimeMillis();
        st = new StringTokenizer("");
        while (true) {
            solve();
            String s = br.readLine();
            if (s == null) break;
            else st = new StringTokenizer(s);
        }
        //out.println(System.currentTimeMillis()-ss+"ms");
        out.flush();
    }

    void read() throws Exception {
        st = new StringTokenizer(br.readLine());
    }

    int ni() throws Exception {
        if (!st.hasMoreTokens()) read();
        return Integer.parseInt(st.nextToken());
    }

    char nc() throws Exception {
        if (!st.hasMoreTokens()) read();
        return st.nextToken().charAt(0);
    }

    String nw() throws Exception {
        if (!st.hasMoreTokens()) read();
        return st.nextToken();
    }

    long nl() throws Exception {
        if (!st.hasMoreTokens()) read();
        return Long.parseLong(st.nextToken());
    }

    int[] ni(int n) throws Exception {
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) ret[i] = ni();
        return ret;
    }

    long[] nl(int n) throws Exception {
        long[] ret = new long[n];
        for (int i = 0; i < n; i++) ret[i] = nl();
        return ret;
    }

    double nd() throws Exception {
        if (!st.hasMoreTokens()) read();
        return Double.parseDouble(st.nextToken());
    }

    String ns() throws Exception {
        String s = br.readLine();
        return s.length() == 0 ? br.readLine() : s;
    }

    void print(int[] arr) {
        for (int i : arr) out.print(i + " ");
        out.println();
    }

    void print(long[] arr) {
        for (long i : arr) out.print(i + " ");
        out.println();
    }

    void print(int[][] arr) {
        for (int[] i : arr) {
            for (int j : i) out.print(j + " ");
            out.println();
        }
    }

    void print(long[][] arr) {
        for (long[] i : arr) {
            for (long j : i) out.print(j + " ");
            out.println();
        }
    }

    long add(long a, long b) {
        if (a + b >= mod) return (a + b) - mod;
        else return a + b >= 0 ? a + b : a + b + mod;
    }

    long mul(long a, long b) {
        return (a * b) % mod;
    }

    void print(boolean b) {
        if (b) out.println("YES");
        else out.println("NO");
    }

    long binExp(long base, long power) {
        long res = 1l;
        while (power != 0) {
            if ((power & 1) == 1) res = mul(res, base);
            base = mul(base, base);
            power >>= 1;
        }
        return res;
    }

    long gcd(long a, long b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }

    // strictly smaller on left
    void stack_l(int[] arr, int[] left) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();
            if (stack.isEmpty()) left[i] = -1;
            else left[i] = stack.peek();
            stack.push(i);
        }
    }

    // strictly smaller on right
    void stack_r(int[] arr, int[] right) {
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();
            if (stack.isEmpty()) right[i] = arr.length;
            else right[i] = stack.peek();
            stack.push(i);
        }
    }

    private void sort(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i : arr) list.add(i);
        Collections.sort(list);
        for (int i = 0; i < arr.length; i++) arr[i] = list.get(i);
    }
}