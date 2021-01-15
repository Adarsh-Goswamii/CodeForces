import java.util.*;
import java.io.*;

public class Noldbachproblem {
    InputStream is;
    PrintWriter out;
    String INPUT = "";
    List<Integer> arr;
    boolean[] composite;

    void solve() throws IOException {
        int n= ni(), k= ni();
        sieve(n);

        int count= 0;
        for(int i=2;i<=n;i++)
        {
            if(!composite[i] && BS(i-1))
                count++;
        }

        if(count>= k)
            out.println("YES");
        else
            out.println("NO");
    }

    private boolean BS(int find) {
        boolean ret= true;
        int start= 0, last= arr.size()-1;
        while(start<= last)
        {
            int mid= start+ (last- start)/2;
            if(arr.get(mid)== find)
                return true;
            else if(arr.get(mid)> find)
                last= mid-1;
            else
                start= mid+1;
        }

        return false;
    }

    private void sieve(int n) {
        composite= new boolean[n+1];
        for(int i=4;i<=n;i+=2)
            composite[i]= true;

        for(int i=3;i*i<=n;i+=2)
        {
            if(composite[i]) continue;
            for(int j=i*i;j<=n;j+=i)
                composite[j]= true;
        }

        int sum= 2;
        for(int i=3;i<=n;i++)
        {
            if(!composite[i])
            {
                sum+= i;
                arr.add(sum);
                sum= i;
            }
        }
    }

    void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);
        arr= new ArrayList<>();


        solve();
        out.flush();
    }

    public static void main(String[] args) throws Exception {
        new Noldbachproblem().run();
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

