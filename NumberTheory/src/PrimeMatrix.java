import javax.naming.PartialResultException;
import java.util.*;
import java.io.*;

/**
 * SOLUTION:
 *
 * nxm matrix
 *
 * so change a row or a column to all primes. That will make the matrix as a prime
 * matrix.
 *
 * And we have to return the minimum steps needed to make the matrix as prime
 * matrix.
 *
 * So one efficient solution can be to find all the prime numbers from 2- 10^5
 * as the max value of the matrix will be only 10^5.
 *
 * And store all this primes in a sorted fashion as we are going to use binary
 * search to find the most closest value to a given number.
 *
 * then all we have to do is traverse the array and find the minimum number
 * of steps to make out matrix as an prime matrix.
 *
 * How to do that?
 * (i). replace all the numbers of the matrix by the steps required to make them
 * prime.
 *
 * (ii). now the question has reduced to finding the min sum of a row or a column.
 */

public class PrimeMatrix {
    InputStream is;
    PrintWriter out;
    String INPUT = "";
    ArrayList<Integer> primes;

    void solve() throws IOException {
        int n= ni(), m= ni();
        int[][] arr= new int[n][m];

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
                arr[i][j]= ni();
        }

        sieve();

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
                arr[i][j]= binarySearch(arr[i][j], 0, primes.size()-1)- arr[i][j];
        }

        int ans= Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            int sum=0;
            for(int j=0;j<m;j++)
            {
                if(sum> ans)
                    break;
                else
                    sum+= arr[i][j];
            }
            ans= Math.min(ans, sum);
        }

        for(int i=0;i<m;i++)
        {
            int sum=0;
            for(int j=0;j<n;j++)
            {
                if(sum> ans)
                    break;
                else
                    sum+= arr[j][i];
            }
            ans= Math.min(ans, sum);
        }

        out.println(ans);
    }

    private int binarySearch(int find, int start, int last)
    {
        while(start<= last)
        {
            int mid= start+ (last- start)/2;

            if(primes.get(mid)== find)
                return find;
            else if(primes.get(mid)> find)
                last= mid-1;
            else
                start= mid+1;
        }
        return primes.get(start);
    }

    private void sieve()
    {
        boolean[] composite= new boolean[100000];
        for(int i=2;i*i<= composite.length;i++)
        {
            if(composite[i]) continue;
            for(int j=i*i;j< composite.length;j+=i)
                composite[j]= true;
        }

        primes= new ArrayList<>();
        for(int i=2;i<composite.length;i++)
            if(!composite[i]) primes.add(i);
        primes.add(100003);
    }

    void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);

        solve();
        out.flush();
    }

    public static void main(String[] args) throws Exception {
        new PrimeMatrix().run();
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

