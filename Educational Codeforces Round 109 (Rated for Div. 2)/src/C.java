import com.sun.source.tree.Tree;

import java.util.*;
import java.io.*;

public class C {
    PrintWriter out;
    StringTokenizer st;
    BufferedReader br;
    final int imax = Integer.MAX_VALUE, imin = Integer.MIN_VALUE;
    final int mod = 1000000007;
    long[] ans;

    /**
     *  5 5 9 11 9 11 15 15 19 19 10 4 1 1 4 -1 6 10 -1 6
     */

    void solve() throws Exception {

    }

    private void helper(List<Integer> index, List<Integer> arr, List<Character> dir, int m) {
        int n= index.size();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++) map.put(arr.get(i), index.get(i));

        TreeSet<Integer> left = new TreeSet<>();
        TreeSet<Integer> right = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            if(dir.get(i)== 'L') left.add(arr.get(i));
            else right.add(arr.get(i));
        }

        out.println(left);
        out.println(right);

        // -> <-
        for(int i: left) {
            int val= bin(right, i);
            if(val== -1) continue;

            int index1= map.get(i);
            int index2= map.get(val);
            out.println(i+" "+val);

            ans[index1]= (i- val)/2;
            ans[index2]= (i- val)/2;
        }

        List<Integer> temp = new ArrayList<>();
        for(int i=0;i<left.size();i++) {
            if(ans[map.get(left.get(i))]!= -1) continue;
            temp.add(left.get(i));
        }

        left= new ArrayList<>(temp);
        int i= 0;
        while(i< left.size()-1) {
            int index1= map.get(left.get(i));
            int index2= map.get(left.get(i+1));

            ans[index1]= (left.get(i+1)- left.get(i))/2+ left.get(i);
            ans[index2]= (left.get(i+1)- left.get(i))/2+ left.get(i);

            i+=2;
        }

        temp = new ArrayList<>();
        for(i=0;i<right.size();i++) {
            if(ans[map.get(right.get(i))]!= -1) continue;
            temp.add(right.get(i));
        }

        right= new ArrayList<>(temp);
        Collections.reverse(right);
//        out.println(right);

        i= 0;
        while(i< right.size()-1) {
            int index1= map.get(right.get(i));
            int index2= map.get(right.get(i+1));

            ans[index1]= (right.get(i)- right.get(i+1))/2+ (m- right.get(i));
            ans[index2]= (right.get(i)- right.get(i+1))/2+ (m- right.get(i));

            i+=2;
        }

        if(left.size()%2== 1 && right.size()%2== 1) {
            int index1 = map.get(left.get(left.size() - 1));
            int index2 = map.get(right.get(right.size() - 1));

            int d1 = left.get(left.size() - 1);
            int d2 = m - right.get(right.size() - 1);

            if (d1 < d2) {
                d1 = d1 ^ d2;
                d2 = d1 ^ d2;
                d1 = d1 ^ d2;
            }

            ans[index1] = d1 + (m - (d1 - d2)) / 2;
            ans[index2] = d1 + (m - (d1 - d2)) / 2;
        }
    }

    private int bin(List<Integer> arr, int find) {
        int start= 0, last= arr.size()-1, ret= -1;

        while(start<= last) {
            int mid= start+ (last- start)/2;

            if(arr.get(mid)<= find) {
                ret= arr.get(mid);
                start= mid+1;
            }
            else last= mid-1;
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

    char nc() throws Exception {
        if (!st.hasMoreTokens())
            read();

        return st.nextToken().charAt(0);
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