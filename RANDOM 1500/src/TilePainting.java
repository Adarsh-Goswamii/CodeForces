import java.util.*;
import java.io.*;

public class TilePainting {
    PrintWriter out;
    StringTokenizer st;
    BufferedReader br;
    final int imax = Integer.MAX_VALUE, imin = Integer.MIN_VALUE;
    final int mod = 1000000007;

    void solve() throws Exception {
        int t = 1;
//        t = ni();
        for (int ii = 0; ii < t; ii++) {
            long n= nl();

            Map<Long, Integer> map= primeFactorization(n);
            List<Long> keys= new ArrayList<>(map.keySet());
            Collections.sort(keys);

            if(keys.size()== 0) out.println(1);
            else if(keys.size()== 1) out.println(keys.get(0));
            else {
                UnionFind dsu= new UnionFind((int)Math.sqrt(n)+1);
                for (int i = 0; i <= Math.sqrt(n); i++) {
                    for(long key: keys) {
                        if(i- key>= 0) dsu.union(i, (int)(i-key));
                    }
                }

                out.println(dsu.ans());
            }
        }
    }

    class UnionFind {
        int[] rank;
        int[] par;

        public UnionFind(int n) {
            rank = new int[n];
            par = new int[n];

            for (int i = 0; i < n; i++)
                par[i] = i;
        }

        public void union(int a, int b) {
            while (par[a] != a) a = par[a];
            while (par[b] != b) b = par[b];

            if (rank[a] > rank[b]) par[b] = a;
            else if (rank[a] < rank[b]) par[a] = b;
            else {
                par[b] = a;
                rank[a]++;
            }
        }

        public int ans() {
            print(par);
            Set<Integer> set= new HashSet<>();
            for (int i = 0; i < par.length; i++) {
                int a= i;
                while (par[a] != a) a = par[a];

                set.add(a);
            }
            return set.size();
        }
    }

    private Map<Long, Integer> primeFactorization ( long n){
        Map<Long, Integer> map = new HashMap<>();
        while (n % 2 == 0) {
            map.put(2l, map.getOrDefault(2l, 0) + 1);
            n >>= 1;
        }

        for (long i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                map.put(i, map.getOrDefault(i * 1l, 0) + 1);
                n /= i;
            }
        }

        if (n > 1) map.put(n, map.getOrDefault(n, 0) + 1);

        return map;
    }

    public static void main(String[] args) throws Exception {
        new TilePainting().run();
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