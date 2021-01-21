import java.util.*;
import java.io.*;

public class ArrayDestruction {
    InputStream is;
    PrintWriter out;
    String INPUT = "";

    void solve() throws IOException {
        int t = ni();
        for (int ii = 0; ii < t; ii++)
        {
            int n=ni();
            HashMap<Integer, Integer> map= new HashMap<>();
            ArrayList<Integer> arr= new ArrayList<>();
            for(int i=0;i<2*n;i++)
            {
                int key= ni();
                map.put(key, map.getOrDefault(key, 0)+ 1);
                arr.add(key);
            }

            PriorityQueue<Integer> q= new PriorityQueue<>((a, b)-> (b-a));
            for(int i: map.keySet())
                q.add(i);

            Collections.sort(arr, Collections.reverseOrder());
            int max= arr.get(0);
            for(int i=1;i<arr.size();i++) {
                if (call(clone(map), clone(q), max + arr.get(i)))
                    break;
                else if (i == arr.size() - 1)
                    out.println("NO");
            }
        }
    }

    HashMap<Integer, Integer> clone(HashMap<Integer, Integer> map)
    {
        HashMap<Integer, Integer> ret= new HashMap<>();
        for(int i: map.keySet())
            ret.put(i, map.get(i));

        return ret;
    }

    PriorityQueue<Integer> clone(PriorityQueue<Integer> q)
    {
        PriorityQueue<Integer> ret= new PriorityQueue<>((a, b)-> (b-a));
        for(int i: q)
            ret.add(i);

        return ret;
    }

    boolean call(HashMap<Integer, Integer> map, PriorityQueue<Integer> q, int x)
    {
        boolean ans= true;
        int prev= x;
        ArrayList<Integer[]> pairs= new ArrayList<>();
        int c= 1, p1=0, p2= 0;
        while(!map.isEmpty())
        {
            int max= -1;
            while(true)
            {
                max= q.peek();
                if(map.containsKey(max))
                    break;
                else
                    q.poll();
            }

            map.put(max, map.get(max)-1);
            if(map.get(max)== 0)
                map.remove(max);

            if(!map.containsKey(prev- max))
            {
                ans= false;
                break;
            }
            else {
                pairs.add(new Integer[]{max, prev - max});
                map.put(prev - max, map.get(prev - max) - 1);
                if (map.get(prev - max) == 0)
                    map.remove(prev - max);
                prev = max;
            }
        }

        if(ans)
        {
            StringBuilder br= new StringBuilder();
            br.append("YES"+"\n");
            br.append(x+"\n");
            //out.println(pairs.get(pairs.size()-1)[0]+" "+pairs.get(pairs.size()-1)[1]);
            for(int i=0;i<pairs.size();i++)
                br.append(pairs.get(i)[0]+" "+pairs.get(i)[1]+"\n");

            out.print(br);
            return true;
        }
        else
            return false;
    }

    void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);

        solve();
        out.flush();
    }

    public static void main(String[] args) throws Exception {
        new ArrayDestruction().run();
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

