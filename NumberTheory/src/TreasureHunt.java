import java.util.*;
import java.io.*;

/**
 * SOLUTION:
 *
 * so basically we have a starting position and an ending position and we have
 * to figure out that we can reach the destination from given four moves or not
 *
 * so basically the difference between the initial and final position should be
 * a multiple of the given value of valid moves.
 *
 * but there is one more condition that we have to check if the co-ordinates x
 * and y can be achieved simultaneously or not.
 *
 * as we can add and delete that value in the very next step its safe to say
 * that we can ignore and even number of moves.
 *
 * we can first take the x co-ordinate to its final position an check for the no
 * of moves required to do so.
 *     If its even then the initial co-ordinate of y does not changes else
 *     we can add or subtract the value of b from initial y.
 * And then all we have to do is check whether the no of steps required by the
 * y axis to reach its final position is even or odd.
 *
 * (i). If its even then we can reach the final position.
 * (ii). If its odd then we cant reach the final position.
 */

public class TreasureHunt {
    InputStream is;
    PrintWriter out;
    String INPUT = "";

    void solve() throws IOException {
        int start_x= ni(), start_y= ni(), final_x= ni(), final_y= ni();
        int a= ni(), b= ni();

        if(Math.abs(start_x- final_x)%a==0 && Math.abs(start_y- final_y)%b==0)
        {
            int steps= Math.abs(start_x- final_x)/a;
            if(steps%2!=0)
                start_y+= b;

            steps= Math.abs(start_y- final_y)/b;
            if(steps%2==0)
                out.println("YES");
            else
                out.println("NO");
        }
        else
            out.println("NO");
    }

    void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);

        solve();
        out.flush();
    }

    public static void main(String[] args) throws Exception {
        new TreasureHunt().run();
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

