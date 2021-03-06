import java.util.*;
import java.io.*;

public class DistrictsConnection {
    InputReader in;
    PrintWriter out;

    void solve()
    {
        int t= in.nextInt();

        for(int ii=0;ii<t;ii++)
        {
            int n= in.nextInt();
            int[] arr= new int[n];

            for(int i=0;i<n;i++)
                arr[i]= in.nextInt();

            HashMap<Integer, HashSet<Integer>> map= new HashMap<>();
            for(int i=0;i<n;i++)
            {
                if(map.containsKey(arr[i]))
                    map.get(arr[i]).add(i+1);
                else
                {
                    HashSet<Integer> set= new HashSet<>();
                    set.add(i+1);
                    map.put(arr[i], set);
                }
            }

            HashSet<Integer> connected= new HashSet<>();
            connected.add(1);
            StringBuilder br= new StringBuilder();

            for(int i=1;i<=n;i++)
            {
                for(int j=1;j<=n;j++)
                {
                    if(connected.contains(j)) continue;

                    if(!map.get(arr[i-1]).contains(j))
                    {
                        br.append("\n"+i+" "+j);
                        connected.add(j);
                    }
                }
            }
            //out.println(connected);
            if(connected.size()==n)
                out.println("YES"+br);
            else
                out.println("NO");

        }


    }

    void run() throws Exception {
        in = new InputReader(System.in);
        out = new PrintWriter(System.out);

        solve();
        out.flush();
    }

    public static void main(String[] args) throws Exception {
        new DistrictsConnection().run();
    }

    static class InputReader {

        private final InputStream stream;
        private final byte[] buf = new byte[8192];
        private int curChar, snumChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int snext() {
            if (snumChars == -1)
                throw new InputMismatchException();
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long nextLong() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int[] nextIntArray(int n) {
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }

        public String readString() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public String nextLine() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isEndOfLine(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }
}
