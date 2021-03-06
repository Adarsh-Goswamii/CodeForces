import java.util.*;
import java.io.*;

public class ChessCheater {
    PrintWriter out;
    StringTokenizer st;
    BufferedReader br;
    final int imax = Integer.MAX_VALUE, imin = Integer.MIN_VALUE;
    final int mod = 1000000007;

    void solve() throws Exception {
        int t = 1;
        t = ni();
        for (int ii = 0; ii < t; ii++) {
            int n= ni(), k= ni();
            char[] a= ns().toCharArray();

            if(k== 0) {
                out.println(calcScore(a));
                continue;
            }

            int win= 0;
            for(char c: a) win+= c== 'W'? 1: 0;
            if(win== 0) { a[0]= 'W'; k--; }

            List<int[]> list = new ArrayList<>();
            int lose= 0;
            for(int i= 0;i<a.length;i++) {
                char c= a[i];
                if(c== 'L') lose++;
                else {
                    if(i-lose== 0 || lose== 0) { lose= 0; continue; }
                    list.add(new int[]{i-lose, i, lose});
                    lose= 0;
                }
            }

            Collections.sort(list, (_a, _b)->(_a[2]- _b[2]));
//            for(int[] i: list) print(i);
            for(int i=0;i<list.size();i++) {
                int[] val= list.get(i);
                if(val[2]<= k) { fill(a, val); k-= val[2]; }
            }

            for(int i=0;k!= 0 && i<n-1;i++) {
                if(a[i]== 'W' && a[i+1]!= 'W') {
                    a[i+1]= 'W';
                    k--;
                }
            }

            for(int i=n-1;k!= 0 && i>=1;i--) {
                if(a[i]== 'W' && a[i-1]!= 'W') {
                    a[i-1]= 'W';
                    k--;
                }
            }

            out.println(calcScore(a));
        }
    }

    private void fill(char[] arr, int[] a) {
        for(int i= a[0];i<=a[1];i++)
            arr[i]= 'W';
    }

    private int calcScore(char[] a) {
        int score= a[0]=='W'? 1: 0;
        for(int i=1;i<a.length;i++) {
            if(a[i]== 'W' && a[i-1]!= 'W') score++;
            else if(a[i]== 'W' && a[i-1]== 'W') score+=2;
        }
//        out.println(new String(a));
        return score;
    }

    public static void main(String[] args) throws Exception {
        new ChessCheater().run();
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