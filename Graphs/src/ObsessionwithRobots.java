import java.util.*;
import java.io.*;

public class ObsessionwithRobots {
    InputStream is;
    PrintWriter out;
    String INPUT = "";

    void solve() throws IOException {
        boolean[][] maze= new boolean[201][201];
        int row= 100, col= 100;
        char[] path= ns().toCharArray();
        maze[row][col]= true;

        for(int i=0;i<path.length;i++)
        {
            if(path[i]=='U')
                row++;
            else if(path[i]=='D')
                row--;
            else if(path[i]=='L')
                col--;
            else
                col++;

            maze[row][col]= true;
        }

        Queue<Integer> queue =  new LinkedList<>();
        queue.add(100);
        queue.add(100);
        maze[100][100]= false;

        int min_steps=0;
        outer:while(!queue.isEmpty())
        {
            int size= queue.size();
            for(int i=0;i<size/2;i++)
            {
                int curr_row= queue.poll();
                int curr_col= queue.poll();
                if(curr_row== row && curr_col== col)
                    break outer;

                if(curr_col+1<=200 && maze[curr_row][curr_col+1])
                {
                    queue.add(curr_row);
                    queue.add(curr_col+ 1);
                    maze[curr_row][curr_col+1]= false;
                }

                if(curr_col-1>=0 && maze[curr_row][curr_col-1])
                {
                    queue.add(curr_row);
                    queue.add(curr_col- 1);
                    maze[curr_row][curr_col-1]= false;
                }

                if(curr_row+1<=200 && maze[curr_row+1][curr_col])
                {
                    queue.add(curr_row+1);
                    queue.add(curr_col);
                    maze[curr_row+1][curr_col]= false;
                }

                if(curr_row-1>=0 && maze[curr_row-1][curr_col])
                {
                    queue.add(curr_row-1);
                    queue.add(curr_col);
                    maze[curr_row-1][curr_col]= false;
                }
            }

            min_steps++;
        }
        //out.println(min_steps);
        out.println((min_steps== path.length)? "OK": "BUG");
    }

    void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);

        solve();
        out.flush();
    }

    public static void main(String[] args) throws Exception {
        new ObsessionwithRobots().run();
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

