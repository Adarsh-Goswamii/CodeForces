import java.util.*;
import java.io.*;

/**
 * SOLUTION:
 *
 * So we have n number of days and n socks too. Indexed from 1 to n
 *
 * we got k colors of socks and we have paints too of all the colors.
 *
 * And our aim is to follow the instructions and don't look like a clown too
 * and for that we are going to paint some of the socks and we are obviously lazy
 * so we want to paint the min no of socks.
 *
 * So what we can do is we can have a ArrayList of sets each containing all the
 * pairs for example if socks with index 2 is to be wore with lets say 1 and 3
 * indexed socks this can tell us the the optimal way but way to lengthy.
 *
 * Maybe we can create a graph between all the pairs of socks that need to be
 * wore. And then all the nodes that's directly connected will have to be of the
 * same color..............so basically the connected component should have the
 * same color. Now the best way to do it would be just find the max no of socks
 * of particular color and paint everyone else with that color.
 *
 * Okay what could be the efficient way to assign color or lets say know the max
 * no of socks of the same component that share a common color..................
 * ..................simple use an array, max and color variables which will
 * will keep a track of the max colored socks.
 *
 * Okay so [TLE] on test case 33
 * reason could be that when there are 2* 10^5 colors and lets assume there are
 * only 2 nodes in every connected components then assigning an array with k size
 * will result in a time complexity of O((n+m). k)
 *     Basically DFS takes on n+m and the k comes for the array that we assign.
 *
 * So we need a more efficient way to do this.I think map will work fine over here
 * were key can be the color and the data part cna be the no of socks. [AC]
 */

public class Socks {
    InputStream is;
    PrintWriter out;
    String INPUT = "";
    HashMap<Integer, Integer> socks;
    int max, component;

    void solve() throws IOException
    {
        int n= ni(), m= ni(), k= ni();
        int[] color= new int[n+1];
        for (int i = 1; i <=n; i++)
            color[i]= ni();

        ArrayList<ArrayList<Integer>> arrayLists= new ArrayList<>();
        for (int i = 0; i <=n; i++)
            arrayLists.add(new ArrayList<>());

        for (int i = 0; i < m; i++)
        {
            int from= ni(), to =ni();
            arrayLists.get(from).add(to);
            arrayLists.get(to).add(from);
        }

        int ans=0;
        boolean[] visited= new boolean[n+1];
        for (int i = 1; i <=n; i++)
        {
            if(visited[i]) continue;
            socks= new HashMap<>();
            max=0; component=0;
            DFSREC(arrayLists, visited, i, color);
            ans+= (component- max);
        }
        out.println(ans);
    }

    private void DFSREC(ArrayList<ArrayList<Integer>> arrayLists, boolean[] visited, int curr, int[] color)
    {
        visited[curr]= true;
        socks.put(color[curr], socks.getOrDefault(color[curr], 0)+1);
        max= Math.max(max, socks.get(color[curr]));
        component++;

        for(int i: arrayLists.get(curr))
        {
            if(visited[i]) continue;
            DFSREC(arrayLists, visited, i, color);
        }
    }

    void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);

        solve();
        out.flush();
    }

    public static void main(String[] args) throws Exception {
        new Socks().run();
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

