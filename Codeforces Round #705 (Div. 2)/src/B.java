import java.util.*;
import java.io.*;

public class B {
    InputStream is;
    PrintWriter out;
    String INPUT = "";
    int h, m;

    void solve() throws IOException {
        map= new HashMap<>();

        map.put('0', '0');
        map.put('1', '1');
        map.put('2', '5');
        map.put('5', '2');
        map.put('8', '8');

        int t = ni();
        for (int ii = 0; ii < t; ii++) {
            h= ni(); m= ni();
            String s= ns();
            char[] arr= s.toCharArray();

            while(true)
            {
                String ans= reflection_valid(arr);
                if(ans!= null)
                {
                    out.println(new String(arr));
                    break;
                }

                int hour= Integer.parseInt(s.substring(0, s.indexOf(':')));
                int minute= Integer.parseInt(s.substring(s.indexOf(':')+1, s.length()));
                minute++;
                if(minute== m)
                {
                    hour++;
                    minute= 0;
                }

                if(hour== h)
                    hour= 0;

                arr= new char[]{'0', '0', ':', '0', '0'};

                int index= 1;
                while(hour!= 0)
                {
                    arr[index--]= (char)(hour%10+48);
                    hour/= 10;
                }

                index= 4;
                while(minute!= 0)
                {
                    arr[index--]= (char)(minute%10+48);
                    minute/= 10;
                }

                s= new String(arr);
            }

        }
    }

    Map<Character, Character> map;
    private String reflection_valid(char[] arr)
    {
        StringBuilder br= new StringBuilder(new String(arr));
        br.reverse();
        arr= br.toString().toCharArray();


        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]== ':') continue;
            if(map.containsKey(arr[i]))
                arr[i]= map.get(arr[i]);
            else
                return null;
        }
        String s= new String(arr);

        int hour= Integer.parseInt(s.substring(0, s.indexOf(':')));
        int minute= Integer.parseInt(s.substring(s.indexOf(':')+1, s.length()));

        if(hour<h && minute< m)
            return s;

        return null;
    }

    void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);

        solve();
        out.flush();
    }

    public static void main(String[] args) throws Exception {
        new B().run();
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

