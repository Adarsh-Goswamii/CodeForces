import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;
import java.io.*;

public class Coach {
    InputStream is;
    PrintWriter out;
    String INPUT = "";

    void solve() throws IOException {
        int n= ni(), m= ni();
        ArrayList<ArrayList<Integer>> arrayLists =  new ArrayList<>();
        for(int i=0;i<=n;i++)
            arrayLists.add(new ArrayList<>());

        for(int i=0;i<m;i++)
        {
            int a= ni() , b= ni();
            arrayLists.get(a).add(b);
            arrayLists.get(b).add(a);
        }

        boolean[] visited= new boolean[n+1];
        HashMap<Integer, ArrayList<ArrayList<Integer>>> map =  new HashMap<>();
        map.put(1, new ArrayList<>());
        map.put(2, new ArrayList<>());
        StringBuilder br= new StringBuilder();
        for(int i=1;i<=n;i++)
        {
            if(visited[i]) continue;
            ArrayList<Integer> len= new ArrayList<Integer>();
            DFSREC(arrayLists,  visited, i, len);
            if(len.size()> 3)
            {
                out.println("-1");
                return;
            }
            else if(len.size()== 3)
            {
                br.append(len.get(0)+" "+len.get(1)+" "+len.get(2)+"\n");
            }
            else
            {
                if(map.containsKey(len.size()))
                    map.get(len.size()).add(len);
                else
                {
                    ArrayList<ArrayList<Integer>> temp= new ArrayList<>();
                    temp.add(len);
                    map.put(len.size(), temp);
                }
            }
        }

        if(map.getOrDefault(1, new ArrayList<>()).size()< map.getOrDefault(2, new ArrayList<>()).size())
            out.println("-1");
        else
        {
            ArrayList<ArrayList<Integer>> one= map.get(1);
            ArrayList<ArrayList<Integer>> two= map.get(2);
            out.print(br);
            int i;
            for(i=0;i<two.size();i++)
            {
                out.println(one.get(i).get(0)+" "+two.get(i).get(0)+" "+two.get(i).get(1));
            }

            int count=1;
            for(;i<one.size();i++)
            {
                if(count%3==0)
                    out.println(one.get(i).get(0));
                else
                    out.print(one.get(i).get(0)+" ");
                count++;
            }
        }
    }

    private void DFSREC(ArrayList<ArrayList<Integer>> arrayLists, boolean[] visited, int curr, ArrayList<Integer> len)
    {
        visited[curr]= true;
        len.add(curr);

        for(Integer integer: arrayLists.get(curr))
        {
            if(visited[integer]) continue;
            DFSREC(arrayLists, visited, integer, len);
        }
    }

    void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);

        solve();
        out.flush();
    }

    public static void main(String[] args) throws Exception {
        new Coach().run();
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

