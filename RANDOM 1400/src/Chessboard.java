import java.security.spec.ECField;
import java.util.*;
import java.io.*;

public class Chessboard {
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
            char[][][] chess= new char[4][n][n];
            inputPiece(chess[0]);
            inputPiece(chess[1]);
            inputPiece(chess[2]);
            inputPiece(chess[3]);

            int ans= imax;
            for (int i = 0; i < 4; i++)
                for (int j = 0; j < 4; j++)
                    for (int k = 0; k < 4; k++)
                        for (int l = 0; l < 4; l++) {
                            Set<Integer> set = new HashSet<>();
                            set.add(i); set.add(j); set.add(k); set.add(l);
                            if(set.size()== 4) {
                                ans = Math.min(ans, fit(chess[i], chess[j], chess[k], chess[l], n));
//                                out.println(ans + " " + i + " " + j + " " + k + " " + l);
//                                out.println();
                            }
                        }

            out.println(ans);
        }
    }

    private int fit(char[][] chess, char[][] chess1, char[][] chess2, char[][] chess3, int n) {
        int ret= 0;
        n<<= 1;
        char[][] arr= new char[n][n];
        int J=0;
        for (int i = 0; i < n/2; i++)
            for (int j = 0; j < n/2; j++) arr[J/n][(J++)%n]= chess[i][j];

        for (int i = 0; i < n/2; i++)
            for (int j = n/2; j < n; j++) arr[J/n][(J++)%n]= chess1[i][j- n/2];

        for (int i = n/2; i < n; i++)
            for (int j = 0; j < n/2; j++) arr[J/n][(J++)%n]= chess2[i- n/2][j];

        for (int i = n/2; i < n; i++)
            for (int j = n/2; j < n; j++) arr[J/n][(J++)%n]= chess3[i- n/2][j- n/2];

//        for(char[] i: arr) out.println(new String(i));

        return update(arr);
    }

    private int update(char[][] arr) {
        int ret= imax, count= 0;
        char color= '0';
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr.length; j++, color= color== '0'? '1': '0')
                if(arr[i][j]!= color) count++;

        ret= Math.min(ret, count);
        color= '1'; count= 0;
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr.length; j++, color= color== '0'? '1': '0')
                if(arr[i][j]!= color) count++;

        return ret;
    }

    private void inputPiece(char[][] a) throws Exception {
        for (int i = 0; i < a.length; i++)
                a[i]= ns().toCharArray();
    }

    public static void main(String[] args) throws Exception {
        new Chessboard().run();
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