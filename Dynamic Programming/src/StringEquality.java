import java.util.*;
import java.io.*;

public class StringEquality {
    InputStream is;
    PrintWriter out;
    String INPUT = "";

    void solve() throws IOException {
        int t = ni();
        for (int ii = 0; ii < t; ii++)
        {
            int n= ni(), k= ni();

            char[] src= ns(n);
            char[] target= ns(n);

            HashMap<Character, Integer> map= new HashMap<>();
            HashMap<Character, Integer> map2= new HashMap<>();
            for(char c: src)
                map.put(c, map.getOrDefault(c, 0)+1);

            for(char c: target)
                map2.put(c, map2.getOrDefault(c, 0)+1);

            for(char c: map.keySet())
            {
                if(map2.containsKey(c))
                {
                    int val1= map.get(c);
                    int val2= map2.get(c);
                    map.put(c, val1- Math.min(val1, val2));
                    map2.put(c, val2- Math.min(val1, val2));
                }
            }

            boolean possible= true;
            List<Character> one= new ArrayList<>();
            List<Character> two= new ArrayList<>();

            for(char c: map.keySet())
            {
                int val= map.get(c);
                while(val!= 0)
                {
                    one.add(c);
                    val--;
                }
            }

            for(char c: map2.keySet())
            {
                int val= map2.get(c);
                while(val!= 0)
                {
                    two.add(c);
                    val--;
                }
            }

            Collections.sort(one);
            Collections.sort(two);

            if(one.size()%k!= 0) possible= false;
            for(int i=k-1;i< one.size();i+= k)
            {
                int temp= i;
                if(one.get(temp)> two.get(temp))
                    possible= false;

                while(temp!=i-k+1)
                {
                    if(one.get(temp)!= one.get(temp-1))
                        possible= false;

                    if(two.get(temp)!= two.get(temp-1))
                        possible= false;
                    temp--;
                }
            }

            if(possible)
                out.println("YES");
            else
                out.println("NO");
        }
    }

    void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);

        solve();
        out.flush();
    }

    public static void main(String[] args) throws Exception {
        new StringEquality().run();
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

