import java.util.*;
import java.io.*;

public class D {
    PrintWriter out;
    StringTokenizer st;
    BufferedReader br;
    final int imax = Integer.MAX_VALUE, imin = Integer.MIN_VALUE;
    final int mod = 1000000007;

    void solve() throws Exception {
        int t = 1;
//        t = ni();
        for (int ii = 0; ii < t; ii++) {
            int n= ni();
            char[] arr= ns().toCharArray();
            pre(n, arr);

            int q= ni();
            for (int i = 0; i < q; i++) {
                int index= ni()-1; char c= nc();
                arr[index]= c;
                helper(arr, index);
                out.println(winner[arr.length-1]);
            }
        }
    }

    private void helper(char[] arr, int i) {
        if(i== -1) return;
        if(par[i].length== 0) winner[i]= (arr[i]== '?'? 2: 1);
        else {
            if(arr[i]== '0') winner[i]= winner[par[i][0]];
            else if(arr[i]== '1') winner[i]= winner[par[i][1]];
            else winner[i]= winner[par[i][0]]+ winner[par[i][1]];
        }

        helper(arr, child[i]);
    }

    int[][] par;
    int[] winner;
    int[] child;
    private void pre(int n, char[] arr) {
        par= new int[arr.length][];
        winner= new int[arr.length];
        child= new int[arr.length];
        Arrays.fill(child, -1);
        for (int i = (1<<n-1); i < arr.length; i++) par[i]= new int[]{-1, -1};

        int c= 0;
        for(int i= 0; i< arr.length; i++) {
            if(i>= (1<<n-1)) par[i]= new int[]{c++, c++};
            else par[i]= new int[]{};
        }
//        print(par);

        for (int i = 0; i < par.length; i++)
            if(par[i].length== 0) continue;
            else {
                child[par[i][0]]= i;
                child[par[i][1]]= i;
            }

//            print(par);
//            out.println(child.length);
//            print(child);

        for (int i = 0; i < arr.length; i++) {
            if(par[i].length== 0) winner[i]= (arr[i]== '?'? 2: 1);
            else {
                if(arr[i]== '0') winner[i]= winner[par[i][0]];
                else if(arr[i]== '1') winner[i]= winner[par[i][1]];
                else winner[i]= winner[par[i][0]]+ winner[par[i][1]];
            }
        }
//        print(winner);
    }

    public static void main(String[] args) throws Exception {
        new D().run();
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