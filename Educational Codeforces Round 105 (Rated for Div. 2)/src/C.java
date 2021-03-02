import java.util.*;
import java.io.*;

public class C {
    InputStream is;
    PrintWriter out;
    String INPUT = "";

    void solve() throws IOException {
        int t = ni();
        for (int ii = 0; ii < t; ii++) {
            int n= ni(), m= ni();
            Integer[] arr= new Integer[n];
            Integer[] arr2= new Integer[m];
            ArrayList<Integer> boxes_positive= new ArrayList<>();
            ArrayList<Integer> boxes_negative= new ArrayList<>();
            ArrayList<Integer> special_positive= new ArrayList<>();
            ArrayList<Integer> special_negative= new ArrayList<>();
            ArrayList<Integer> inplace_positive= new ArrayList<>();
            ArrayList<Integer> inplace_negative= new ArrayList<>();

            for (int i = 0; i < n; i++)
            {
                arr[i]= ni();
                if(arr[i]>0)
                    boxes_positive.add(arr[i]);
                else
                    boxes_negative.add(arr[i]);
            }

            HashSet<Integer> set= new HashSet<>();
            for (int i = 0; i < m; i++)
            {
                arr2[i]= ni();
                set.add(arr2[i]);
                if(arr2[i]>0)
                    special_positive.add(arr2[i]);
                else
                    special_negative.add(arr2[i]);
            }

            for(int i: arr)
            {
                if(set.contains(i))
                {
                    if(i>0)
                        inplace_positive.add(i);
                    else
                        inplace_negative.add(i);
                }
            }

            Collections.sort(inplace_positive);
            Collections.sort(special_positive);
            Collections.sort(boxes_positive);
            Arrays.sort(arr2);

            int ans_positive= 0;
            for(int i=0;i<m;i++)
            {
                if(arr2[i]<0) continue;
                else
                {
                    int boxes_before= binarySearchBefore(boxes_positive, arr2[i]);
                    int special_pos= binarySearchBefore(special_positive, arr2[i])- binarySearchBefore(special_positive, arr2[i]- boxes_before);
                    int inplace_after= binarySearchAfter(inplace_positive, arr2[i]+1);
                    ans_positive= Math.max(ans_positive, special_pos+ inplace_after);
                }
            }

            Collections.sort(inplace_negative);
            Collections.sort(special_negative);
            Collections.sort(boxes_negative);
            Arrays.sort(arr2, Collections.reverseOrder());

            int ans_negative= 0;
            for(int i=0;i<m;i++)
            {
                if(arr2[i]> 0) continue;
                else
                {
                    int boxes_after= binarySearchAfter(boxes_negative, arr2[i]);
                    int special_pos= binarySearchAfter(special_negative, arr2[i])- binarySearchAfter(special_negative, arr2[i]+ boxes_after);
                    int inplace_before= binarySearchBefore(inplace_negative, arr2[i]-1);
                    ans_negative= Math.max(ans_negative, special_pos+ inplace_before);
                }
            }

            out.println(ans_negative+ ans_positive);
        }
    }

    int binarySearchAfter(ArrayList<Integer> arr, int find)
    {
        int ret= arr.size();
        int start= 0, last= arr.size()-1;
        while(start<= last)
        {
            int mid= start+ (last- start)/2;

            if(arr.get(mid)>= find)
            {
                ret= mid;
                last= mid-1;
            }
            else
                start= mid+1;
        }

        return arr.size()- ret;
    }

    int binarySearchBefore(ArrayList<Integer> arr, int find)
    {
        int ret= -1;
        int start= 0, last= arr.size()-1;
        while(start<= last)
        {
            int mid= start+ (last- start)/2;
            if(arr.get(mid)<= find)
            {
                ret= mid;
                start= mid+1;
            }
            else
                last= mid-1;
        }

        return ret+1;
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

