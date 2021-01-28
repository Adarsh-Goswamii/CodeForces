import java.util.*;
import java.io.*;

public class Cards {
    InputStream is;
    PrintWriter out;
    String INPUT = "";
    int b= 0, r= 1, g= 2;
    boolean[][][] memo;
    List<Character> ans;

    void solve() throws IOException
    {
        int n= ni();
        char[] arr= ns(n);
        int[] map= new int[3];

        for(char c: arr)
        {
            if(c== 'B')
                map[b]++;
            else if(c== 'R')
                map[r]++;
            else
                map[g]++;
        }

        memo= new boolean[201][201][201];
        DFSREC(map);

        Collections.sort(ans);
        for(char c: ans)
            out.print(c);
        out.println();
    }

    private void DFSREC(int[] map)
    {
        //out.println(map[0]+" "+map[1]+" "+map[2]);
        if(map[0]<0 || map[1]< 0 || map[2]<0) return;
        if(memo[map[0]][map[1]][map[2]]) return;
        memo[map[0]][map[1]][map[2]]= true;

        if(map[0]+ map[1]+ map[2]== 1)
        {
            if(map[r]== 1)
                ans.add('R');
            else if(map[b]== 1)
                ans.add('B');
            else
                ans.add('G');

            return;
        }


        map[0]--; map[1]--; map[2]++;
        DFSREC(map);
        map[0]++; map[1]++; map[2]--;

        map[0]--; map[1]++; map[2]--;
        DFSREC(map);
        map[0]++; map[1]--; map[2]++;

        map[0]++; map[1]--; map[2]--;
        DFSREC(map);
        map[0]--; map[1]++; map[2]++;

        if(map[0]>=2)
        {
            map[0]--;
            DFSREC(map);
            map[0]++;
        }

        if(map[1]>= 2)
        {
            map[1]--;
            DFSREC(map);
            map[1]++;
        }

        if(map[2]>= 2)
        {
            map[2]--;
            DFSREC(map);
            map[2]++;
        }

    }

    void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);
        ans= new ArrayList<>();

        solve();
        out.flush();
    }

    public static void main(String[] args) throws Exception {
        new Cards().run();
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

