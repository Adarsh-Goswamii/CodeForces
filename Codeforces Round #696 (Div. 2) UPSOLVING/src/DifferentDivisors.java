import java.util.*;
import java.io.*;

public class DifferentDivisors {
    InputStream is;
    PrintWriter out;
    String INPUT = "";
    List<Integer> prime;

    void solve() throws IOException {
        int t = ni();
        sieve(500000);
        for (int ii = 0; ii < t; ii++)
        {
            int d= ni();
            int find= 1+ d;
            int val= binarySearch(0, prime.size()-1, find);
            int find2= val+ d;
            long ans= val* binarySearch(0, prime.size()-1, find2);

            //check(ans);
            out.println(ans);
        }
    }

    void check(long n)
    {
        for(long i=1;i<=n;i++)
            if(n%i==0)
                out.print(i+" ");
            out.println();
    }

    int binarySearch(int start, int last, int find)
    {
        int ret= 1;
        while(start<= last)
        {
            int mid= start+ (last- start)/2;

            if(prime.get(mid)>= find)
            {
                ret= prime.get(mid);
                last= mid-1;
            }
            else
                start= mid+1;
        }

        return ret;
    }

    void sieve(int n)
    {
        boolean[] composite= new boolean[n];
        for(int i=2;i<=Math.sqrt(n);i++)
        {
            if(composite[i]) continue;;
            for(int j= i*i;j<n;j+=i)
                composite[j]= true;
        }

        for(int i=2;i<n;i++)
            if(!composite[i])
                prime.add(i);
    }

    void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);
        prime= new ArrayList<>();

        solve();
        out.flush();
    }

    public static void main(String[] args) throws Exception {
        new DifferentDivisors().run();
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

