import java.util.*;
import java.io.*;

public class A {
    PrintWriter out;
    StringTokenizer st;
    BufferedReader br;
    final int imax = Integer.MAX_VALUE, imin = Integer.MIN_VALUE;
    final int mod = 1000000007;

    /**
     *
     */

    public void solve() throws Exception {
        read();
        int t= ni();
        for(int ii=0;ii<t;ii++) {
            read();
            int n= ni(), x= ni();

            int[] arr= new int[n]; read();
            for(int i=0;i<n;i++) arr[i]= ni();

            Arrays.sort(arr);
            StringBuilder ans= new StringBuilder("");
            boolean found= true;
            int sum =0;
            for(int i=0;i<n;i++) {
                if(sum+ arr[i]== x && i!= n-1) {
                    arr[i]= arr[i]^ arr[i+1];
                    arr[i+1]= arr[i]^ arr[i+1];
                    arr[i]= arr[i]^ arr[i+1];
                    i--;
                }
                else if(sum+ arr[i]== x && i== n-1) {
                    found= false;
                    break;
                }
                else {
                    ans.append(arr[i]+" ");
                    sum+= arr[i];
                }
            }

            if(!found) out.println("NO");
            else out.println("YES\n"+ans);
        }
    }

    public static void main(String[] args) throws Exception {
        new A().run();
    }

    void run() throws Exception {
        out = new PrintWriter(System.out);
        br = new BufferedReader(new InputStreamReader(System.in));

//        File file= new File("C:\\Users\\Adarsh Goswami\\Downloads\\test_input (4).txt");
//        br = new BufferedReader(new FileReader(file));
//        out= new PrintWriter("output.txt");

        solve();
        out.flush();
    }

    void read() throws Exception {
        st = new StringTokenizer(br.readLine());
    }

    int ni() {
        return Integer.parseInt(st.nextToken());
    }

    long nl() {
        return Long.parseLong(st.nextToken());
    }

    double nd() {
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
}