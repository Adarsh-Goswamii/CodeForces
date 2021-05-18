import com.sun.source.tree.Tree;

import java.util.*;
import java.io.*;

public class C {
    PrintWriter out;
    StringTokenizer st;
    BufferedReader br;
    final int imax = Integer.MAX_VALUE, imin = Integer.MIN_VALUE;
    final int mod = 1000000007;
    Map<Integer, Integer> map;
    long[] ans;

    void solve() throws Exception {
        int t= 1;
        t= ni();
        for (int ii = 0; ii < t; ii++) {
            map= new HashMap<>();
            int n= ni(), m= ni();
            int[] arr= new int[n];
            for (int i = 0; i < n; i++) {
                arr[i]= ni();
                map.put(arr[i], i);
            }

            char[] dir= new char[n];
            for (int i = 0; i < n; i++) dir[i]= nc();

            ans= new long[n]; Arrays.fill(ans, -1l);
            List<Integer> list= new ArrayList<>();
            List<Character> d = new ArrayList<>();
            for(int i=0;i<n;i++) if(arr[i]%2== 0) { list.add(arr[i]); d.add(dir[i]); }
            helper(list, d, m);

            list= new ArrayList<>();
            d= new ArrayList<>();
            for(int i=0;i<n;i++) if(arr[i]%2!= 0) { list.add(arr[i]); d.add(dir[i]); }
            helper(list, d, m);

            print(ans);
        }
    }

    private void helper(List<Integer> arr, List<Character> dir, int m) {
        TreeSet<Integer> left= new TreeSet<>();
        TreeSet<Integer> right= new TreeSet<>();
        for (int i = 0; i < dir.size(); i++) {
            if(dir.get(i)== 'L') left.add(arr.get(i));
            else right.add(arr.get(i));
        }

        // -> <- right, left
        List<Integer> deleted = new ArrayList<>();
        for(int i: left) {
            if(right.lower(i)!= null) {
                int j= right.lower(i);
                right.remove(j);
                deleted.add(i);

                int i1= map.get(i);
                int i2= map.get(j);
                ans[i1]= (i-j)/2;
                ans[i2]= ans[i1];
            }
        }

        for(int i: deleted) left.remove(i);

        List<Integer> l = new ArrayList<>();
        List<Integer> r = new ArrayList<>();
        for(int i: left) l.add(i);
        for(int i: right) r.add(i);
        Collections.sort(l);
        Collections.sort(r, Collections.reverseOrder());

        // <- <-
        for(int i=0;i<l.size()-1;i+=2) {
            int i1= map.get(l.get(i));
            int i2= map.get(l.get(i+1));
            ans[i1]= (l.get(i+1)- l.get(i))/2+ l.get(i);;
            ans[i2]= ans[i1];
        }

        // -> ->
        for(int i=0;i<r.size()-1;i+=2) {
            int i1= map.get(r.get(i));
            int i2= map.get(r.get(i+1));
            ans[i1]= (r.get(i)- r.get(i+1))/2+ (m- r.get(i));
            ans[i2]= ans[i1];
        }

        // <- ->
        if(l.size()%2== 1 && r.size()%2== 1) {
            int index1 = map.get(l.get(l.size() - 1));
            int index2 = map.get(r.get(r.size() - 1));

            int d1 = l.get(l.size() - 1);
            int d2 = m - r.get(r.size() - 1);

            if (d1 < d2) {
                d1 = d1 ^ d2;
                d2 = d1 ^ d2;
                d1 = d1 ^ d2;
            }

            ans[index1] = d1 + (m - (d1 - d2)) / 2;
            ans[index2] = d1 + (m - (d1 - d2)) / 2;
        }
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

        st = new StringTokenizer("");
        while (true) {
            solve();
            String s = br.readLine();
            if (s == null) break;
            else st = new StringTokenizer(s);
        }
        out.flush();
    }

    void read() throws Exception { st = new StringTokenizer(br.readLine()); }

    int ni() throws Exception { if (!st.hasMoreTokens()) read(); return Integer.parseInt(st.nextToken()); }

    char nc() throws Exception { if (!st.hasMoreTokens()) read(); return st.nextToken().charAt(0); }

    long nl() throws Exception { if (!st.hasMoreTokens()) read(); return Long.parseLong(st.nextToken()); }

    double nd() throws Exception { if (!st.hasMoreTokens()) read(); return Double.parseDouble(st.nextToken());}

    String ns() throws Exception { String s = br.readLine(); return s.length() == 0 ? br.readLine() : s; }

    void print(int[] arr) { for (int i : arr) out.print(i + " "); out.println();}

    void print(long[] arr) { for (long i : arr) out.print(i + " "); out.println();}

    void print(int[][] arr) { for (int[] i : arr) { for (int j : i) out.print(j + " "); out.println(); } }

    void print(long[][] arr) { for (long[] i : arr) { for (long j : i) out.print(j + " "); out.println(); } }

    long add(long a, long b) { if (a + b >= mod) return (a + b) - mod; else return a + b >= 0 ? a + b : a + b + mod; }

    long mul(long a, long b) { return (a * b) % mod; }

    void print(boolean b) { if (b) out.println("YES"); else out.println("NO"); }

    long binExp(long base, long power ) {
        long res= 1l;
        while(power!= 0) {
            if((power&1)== 1) res= mul(res, base);
            base= mul(base, base);
            power>>= 1;
        }
        return res;
    }

}