import java.util.*;
import java.io.*;

public class SashaAndMagneticMachines
{
    InputStream is;
    PrintWriter out;
    String INPUT = "";

    void solve() throws IOException
    {
        int n= ni();
        int[] _map= new int[101];
        HashMap<Integer, Integer> mapp = new HashMap<>();
        for (int i = 0; i < n; i++)
        {
            int key= ni();
            _map[key]++;
        }

        out.println(mapp);
        long ans= Integer.MAX_VALUE;
        for(int x= 1;x<= 100;x++)
        {
            int[] map= new int[_map.length];
            for(int i=0;i<=100;i++)
                map[i]= _map[i];

            outer: for(int i= 100;i>=1;i--)
            {
                if(i%x!= 0 || map[i]== 0) continue;
                for(int j= 1;j< i/x;j++)
                {
                    if(map[j]== 0) continue;

                    int freq= Math.min(map[i], map[j]);
                    map[i]-= freq;
                    map[j]-= freq;
                    map[i/x]+= freq;
                    map[j*x]+= freq;

                    break outer;
                }
            }

            long val= 0, count= 0;
            for(int i=1;i<=100;i++)
            {
                val+= i*map[i];
                count+= map[i];
            }
//            out.println(count);

//            out.println(x+" "+val);
            ans= Math.min(ans, val);
        }

        out.println(ans);
    }

    void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);

        solve();
        out.flush();
    }

    public static void main(String[] args) throws Exception {
        new SashaAndMagneticMachines().run();
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

