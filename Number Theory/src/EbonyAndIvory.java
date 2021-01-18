import java.util.*;
import java.io.*;

public class EbonyAndIvory {
    InputStream is;
    PrintWriter out;
    String INPUT = "";

    void solve() throws IOException {
        int a= ni(), b= ni(), c= ni();

        boolean ans= false;
        outer :for(int i=0;i<=c;i++)
        {
            for(int j=0;j<=c;j++)
            {
                if(a*i+ b*j== c)
                {
                    out.println("Yes");
                    ans= true;
                    break outer;
                }
                else if(a*i+ b*j> c)
                    break;
            }
        }

        if(!ans)
            out.println("No");
    }

    // algo to check if there is any positive solution or not
    boolean check(int x, int y, int a, int b)
    {
        int k= y/a;

        if(x/b>= k)
            return true;
        else
            return false;
    }

    // algo that returns one of the possible values for the eq: ax+ by= c.
    int[] extendedEuclideansAlgo(int a, int b, int c)
    {
        int x= 1, y= 0;
        int x1= 0, y1= 1, a1= a, b1= b;
        while(b1!=0)
        {
            int q= a1/ b1;

            int temp= x1;
            x1= x- q* x1;
            x= temp;

            temp= y1;
            y1= y- q* y1;
            y= temp;

            temp= b1;
            b1= a1- q* b1;
            a1= temp;
        }

        // yes if ans exists
//        if(c%a1!= 0)
//            out.println("No");
//        else
//            out.println("Yes");

        x= x* c/a1;
        y= y* c/a1;
//        out.println(x+" "+y);

        // index 1 for yes = 1, no= 0
        // index 2 for coefficient of a
        // index 3 for coefficient of b
        return new int[]{c%a1==0?1:0, x, y};
    }

    void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);

        solve();
        out.flush();
    }

    public static void main(String[] args) throws Exception {
        new EbonyAndIvory().run();
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

