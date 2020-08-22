import java.io.*;
import java.util.*;
public class TernarySequence
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter w=new PrintWriter(System.out);

        int t= Integer.parseInt(br.readLine());
        for(int ii=0;ii<t;ii++)
        {
            StringTokenizer st=new StringTokenizer(br.readLine());
            StringTokenizer st2=new StringTokenizer(br.readLine());
            long zero1= Long.parseLong(st.nextToken()), one1= Long.parseLong(st.nextToken()), two1= Long.parseLong(st.nextToken());
            long zero2= Long.parseLong(st2.nextToken()), one2= Long.parseLong(st2.nextToken()), two2= Long.parseLong(st2.nextToken());

            long ans=0;
            ans+= 2* Math.min(two1, one2);
            two1-= Math.min(two1, one2);
            one2-= Math.min(two1, one2);

            two2-= Math.min(zero1, two2);
            zero1-= Math.min(zero1, two2);

            two2-= Math.min(two1, two2);
            two1-= Math.min(two1, two2);

            ans-= (2* two2);
            w.println(ans);
        }
        w.close();
    }
}