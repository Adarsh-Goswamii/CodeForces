import java.util.*;
import java.io.*;

public class DrazilAndHisHappyFriends {
    InputStream is;
    PrintWriter out;
    String INPUT = "";

    void solve() throws IOException {
        int n= ni(), m= ni();
        HashSet<Integer> boy= new HashSet<>();
        HashSet<Integer> girl= new HashSet<>();
        for (int i = 0; i < n; i++)
            boy.add(i);

        for (int i = 0; i < m; i++)
            girl.add(i);

        int b= ni();
        for (int i = 0; i < b; i++)
            boy.remove(ni());

        int g= ni();
        for(int i = 0; i < g ; i++)
            girl.remove(ni());

        HashSet<Integer> remove= new HashSet<>();
        for(int i: boy)
        {
            HashSet<Integer> temp= new HashSet<>();
            int index= i;
            boolean cured= false;
            while(!temp.contains(index%m))
            {
                if(!girl.contains(index%m))
                {
                    cured= true;
                    break;
                }
                else
                    temp.add(index%m);

                index+= n;
            }

            if(cured)
                remove.add(i);
        }

        for(int i: remove)
            boy.remove(i);

        remove= new HashSet<>();
        for(int i: girl)
        {
            HashSet<Integer> temp= new HashSet<>();
            int index= i;
            boolean cured= false;
            while(!temp.contains(index%n))
            {
                if(!boy.contains(index%n))
                {
                    cured= true;
                    break;
                }
                else
                    temp.add(index%n);

                index+= m;
            }

            if(cured)
                remove.add(i);
        }

        for(int i: remove)
            girl.remove(i);

        if(boy.size()==0 || girl.size()== 0)
            out.println("Yes");
        else
            out.println("No");
    }

    void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);

        solve();
        out.flush();
    }

    public static void main(String[] args) throws Exception {
        new DrazilAndHisHappyFriends().run();
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

