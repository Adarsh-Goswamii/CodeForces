import java.util.*;
import java.io.*;

public class PhoneNumbers {
    PrintWriter out;
    StringTokenizer st;
    BufferedReader br;
    final int imax = Integer.MAX_VALUE, imin = Integer.MIN_VALUE;
    final int mod = 1000000007;

    /**
     *  If you want to call a taxi, you should call: Rogulenko.
     * If you want to order a pizza, you should call: Fedorov, Rogulenko, Kaluzhin.
     * If you want to go to a cafe with a wonderful girl, you should call: Melnikov.
     */

    void solve() throws Exception {
        int t = 1;
//        t = ni();

        for (int ii = 0; ii < t; ii++) {
            int n= ni();

            List<String> name = new ArrayList<>();
            List<int[]> num= new ArrayList<>();
            for (int i = 0; i < n; i++) {
                num.add(new int[]{0, 0, 0});

                int val= ni();
                String na= st.nextToken(); name.add(na);
                for (int j = 0; j < val; j++) {
                    char[] arr= ns().toCharArray();
                    int index= checkNo(arr);

                    num.get(i)[index]++;
                }
            }


            int[] max= new int[]{0, 0, 0};
            for(int[] i: num) {
                max[0]= Math.max(max[0], i[0]);
                max[1]= Math.max(max[1], i[1]);
                max[2]= Math.max(max[2], i[2]);
            }

            for(int i=0;i<3;i++) {
                StringBuilder str= new StringBuilder();
                if(i==0)
                    str.append("If you want to call a taxi, you should call: ");
                else if(i== 1)
                    str.append("If you want to order a pizza, you should call: ");
                else
                    str.append("If you want to go to a cafe with a wonderful girl, you should call: ");

                for (int j = 0; j < n; j++) if(max[i]== num.get(j)[i]) str.append(name.get(j)+", ");

                out.println(str.substring(0, str.length()-2)+".");
            }
        }
    }

    private int checkNo(char[] arr) {
        Set<Character> set = new HashSet<>();
        for(char c: arr) if(c!= '-') set.add(c);

        if(set.size()== 1) return 0;

        char max= (char)('9'+1);
        for(char c: arr) {
            if(c== '-') continue;
            if(c>= max) return 2;
            max= c;
        }

        return 1;
    }

    public static void main(String[] args) throws Exception {
        new PhoneNumbers().run();
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