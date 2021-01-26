import java.util.*;
import java.io.*;

// TODO: 26th January 2021

public class AdvertisingAgency {
    InputStream is;
    PrintWriter out;
    String INPUT = "";
    int MOD= 1000000007;

    void solve() throws IOException
    {
        int t = ni();
        initialize();
        for (int ii = 0; ii < t; ii++) {
            int n= ni(), k= ni();

            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++)
            {
                int key= ni();
                map.put(key, map.getOrDefault(key, 0)+ 1);
            }

            List<Integer> arr= new ArrayList<>(map.keySet());
            Collections.sort(arr, Collections.reverseOrder());

            long ans= 1;
            int i= 0;
            while(k!= 0){
                int key= arr.get(i);
                int val= map.get(key);

                if(val<= k)
                    k-= val;
                else{
                    ans= nCr(val, k);
                    break;
                }
                i++;
            }

            out.println(ans% MOD);
        }
    }

    long l[][] = new long[1001][1001];

     void initialize()
    {

        // 0C0 = 1
        l[0][0] = 1;
        for (int i = 1; i < 1001; i++) {
            // Set every nCr = 1 where r = 0
            l[i][0] = 1;
            for (int j = 1; j < i + 1; j++) {

                // Value for the current cell of Pascal's triangle
                l[i][j] = (l[i - 1][j - 1] + l[i - 1][j]);
            }
        }
    }

    long nCr(int n, int r)
    {
        return l[n][r];
    }

    void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);

        solve();
        out.flush();
    }

    public static void main(String[] args) throws Exception {
        new AdvertisingAgency().run();
    }

    private byte[] inbuf = new byte[1024];
    public int lenbuf = 0, ptrbuf = 0;

    private int readByte() {
        if (lenbuf == -1) throw new InputMismatchException();
        if (ptrbuf >= lenbuf) {
            ptrbuf = 0;
            try {
                lenbuf = is.read(inbuf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (lenbuf <= 0) return -1;
        }
        return inbuf[ptrbuf++];
    }

    private boolean isSpaceChar(int c) {
        return !(c >= 33 && c <= 126);
    }

    private int skip() {
        int b;
        while ((b = readByte()) != -1 && isSpaceChar(b)) ;
        return b;
    }

    private double nd() {
        return Double.parseDouble(ns());
    }

    private char nc() {
        return (char) skip();
    }

    private String ns() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != ' ')
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    private char[] ns(int n) {
        char[] buf = new char[n];
        int b = skip(), p = 0;
        while (p < n && !(isSpaceChar(b))) {
            buf[p++] = (char) b;
            b = readByte();
        }
        return n == p ? buf : Arrays.copyOf(buf, p);
    }

    private char[][] nm(int n, int m) {
        char[][] map = new char[n][];
        for (int i = 0; i < n; i++) map[i] = ns(m);
        return map;
    }

    private int[] na(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = ni();
        return a;
    }

    private int ni() {
        int num = 0, b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
        if (b == '-') {
            minus = true;
            b = readByte();
        }

        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    private long nl() {
        long num = 0;
        int b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
        if (b == '-') {
            minus = true;
            b = readByte();
        }

        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    private void tr(Object... o) {
        if (INPUT.length() > 0) System.out.println(Arrays.deepToString(o));
    }
}

