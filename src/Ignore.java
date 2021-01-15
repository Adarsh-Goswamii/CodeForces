import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            long n=sc.nextLong();
            long k=sc.nextLong();
            long x=sc.nextLong();
            long y=sc.nextLong();
            if(x==0 && y==0 || x==0&& y==n||x==n&& y==n|| x==n && y==0)
                System.out.println(x+" "+y);
            else
            {
                boolean clock=false,anticlock=false;
                while(x!=n&& y!=n)
                {
                    x=x+1;
                    y=y+1;
                }
                if(x==n&& y==n)
                    System.out.println(x+" "+y);
                else
                {
                    if(x==n)
                        anticlock=true;
                    else
                        clock=true;
                    k--;
                    while(k!=0)
                    {
                        if(clock && x==n)
                        {
                            while(y!=0)
                            {
                                x=x-1;
                                y=y-1;
                            }
                            if(x==0 && y==0)
                                break;
                            else
                                k--;
                        }
                        else if(anticlock && x==n)
                        {
                            while(y!=n)
                            {
                                x=x-1;
                                y=y+1;
                            }
                            if(x==0 && y==n)
                                break;
                            else
                                k--;
                        }
                        else if(clock && y==n)
                        {
                            while(x!=n)
                            {
                                x=x+1;
                                y=y-1;
                            }
                            if(x==n && y==0)
                                break;
                            else
                                k--;
                        }
                        else if(anticlock && y==n)
                        {
                            while(x!=0)
                            {
                                x=x-1;
                                y=y-1;
                            }
                            if(x==0 && y==0)
                                break;
                            else
                                k--;
                        }
                        else if(clock && x==0)
                        {
                            while(y!=n)
                            {
                                x=x+1;
                                y=y+1;
                            }
                            if(x==n && y==n)
                                break;
                            else
                                k--;
                        }
                        else if(anticlock && x==0)
                        {
                            while(y!=0)
                            {
                                x=x+1;
                                y=y-1;
                            }
                            if(x==n && y==0)
                                break;
                            else
                                k--;
                        }
                        else if(clock && y==0)
                        {
                            while(x!=0)
                            {
                                x=x-1;
                                y=y+1;
                            }
                            if(x==0 && y==n)
                                break;
                            else
                                k--;
                        }
                        else
                        {
                            while(x!=n)
                            {
                                x=x+1;
                                y=y+1;
                            }
                            if(x==n && y==n)
                                break;
                            else
                                k--;
                        }
                    }
                    System.out.println(x+" "+y);
                }
            }

        }
    }
}