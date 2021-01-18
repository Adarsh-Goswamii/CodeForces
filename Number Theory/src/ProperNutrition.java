import java.util.*;
import java.io.*;

public class ProperNutrition {
    InputStream is;
    PrintWriter out;
    String INPUT = "";

    void solve() throws IOException {
        int c= ni(), a= ni(), b= ni();

        long x= 1, y= 0;
        long xt= 0, yt= 1, at= a, bt= b;
        while(bt!=0)
        {
            long q= at/ bt;

            long temp= xt;
            xt= x- q*xt;
            x= temp;

            temp= yt;
            yt= y- q*yt;
            y= temp;

            temp= bt;
            bt= at- q*bt;
            at= temp;
        }

        if(c% at!=0)
        {
            out.println("NO");
            return;
        }

        x= x* (c/ at);
        y= y* (c/ at);
//        out.println(x+" "+y);

        if(x>=0 && y>=0)
            out.println("YES\n"+x+" "+y);
        else if(x<0 && y<0)
            out.println("NO");
        else if(x>=0 && y<0)
        {
            long k= (y*at/a);
            x= x+ k*(b/at);
            y= y- k*(a/at);
//            out.println(x+" "+y);

            while(true)
            {
                if(x<0) {
                    out.println("NO");
                    break;
                }
                else if(x>=0 && y>=0) {
                    out.println("YES\n"+x+" "+y);
                    break;
                }

                x= x- (b/at);
                y= y+ (a/at);
            }
        }
        else
        {
            long k= x*at/b;
            x= x+ (k*(b/at));
            y= y- (k*(a/at));

            while(true)
            {
                if(y<0) {
                    out.println("NO");
                    break;
                }
                else if(x>=0 && y>=0) {
                    out.println("YES\n"+x+" "+y);
                    break;
                }

                x= x+ (b/at);
                y= y- (a/at);

            }
        }
    }

    void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);

        solve();
        out.flush();
    }

    public static void main(String[] args) throws Exception {
        new ProperNutrition().run();
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

