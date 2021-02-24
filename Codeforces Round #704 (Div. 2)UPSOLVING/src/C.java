import java.util.*;
import java.io.*;

public class C {
    InputStream is;
    PrintWriter out;
    String INPUT = "";

    void solve() throws IOException {
        int n= ni(), m= ni();
        char[] s= ns(n), t= ns(m);

        HashMap<Character, List<Integer>> map = new HashMap<>();
        for(int i=0;i<s.length;i++)
        {
            if(map.containsKey(s[i]))
                map.get(s[i]).add(i+1);
            else
            {
                ArrayList<Integer> list= new ArrayList<>();
                list.add(i+1);
                map.put(s[i], list);
            }
        }

        int[] all= new int[26];
        for(char c: t)
            all[c-'a']++;

        int[] max= new int[m];
        for(int i=m-1;i>=0;i--)
        {
            char next= t[i];
            max[i]= binarySearch(map.get(next), 0, map.get(next).size()-1, i==m-1? n: max[i+1]-1);
        }

        int[] min= new int[m];
        for(int i=0;i<m;i++)
        {
            char next= t[i];
            min[i]= binarySearch2(map.get(next), 0, map.get(next).size()-1, i==0? 1: min[i-1]+1);
        }

        int ans= 0;
        for(int i=1;i<m;i++)
            ans= Math.max(ans, max[i]- min[i-1]);

        out.println(ans);
    }

    private int binarySearch(List<Integer> arr, int start, int last, int find) {
        int ret= -1;
        while(start<= last)
        {
            int mid= start+ (last- start)/2;

            if(arr.get(mid)== find)
                return arr.get(mid);
            else if(arr.get(mid)< find)
            {
                ret= arr.get(mid);
                start= mid+1;
            }
            else
                last= mid-1;
        }

        return ret;
    }

    private int binarySearch2(List<Integer> arr, int start, int last, int find) {
        int ret= -1;
        while(start<= last)
        {
            int mid= start+ (last- start)/2;

            if(arr.get(mid)== find)
                return arr.get(mid);
            else if(arr.get(mid)> find)
            {
                ret= arr.get(mid);
                last= mid-1;
            }
            else
                start= mid+1;
        }

        return ret;
    }

    void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);

        solve();
        out.flush();
    }

    public static void main(String[] args) throws Exception {
        new C().run();
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

