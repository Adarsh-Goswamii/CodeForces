import java.util.Scanner;

public class solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int ii = 0; ii < t; ii++)
        {
            int n = sc.nextInt();
            int[] arr = new int[n];
            sc.nextLine();
            String s = sc.nextLine();
            String st = "2020";
            int aaaa=0;
            int c = 0, diff = 0, z = 0, d = 0;

            char[] ans = {'2','0','2','0'};
            char[] ch = s.toCharArray();
            int check = 0;
            for (int i = 0; i < ch.length; i++)
            {
                if (check == 0)
                {
                    String ss ="";

                    if (ch[i] == ans[0])
                    {
                        int m = i;
                        c = 1;
                        check = 1;
                        ss += ch[i];
                        while (ch[++m] == ans[c]) {
                            ss += ch[i];
                            c = c + 1;
                        }
                        if (ss.equals(st))
                        {
                            aaaa = 1;
                            break;
                        }
                        char[] ans1 = ss.toCharArray();
                        diff = ans.length - ans1.length;
                        d = diff;

                    }
                    check=1;

                }//main if =0
                if (check == 1)
                { System.out.println(i);
                    if (ch[i] == ans[c])
                    {
                        while (diff != 0)
                        {
                            if (ch[i++] == ans[c++])
                                z++;
                            diff--;
                        }
                        if (z == d)
                            aaaa = 1;
                        else
                            z = 0;
                    }
                }
            } //for main loop
            if (aaaa==1)
                System.out.println("yes");
            else
                System.out.println("no");

        } //loop t

    }
}