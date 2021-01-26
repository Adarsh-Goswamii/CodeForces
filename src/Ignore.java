// CODE SNIPPETS- Adarsh Goswami.

class Snippets
{
    // for finding gcd of (a, b)
    int gcd1(int a, int b)
    {
        if(b== 0)
            return a;
        else
            return gcd1(b, a%b);
    }

    // for eq: ax+ by= c
    // returns {gcd, value of x, value of y}
    long[] gcd2(long a, long b, long c)
    {
        long x= 1, y= 0;
        long xt= 0, yt= 1, at= a, bt= b;
        while(bt!=0)
        {
            long q= at/ bt;

            long temp= xt;
            xt= x- q*xt;
            x= temp;

            temp= yt;
            yt= y- q*yt;
            y= temp;

            temp= bt;
            bt= at- q*bt;
            at= temp;
        }

        if(c% at!=0)
            return new long[]{-1l, 0l, 0l}; // solution does not exists

        x= x* (c/ at);
        y= y* (c/ at);

        return new long[]{at, x, y};
    }
}