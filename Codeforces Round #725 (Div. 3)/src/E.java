//import java.util.*;
//import java.io.*;
//  TODO: 11th june 2021
//public class E {
//    PrintWriter out;
//    StringTokenizer st;
//    BufferedReader br;
//    final int imax = Integer.MAX_VALUE, imin = Integer.MIN_VALUE;
//    final int mod = 1000000007;
//
//    void solve() throws Exception {
//        int t = 1;
//        t = ni();
//        for (int ii = 0; ii < t; ii++) {
//            int n= ni();
//            Map<String, List<String>> map= new HashMap<>();
//            Map<String, int[]> strings= new HashMap<>();
//
//            String last= "";
//            for (int i = 0; i < n; i++) {
//                String s= ns();
//                int index= s.indexOf('=');
//
//                if(s.charAt(index-1)== ':') {
//                    String key= s.substring(0, s.indexOf(' '));
//                    String val= s.substring(index+2);
//                    map.put(key, new ArrayList<>(Arrays.asList(key)));
//                    last= key;
//                    strings.put(key, helper(val));
//                }
//                else {
//                    String key= s.substring(0, s.indexOf(' '));
//                    List<String> val= new ArrayList<>();
//                    for(String ss: map.get(s.substring(index+2, s.indexOf('+')-1))) val.add(ss);
//                    for(String ss: map.get(s.substring(s.lastIndexOf(' ')+1))) val.add(ss);
//                    map.put(key, val);
//                    last= key;
//                }
//            }
//
////            out.println(map);
////            out.println(map.get(last));
//
//            long ans= 0l;
//            List<String> val = map.get(last);
//            for(int i=0;i<val.size();i++) {
//                int[] temp= strings.get(val.get(i));
//                if(i== val.size()-1) ans+= temp[0];
//                else {
//                    int[] temp2= strings.get(val.get(i+1));
//                    ans+= temp[0];
//                    if(temp[1]+ temp2[2]== 4) ans++;
//                }
//
//                int[] temp2= helper(val.get(i)+ val.get(i+1))
//            }
//
//            out.println(ans);
//        }
//    }
//
//    private int[] helper(String val) {
//        int[] ret= new int[3];
//        char[] arr= val.toCharArray();
//        for(int i=0;i<=arr.length-4;i++) {
//            if(arr[i]== 'h' && arr[i+1]== 'a' && arr[i+2]== 'h' && arr[i+3]== 'a') ret[0]++;
//        }
//
//        char[] str= "haha".toCharArray();
//        for (int i = 0; i < Math.min(4, arr.length); i++) {
//            if(str[i]== arr[i]) ret[1]++;
//            else break;
//        }
//        if(ret[1]== 4) ret[1]= 2;
//
//        for(int i=3;i>=0;i--) {
//            if(arr.length-(4-i)< 0) break;
//            if(arr[arr.length-(4-i)]== str[i]) ret[2]++;
//            else break;
//        }
//        if(ret[2]== 4) ret[2]= 2;
//        return ret;
//    }
//
//    public static void main(String[] args) throws Exception {
//        new E().run();
//    }
//
//    void run() throws Exception {
//        if (System.getProperty("ONLINE_JUDGE") == null) {
//            File file = new File("C:\\college\\CodeForces\\inputf.txt");
//            br = new BufferedReader(new FileReader(file));
//            out = new PrintWriter("C:\\college\\CodeForces\\outputf.txt");
//        } else {
//            out = new PrintWriter(System.out);
//            br = new BufferedReader(new InputStreamReader(System.in));
//        }
//
//        long ss = System.currentTimeMillis();
//        st = new StringTokenizer("");
//        while (true) {
//            solve();
//            String s = br.readLine();
//            if (s == null) break;
//            else st = new StringTokenizer(s);
//        }
//        //out.println(System.currentTimeMillis()-ss+"ms");
//        out.flush();
//    }
//
//    void read() throws Exception {
//        st = new StringTokenizer(br.readLine());
//    }
//
//    int ni() throws Exception {
//        if (!st.hasMoreTokens()) read();
//        return Integer.parseInt(st.nextToken());
//    }
//
//    char nc() throws Exception {
//        if (!st.hasMoreTokens()) read();
//        return st.nextToken().charAt(0);
//    }
//
//    String nw() throws Exception {
//        if (!st.hasMoreTokens()) read();
//        return st.nextToken();
//    }
//
//    long nl() throws Exception {
//        if (!st.hasMoreTokens()) read();
//        return Long.parseLong(st.nextToken());
//    }
//
//    int[] ni(int n) throws Exception {
//        int[] ret = new int[n];
//        for (int i = 0; i < n; i++) ret[i] = ni();
//        return ret;
//    }
//
//    long[] nl(int n) throws Exception {
//        long[] ret = new long[n];
//        for (int i = 0; i < n; i++) ret[i] = nl();
//        return ret;
//    }
//
//    double nd() throws Exception {
//        if (!st.hasMoreTokens()) read();
//        return Double.parseDouble(st.nextToken());
//    }
//
//    String ns() throws Exception {
//        String s = br.readLine();
//        return s.length() == 0 ? br.readLine() : s;
//    }
//
//    void print(int[] arr) {
//        for (int i : arr) out.print(i + " ");
//        out.println();
//    }
//
//    void print(long[] arr) {
//        for (long i : arr) out.print(i + " ");
//        out.println();
//    }
//
//    void print(int[][] arr) {
//        for (int[] i : arr) {
//            for (int j : i) out.print(j + " ");
//            out.println();
//        }
//    }
//
//    void print(long[][] arr) {
//        for (long[] i : arr) {
//            for (long j : i) out.print(j + " ");
//            out.println();
//        }
//    }
//
//    long add(long a, long b) {
//        if (a + b >= mod) return (a + b) - mod;
//        else return a + b >= 0 ? a + b : a + b + mod;
//    }
//
//    long mul(long a, long b) {
//        return (a * b) % mod;
//    }
//
//    void print(boolean b) {
//        if (b) out.println("YES");
//        else out.println("NO");
//    }
//
//    long binExp(long base, long power) {
//        long res = 1l;
//        while (power != 0) {
//            if ((power & 1) == 1) res = mul(res, base);
//            base = mul(base, base);
//            power >>= 1;
//        }
//        return res;
//    }
//
//    long gcd(long a, long b) {
//        if (b == 0) return a;
//        else return gcd(b, a % b);
//    }
//
//    // strictly smaller on left
//    void stack_l(int[] arr, int[] left) {
//        Stack<Integer> stack = new Stack<>();
//        for (int i = 0; i < arr.length; i++) {
//            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();
//            if (stack.isEmpty()) left[i] = -1;
//            else left[i] = stack.peek();
//            stack.push(i);
//        }
//    }
//
//    // strictly smaller on right
//    void stack_r(int[] arr, int[] right) {
//        Stack<Integer> stack = new Stack<>();
//        for (int i = arr.length - 1; i >= 0; i--) {
//            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();
//            if (stack.isEmpty()) right[i] = arr.length;
//            else right[i] = stack.peek();
//            stack.push(i);
//        }
//    }
//
//    private void sort(int[] arr) {
//        List<Integer> list = new ArrayList<>();
//        for (int i : arr) list.add(i);
//        Collections.sort(list);
//        for (int i = 0; i < arr.length; i++) arr[i] = list.get(i);
//    }
//}