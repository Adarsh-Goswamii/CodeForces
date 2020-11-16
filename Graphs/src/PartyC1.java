import java.util.*;
import java.io.*;

public class PartyC1 {
    InputStream is;
    PrintWriter out;
    String INPUT = "";

    void solve() throws IOException {
        int n= ni();
        ArrayList<ArrayList<Integer>> list= new ArrayList<>();
        for (int i = 0; i <=n; i++)
            list.add(new ArrayList<>());

        int m= ni();
        for (int i = 0; i < m; i++)
        {
            int from= ni(), to= ni();
            list.get(from).add(to);
            list.get(to).add(from);
        }

        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        m= ni();
        for (int i = 0; i <m; i++)
        {
            int from= ni(), to= ni();
            if(map.containsKey(from))
                map.get(from).add(to);
            else
                map.put(from, new HashSet<>(Arrays.asList(to)));

            if(map.containsKey(to))
                map.get(to).add(from);
            else
                map.put(to, new HashSet<>(Arrays.asList(from)));
        }

        int ans=0;
        boolean[] visited= new boolean[n+1];
        for(int i=1;i<=n;i++)
        {
            if(visited[i]) continue;
            HashSet<Integer> nodes= new HashSet<>();
            DFSREC(list, visited, i, nodes);

            boolean bool= true;
            outer: for(int node: nodes)
            {
                HashSet<Integer> temp= map.getOrDefault(node, new HashSet<>());
                for(int find: nodes)
                    if(temp.contains(find))
                    {
                        bool= false;
                        break outer;
                    }
            }

            if(bool)
            {
                ans= Math.max(ans, nodes.size());
                //out.println(nodes);
            }
        }

        out.println(ans);
    }

    private void DFSREC(ArrayList<ArrayList<Integer>> list, boolean[] visited, int curr, HashSet<Integer> nodes) {
        visited[curr]= true;
        nodes.add(curr);

        for(int i: list.get(curr))
        {
            if(visited[i]) continue;
            DFSREC(list, visited, i, nodes);
        }
    }

    void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);

        solve();
        out.flush();
    }

    public static void main(String[] args) throws Exception {
        new PartyC1().run();
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

