import java.util.*;
import java.io.*;

public class C {
    InputStream is;
    PrintWriter out;
    String INPUT = "";
    boolean bool= true;

    void solve() throws IOException {
        int start= 1, last= ni();

        find(start, last, -1);
    }

    private void find(int start, int last, int pass)
    {
        if(start== last)
        {
            System.out.println("! "+start);
            System.out.flush();
            return;
        }
        else if(start+1== last)
        {
            if(pass== -1)
            {
                System.out.println("? "+start+" "+last);
                System.out.flush();
                pass= ni();
            }

            if(pass== start)
                out.println("! "+last);
            else
                out.println("! "+start);
            return;
        }

        int max2= pass;
        if(pass== -1)
        {
            System.out.println("? "+start+" "+last);
            System.out.flush();
            max2= ni();
            find(start, last, max2);
            return;
        }

        int mid= start+ (last- start)/2;
        if(max2>= start && max2<= mid)// first half
        {
            System.out.println("? "+start+" "+mid);
            System.out.flush();

            if(ni()== max2)
                find(start, mid, max2);
            else
                find(mid, last, -1);
        }
        else
        {
            System.out.println("? "+mid+" "+last);
            System.out.flush();

            if(ni()== max2)
                find(mid, last, max2);
            else
                find(start, mid, -1);
        }
    }

    void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);

        solve();
        out.flush();
    }

    public static void main(String[] args) throws Exception {
        new C().run();
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

