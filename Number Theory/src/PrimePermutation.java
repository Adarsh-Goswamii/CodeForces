import java.util.*;
import java.io.*;

public class PrimePermutation {
    InputStream is;
    PrintWriter out;
    String INPUT = "";
    HashSet<Integer> prime= new HashSet<>();

    void solve() throws IOException {
        char[] arr= ns().toCharArray();
        findPrimes(arr.length);

        HashMap<Integer, Integer> map= new HashMap<>();
        for(char c: arr)
            map.put(c+0, map.getOrDefault(c+0, 0)+1);

        PriorityQueue<int[]> q= new PriorityQueue<>((a, b)->(b[1]- a[1]));
        for(int i: map.keySet())
            q.add(new int[]{i, map.get(i)});

        HashSet<Integer> diff= new HashSet<>();
        diff.add(1);
        for(int i=2;i<=arr.length;i++)
            if(prime.contains(i) && i*2> arr.length)
                diff.add(i);

        if(q.peek()[1]< arr.length- diff.size())
            out.println("NO");
        else
        {
            char[] ans= new char[arr.length];
            int[] curr= q.poll();
            for(int i=1;i<=arr.length;i++)
                if(!diff.contains(i)) ans[i-1]= (char)curr[0];
            q.add(new int[]{curr[0], curr[1]- (arr.length- diff.size())});

            for(int i: diff)
            {
                while(q.peek()[1]==0)
                    q.poll();

                curr= q.poll();
                ans[i-1]= (char)curr[0];
                q.add(new int[]{curr[0], curr[1]- 1});
            }

            out.println("YES");
            out.println(new String(ans));
        }
    }

    void findPrimes(int n)
    {
        outer: for(int i=2;i<=n;i++)
        {
            for(int j=2;j<=Math.sqrt(i);j++)
                if(i%j== 0)
                    continue outer;

            prime.add(i);
        }
    }

    void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);

        solve();
        out.flush();
    }

    public static void main(String[] args) throws Exception {
        new PrimePermutation().run();
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

