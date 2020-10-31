import java.util.*;
import java.io.*;

/**
 * SOLUTION:
 *
 * a and b grams of cheese
 *
 * okay so i guess i am the fox.
 *
 * we need to make them equal as soon as possible by reducing them to 1/2, 1/3
 * and 1/5.
 *
 * How to approach the solution...............................................
 * So if there exists a common divisor then there will exist some ans for the
 * problem.
 *
 * Do prime factorization of a and b.
 * How about writing a recursive code that checks for all valid paths. Only if
 * we cant find any relation between which number to divide by what.
 *
 * 15= 3 x 5
 * 20= 2 x 2 x 5
 * delete all the common terms and if the left part just contains 2, 3 or 5 then
 * there exists a solution with remaining no of elements in both of there
 * prime factorization.
 */

public class FoxDividingCheese {
    InputStream is;
    PrintWriter out;
    String INPUT = "";

    void solve() throws IOException {
        int n= ni(), m= ni();

        HashMap<Integer, Integer> map = primeFactorization(n);
        HashMap<Integer, Integer> map2 = primeFactorization(m);

        HashSet<Integer> set =  new HashSet<>(map.keySet());
        set.addAll(map2.keySet());

        for(int key: set)
        {
            int min= Math.min(map.getOrDefault(key, 0), map2.getOrDefault(key, 0));
            map.put(key, map.getOrDefault(key, 0)-min);
            map2.put(key, map2.getOrDefault(key, 0)-min);
        }

        int ans=0;
        for(int i: set)
        {
            if(i!=2 && i!=3 && i!=5)
            {
                if(map.getOrDefault(i, 0)!= map2.getOrDefault(i, 0))
                {
                    ans= -1;
                    break;
                }
            }
            else
                ans+= map.getOrDefault(i, 0)+ map2.getOrDefault(i, 0);
        }

        out.println(ans);
    }

    private HashMap<Integer, Integer> primeFactorization(int n)
    {
        HashMap<Integer, Integer> map =  new HashMap<>();

        while(n%2==0 && n!=1)
        {
            map.put(2, map.getOrDefault(2, 0)+1);
            n/=2;
        }

        for(int i=3;i*i<=n;i+=2)
        {
            while(n!=1 && n%i==0)
            {
                map.put(i, map.getOrDefault(i, 0)+1);
                n/=i;
            }
        }

        if(n>2)
            map.put(n, map.getOrDefault(n, 0)+1);

        return map;
    }

    void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);

        solve();
        out.flush();
    }

    public static void main(String[] args) throws Exception {
        new FoxDividingCheese().run();
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

