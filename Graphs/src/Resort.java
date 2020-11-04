import java.util.*;
import java.io.*;

public class Resort {
    InputStream is;
    PrintWriter out;
    String INPUT = "";

    void solve() throws IOException {
        int n=ni();
        boolean[] mountain= new boolean[n+1];
        for (int i = 1; i <=n; i++)
            mountain[i]= ni() ==0;

        int[] parent= new int[n+1];
        int[] outdegree= new int[n+1];
        for (int i = 1; i <=n; i++)
        {
            parent[i]= ni();
            outdegree[parent[i]]++;
        }

        ArrayList<ArrayList<Integer>> list= new ArrayList<>();
        for (int i = 0; i <=n; i++)
            list.add(new ArrayList<>());

        int[] indegree= new int[n+1];
        for (int i = 1; i <=n; i++)
        {
            if(outdegree[parent[i]]>1 || outdegree[i]>2 || parent[i]==0) continue;
            list.get(parent[i]).add(i);
            indegree[i]++;
        }

//        out.println(list);
//        for (int i = 1; i <=n; i++)
//            out.print(outdegree[i]+" ");
//        out.println();
//
//        for (int i = 1; i <=n; i++)
//            out.print(indegree[i]+" ");
//        out.println();

        ArrayList<Integer> ans= new ArrayList<>();
        for(int i=1;i<=n;i++)
        {
            if(indegree[i]==0 && outdegree[i]<=1)
            {
                ArrayList<Integer> temp= new ArrayList<>();
                DFSREC(list, i, temp);

                if(!mountain[temp.get(temp.size()-1)] && ans.size()<temp.size())
                {
                    ans= temp;
//                    out.println(ans);
                }
            }
        }
        out.println(ans.size());
        for(int i: ans)
            out.print(i+" ");
        out.println();
    }

    private void DFSREC(ArrayList<ArrayList<Integer>> list, int curr, ArrayList<Integer> temp)
    {
        temp.add(curr);

        for(int i: list.get(curr))
            DFSREC(list,  i, temp);
    }

    void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);

        solve();
        out.flush();
    }

    public static void main(String[] args) throws Exception {
        new Resort().run();
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

