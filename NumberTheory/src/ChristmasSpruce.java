import java.util.*;
import java.io.*;

public class ChristmasSpruce {
    Reader in;
    PrintWriter out;

    void solve() throws IOException {
        int t= in.ni();
        int[] parent= new int[t];
        HashSet<Integer> non_leaf= new HashSet<>();
        parent[0]= -1;

        for(int i=1;i<parent.length;i++)
        {
            parent[i]= in.ni()-1;
            non_leaf.add(parent[i]);
        }

        int[] leaf_child= new int[t];
        for(int i=1;i<parent.length;i++)
            leaf_child[parent[i]]+= (non_leaf.contains(i)? 0: 1);

        String ans="Yes";
        for(int i=0;i<leaf_child.length;i++)
            if(leaf_child[i]<3 && non_leaf.contains(i))
            {
                //out.println(i);
                ans= "No";
            }

        out.println(ans);
    }

    void run() throws Exception {
        in = new Reader();
        out = new PrintWriter(System.out);

        solve();
        out.flush();
    }

    public static void main(String[] args) throws Exception {
        new ChristmasSpruce().run();
    }

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String ns() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public String ns(boolean bool) {
            Scanner sc = new Scanner(System.in);
            return sc.nextLine();
        }

        public int ni() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nl() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nd() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }
}
