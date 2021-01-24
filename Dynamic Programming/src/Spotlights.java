import java.util.*;
import java.io.*;

public class Spotlights {
    InputStream is;
    PrintWriter out;
    String INPUT = "";
    int up= 1, down= 2, left= 3, right= 4;

    void solve() throws IOException {
        int n = ni(), m = ni();
        int[][][] arr = new int[n][m][5];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                arr[i][j] = new int[]{ni(), 0, 0, 0, 0};

        boolean found = false;
        for (int i = 0; i < n; i++)
        {
            found= false;
            for (int j = 0; j < m; j++)
            {
                if (arr[i][j][0] == 1) found = true;
                else arr[i][j][left] = found ? 1 : 0;
            }
        }

        for (int i = 0; i < n; i++)
        {
            found= false;
            for (int j = m-1; j>=0; j--)
            {
                if (arr[i][j][0] == 1) found = true;
                else arr[i][j][right] = found ? 1 : 0;
            }
        }

        for (int i = 0; i < m; i++)
        {
            found= false;
            for (int j = 0; j < n; j++)
            {
                if (arr[j][i][0] == 1) found = true;
                else arr[j][i][up] = found ? 1 : 0;
            }
        }

        for (int i = 0; i < m; i++)
        {
            found= false;
            for (int j = n-1; j>= 0; j--)
            {
                if (arr[j][i][0] == 1) found = true;
                else arr[j][i][down] = found ? 1 : 0;
            }
        }

        int ans= 0;
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                if(arr[i][j][0]== 0)
                    for(int k=1;k<5;k++)
                        ans+= arr[i][j][k];

        out.println(ans);

//        for(int i=0;i<n;i++) {
//            for (int j = 0; j < m; j++) {
//                out.println(i + " " + j + " ");
//                for (int k = 0; k < 5; k++)
//                    out.print(arr[i][j][k] + " ");
//                out.println();
//            }
//        }
    }

//    private void one(int[][][] arr, int row, int col, int n, int m)
//    {
//        // up
//        for(int i= row+1;i<n;i++)
//            arr[i][col][up]= 1;
//
//        // down
//        for(int i=0;i<row;i++)
//            arr[i][col][down]= 1;
//
//        // left
//        for(int i= col+1;i<m;i++)
//            arr[row][i][left]= 1;
//
//        // right
//        for(int i=0;i<col;i++)
//            arr[row][i][right]= 1;
//    }

    void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);

        solve();
        out.flush();
    }

    public static void main(String[] args) throws Exception {
        new Spotlights().run();
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

