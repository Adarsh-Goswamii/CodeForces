import java.io.PrintWriter;
import java.util.Scanner;

public class BoboniuLikesToColorBalls
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        PrintWriter w=new PrintWriter(System.out);

        int t= sc.nextInt();
        outer: for(int ii=0;ii<t;ii++)
        {
            int[] color=new int[]{sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()};

            int odd=0;
            for(int i: color)
                if(i%2==1)
                    odd++;

            if(odd==0 || odd==1)
                w.println("Yes");
            else
            {
                odd=0;
                for(int i=0;i<3;i++)
                    if(color[i]==0)
                    { w.println("No"); continue outer; }
                    else if((color[i]-1)%2==1)
                        odd++;

                if(odd==0 ||( odd==1 && color[3]%2==1 ))
                    w.println("Yes");
                else
                    w.println("No");
            }
        }
        w.close();
    }
}
