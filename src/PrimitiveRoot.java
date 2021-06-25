import java.util.*;
import java.io.*;

public class PrimitiveRoot {
    public static void main(String[] args) {
        new PrimitiveRoot().run();
    }

    private void run() {

    }

    final int mod =   998244353;
    final int root = 3; // primitive root of mod
    final int root_1 = 332748118; // inverse of primitive root
    final int root_pw = 1 << 23; // prime= c*2^root_pw+1
    private void calcFinalValues() {
        System.out.println("primitive root: "+generator(mod));
        System.out.println("inverse: "+binExp(3, mod-2));
        for(int i=31;i>=0;i--) {
            if((mod-1)%(1<<i)== 0) {
                System.out.println("root_pw: "+i);
                break;
            }
        }
    }

    void fft(List<Integer> a, boolean invert) {
        int n = a.size();

        for (int i = 1, j = 0; i < n; i++) {
            int bit = n >> 1;
            for (; (j & bit)== 1; bit >>= 1)
                j ^= bit;
            j ^= bit;

            if (i < j) {
                int x= a.get(i), y= a.get(j);
                x= x^y; y= x^y; x= x^y;
                a.set(i, y);
                a.set(j, x);
            }
        }

        for (int len = 2; len <= n; len <<= 1) {
            int wlen = invert ? root_1 : root;
            for (int i = len; i < root_pw; i <<= 1)
                wlen = (int) (1L* wlen * wlen % mod);

            for (int i = 0; i < n; i += len) {
                int w = 1;
                for (int j = 0; j < len / 2; j++) {
                    int u = a.get(i + j), v = (int) (1L * a.get(i + j + len / 2) * w % mod);
                    a.set(i + j,  u + v < mod ? u + v : u + v - mod);
                    a.set(i + j + len / 2, u - v >= 0 ? u - v : u - v + mod);
                    w = (int) (1L * w * wlen % mod);
                }
            }
        }

        if (invert) {
            int n_1 = (int)binExp(n, mod-2);
            for (int x:a)
                x = (int) (1L * x * n_1 % mod);
        }
    }

    static int generator(int p) {
        List<Integer> fact = new ArrayList<>();
        int phi = p - 1, n = phi;
        for (int i = 2; i * i <= n; ++i)
            if (n % i == 0) {
                fact.add(i);
                while (n % i == 0)
                    n /= i;
            }
        if (n > 1)
            fact.add(n);

        for (int res = 2; res <= p; ++res) {
            boolean ok = true;
            for (int i = 0; i < fact.size() && ok; ++i)
                ok &= powmod(res, phi / fact.get(i), p) != 1;
            if (ok) return res;
        }

        return -1;
    }

    static int powmod(int a, int b, int p) {
        int res = 1;
        while (b != 0)
            if ((b & 1) == 1) {
                res = (int) (res * 1l * a % p);
                --b;
            } else {
                a = (int) (a * 1l * a % p);
                b >>= 1;
            }
        return res;
    }

    long binExp(long base, long power) {
        long res = 1l;
        while (power != 0) {
            if ((power & 1) == 1) res = mul(res, base);
            base = mul(base, base);
            power >>= 1;
        }
        return res;
    }

    long mul(long a, long b) {
        return (a * b) % mod;
    }
}