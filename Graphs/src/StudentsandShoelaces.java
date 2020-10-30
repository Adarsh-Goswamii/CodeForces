import java.util.*;
import java.io.*;

/**
 *
 SOLUTION:
 So if a student is just connected to one partner then they get
 accumulated in a room and get expelled.

 Then the graph changes as some student has left the class and
 then again we repeat the same procedure until
 (i). there are no students to expelled.
 (ii). There are no student who is just connected to one other
 student.

 Adjacency list representation.

 we need to traverse the graph and find all the students that have
 only one connected person.

 So how can we judge that a person is just connected to one person
 if we can go to only one person from that node that means that he
 is going to get reprimand.

 So for the sake of changes will be made in the graphs we can keep
 an array of expelled nodes so that we can come to know that a
 particular edge is no longer existing.

 */

public class StudentsandShoelaces {
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
            int a= ni(), b= ni();
            arrayLists.get(a).add(b);
            arrayLists.get(b).add(a);
        }

        boolean[] expelled= new boolean[n+1];
        int ans=0;
        while(true)
        {
            boolean[] visited= new boolean[n+1];
            Queue<Integer> queue =  new LinkedList<>();
            int count_expelled = 0;
            ArrayList<Integer> list =  new ArrayList<>();
            for(int i=1;i<=n;i++)
            {
                if(!expelled[i] && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;

                    while (!queue.isEmpty()) {
                        int curr = queue.poll();
                        int expell= 0;

                        for (int ii : arrayLists.get(curr)) {
                            if (expelled[ii]) continue;
                            expell++;
                            if (visited[ii]) continue;
                            queue.add(ii);
                            visited[ii] = true;
                        }

                        if(expell== 1)
                        {
                            count_expelled++;
                            //out.println("expell "+ans+" ="+curr);
                            list.add(curr);
                        }
                    }
                }
            }

            for(int i: list)
                expelled[i]= true;

            if(count_expelled==0)
                break;
            ans++;
        }

        out.println(ans);
    }

    void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);

        solve();
        out.flush();
    }

    public static void main(String[] args) throws Exception {
        new StudentsandShoelaces().run();
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

