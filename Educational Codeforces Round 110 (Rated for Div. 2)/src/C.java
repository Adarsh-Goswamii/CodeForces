import java.util.*;
import java.io.*;

public class C {
    PrintWriter out;
    StringTokenizer st;
    BufferedReader br;
    final int imax = Integer.MAX_VALUE, imin = Integer.MIN_VALUE;
    final int mod = 1000000007;

    void solve() throws Exception {
        int t = 1;
        t = ni();
        for (int ii = 0; ii < t; ii++) {
            char[] arr= ns().toCharArray();
            int n= arr.length;
            char[] s1= new char[n];
            char[] s2= new char[n];

            boolean bool= true;
            for (int i = 0; i < n; i++) {
                s1[i]= bool?'0':'1';
                s2[i]= bool?'1':'0';
                bool= !bool;
            }

            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if(arr[i]== '?') continue;
                else {
                    if(arr[i]!= s1[i]) list1.add(i);
                    if(arr[i]!= s2[i]) list2.add(i);
                }
            }

            long ans= 0l;
//            out.println(new String(s1));
//            out.println(new String(s2));
            for (int i = 0; i < n; i++) {
                int val= 0;
                if(arr[i]== s1[i] || arr[i]== '?') {
                    int ind= bin(list1, i, n);
                    if(ind!= n) val= Math.max(val, (list1.get(ind)- i));
                    else val= Math.max(val, n-i);
//                    out.println(i+" "+val+" "+new String(s1)+" "+list1+" "+ind);
                }

                if(arr[i]== s2[i] || arr[i]== '?') {
                    int ind= bin(list2, i, n);
                    if(ind!= n) val= Math.max(val, (list2.get(ind)- i));
                    else val= Math.max(val, n-i);
//                    out.println(i+" "+val);
                }
                ans+= val;
            }

            out.println(ans);
        }
    }

    // return smallest value that is equal or greater than find
    private int bin(List<Integer> a, int find, int n) {
        int s= 0, l= a.size()-1, ret= n;
        while(s<= l) {
            int m= s+(l-s)/2;

            if(a.get(m)>= find) {
                ret= m;
                l= m-1;
            }
            else s= m+1;
        }
        return ret;
    }

    public static void main(String[] args) throws Exception {
        new C().run();
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