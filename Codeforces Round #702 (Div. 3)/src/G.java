import java.util.*;
import java.io.*;

public class G {
    InputStream is;
    PrintWriter out;
    String INPUT = "";

    void solve() throws IOException {
        int t = ni();
        for (int ii = 0; ii < t; ii++) {
            int n= ni(), m= ni();

            long[] arrn= new long[n];
            long[] arrm= new long[m];
            for (int i = 0; i < n; i++)
                arrn[i]= ni();

            for (int i = 0; i < m; i++)
                arrm[i]= ni();

            long[] prefix= new long[n];
            for (int i = 0; i < n; i++)
                prefix[i]= (i!=0? prefix[i-1]: 0)+ arrn[i];

            long max= Long.MIN_VALUE;
            for(long i: prefix)
                max= Math.max(max, i);

            TreeMap<Long, Integer> map= new TreeMap<>();
            long maxx= Long.MIN_VALUE;
            for(int i=0;i<prefix.length;i++)
            {
                if(prefix[i]<=maxx) continue;
                maxx= Math.max(maxx, prefix[i]);
                map.put(prefix[i], i);
            }

            long[] ans= new long[m];
            for(int i=0;i<m;i++)
            {
                if(arrm[i]> max)
                {
                    if(prefix[n-1]<=0)
                        ans[i]= -1;
                    else
                    {
                        long iter=(long)Math.ceil((double)(arrm[i]-map.lastKey())/prefix[n-1]);
                        ans[i]=n*iter;
                        ans[i]+=map.get(map.ceilingKey(arrm[i]-iter*prefix[n-1]));
                    }
                }
                else
                    ans[i]+= map.get(map.ceilingKey(arrm[i]));
            }

            for(int i=0;i<m;i++)
                out.print(ans[i]+" ");
            out.println();


        }
    }

    void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);

        solve();
        out.flush();
    }

    public static void main(String[] args) throws Exception {
        new G().run();
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

