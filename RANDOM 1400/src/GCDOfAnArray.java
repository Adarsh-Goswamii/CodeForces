import java.util.*;
import java.io.*;

public class GCDOfAnArray {
    PrintWriter out;
    StringTokenizer st;
    BufferedReader br;
    final int imax = Integer.MAX_VALUE, imin = Integer.MIN_VALUE;
    final int mod = 1000000007;

    void solve() throws Exception {
        sieve(200001);
        int n = ni(), q = ni();
        int[] a= ni(n);

        HashMap<Long, TreeSet<int[]>> map = new HashMap<>();
        Map<Long, Integer>[] factorization = new Map[n];
        for (int i = 0; i < n; i++) factorization[i] = primeFactorization(a[i]);

        for (int i = 0; i < n; i++) {
            Map<Long, Integer> m = primeFactorization(a[i]);
            for (Map.Entry<Long, Integer> j : m.entrySet()) {
                if (map.containsKey(j.getKey())) map.get(j.getKey()).add(new int[]{j.getValue(), i});
                else {
                    TreeSet<int[]> temp = new TreeSet<>((aa, bb) -> (aa[0] != bb[0] ? aa[0] - bb[0] : aa[1] - bb[1]));
                    temp.add(new int[]{j.getValue(), i});
                    map.put(j.getKey(), temp);
                }
            }
        }

        long gcd= 1l;
        for (Long key : map.keySet()) {
            TreeSet<int[]> set = map.get(key);
            if (set.size() == n) gcd = mul(gcd, binExp(key, set.first()[0]));
        }

        for (int i = 0; i < q; i++) {
            int ind = ni() - 1, x = ni();
            Map<Long, Integer> _m = factorization[ind];
            Map<Long, Integer> m = primeFactorization(x);
            for (Map.Entry<Long, Integer> j : m.entrySet()) {
                if (map.containsKey(j.getKey())) {
                    if (_m.containsKey(j.getKey())) {
                        int extra= map.get(j.getKey()).first()[0];
                        map.get(j.getKey()).remove(new int[]{_m.get(j.getKey()), ind});
                        map.get(j.getKey()).add(new int[]{_m.get(j.getKey()) + j.getValue(), ind});
                        extra= map.get(j.getKey()).first()[0]- extra;
                        if(map.get(j.getKey()).size()== n)
                            gcd= mul(gcd, binExp(j.getKey(), extra));
                    }
                    else {
                        map.get(j.getKey()).add(new int[]{j.getValue(), ind});
                        if(map.get(j.getKey()).size()== n)
                            gcd= mul(gcd, binExp(j.getKey(), map.get(j.getKey()).first()[0]));
                    }
                } else {
                    TreeSet<int[]> temp = new TreeSet<>((aa, bb) -> (aa[0] != bb[0] ? aa[0] - bb[0] : aa[1] - bb[1]));
                    temp.add(new int[]{j.getValue(), ind});
                    map.put(j.getKey(), temp);
                    if(map.get(j.getKey()).size()== n)
                        gcd= mul(gcd, binExp(j.getKey(), map.get(j.getKey()).first()[0]));
                }
            }

            out.println(gcd);
            for (Map.Entry<Long, Integer> j : m.entrySet()) {
                if(_m.containsKey(j.getKey())) _m.put(j.getKey(), _m.get(j.getKey())+ j.getValue());
                else _m.put(j.getKey(), j.getValue());
            }
        }
    }

    int[] prime;
    void sieve ( int n){
        prime = new int[n+1];
        for (int i = 0; i <= n; i++)
            prime[i]= i;

        for (int p = 2; p * p <= n; p++) {
            if (prime[p] == p)
                for (int i = p * p; i <= n; i += p) prime[i] = p;
        }
    }

    private Map<Long, Integer> primeFactorization(int n) {
        Map<Long, Integer> map = new HashMap<>();
        while(n!= 1) {
            map.put(prime[n]*1l, map.getOrDefault(prime[n]*1l, 0)+1);
            n/= prime[n];
        }

        return map;
    }

    HashMap<Long, TreeMap<Integer, Integer>> map;

    public static void main(String[] args) throws Exception {
        new GCDOfAnArray().run();
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