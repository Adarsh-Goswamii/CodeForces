import java.util.*;
import java.io.*;

public class LoveRescue {
    InputStream is;
    PrintWriter out;
    String INPUT = "";
    int count;

    void solve() throws IOException {
        int n= ni();
        char[] arr= ns(n);
        char[] arr2= ns(n);

        int[][] adj= new int[26][26];
        for (int i = 0; i < n; i++)
        {
            adj[arr[i]-'a'][arr2[i]-'a']++;
            adj[arr2[i]-'a'][arr[i]-'a']++;
        }

        int ans=0;
        ArrayList<Character[]> spells= new ArrayList<>();
        boolean[] visited= new boolean[26];
        for (int i = 0; i < 26; i++)
        {
            if(visited[i]) continue;
            ArrayList<Character> temp= new ArrayList<>();
            DFSREC(adj, visited, i, temp);
            for(Character c: temp)
            {
                if(i== c-'a')
                    continue;

                spells.add(new Character[]{c, (char)(i+'a')});
            }
        }

        out.println(spells.size());
        for(Character[] c: spells)
            out.println(c[0]+ " "+ c[1]);
    }

    private void DFSREC(int[][] adj, boolean[] visited, int curr, ArrayList<Character> temp)
    {
        visited[curr]= true;
        temp.add((char)(curr+'a'));

        for(int i=0;i<26;i++)
        {
            if(visited[i] || adj[curr][i]== 0) continue;
            DFSREC(adj, visited, i, temp);
        }
    }

    void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);

        solve();
        out.flush();
    }

    public static void main(String[] args) throws Exception {
        new LoveRescue().run();
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

