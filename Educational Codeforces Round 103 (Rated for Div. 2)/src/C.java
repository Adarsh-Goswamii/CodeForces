import java.util.*;
import java.io.*;

public class C {
    InputStream is;
    PrintWriter out;
    String INPUT = "";
    long ans;

    void solve() throws IOException {
        int t = ni();
        for (int ii = 0; ii < t; ii++)
        {
            ans= 0l;
            int n= ni();// no of chains
            long[] arr= new long[n];
            for (int i = 0; i < n; i++)
                arr[i]= nl();// no of vertex in each chain

            int[] top= new int[n];
            for (int i = 0; i < n; i++)
                top[i]= ni();

            int[] last= new int[n];
            for (int i = 0; i < n; i++)
                last[i]= ni();

            DFSREC(arr, top, last, n-1, 0l, 0, 0);

            out.println(ans);
        }
    }

    private void DFSREC(long[] arr, int[] top, int[] last, int index, long prev, int tp, int lp)
    {
        if(index== 0)
            ans= Math.max(ans, prev+ Math.abs(tp- lp));
        else
        {
            if(tp> lp)
            {
                tp= tp^lp;
                lp= tp^lp;
                tp= tp^lp;
            }
            ans= Math.max(prev+ Math.abs(tp- lp), ans); // end it right here.

            if((arr[index]-1>= prev+ tp-1+ arr[index]-lp) || (tp== lp))
                prev= arr[index]-1;
            else
                prev+= tp-1+ arr[index]-lp;

            DFSREC(arr, top, last, index-1, prev+2, top[index], last[index]);
        }
    }

    void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);
        ans= 0l;

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

