import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class UniqueBidAuction
{
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        int t= sc.nextInt();

        for (int ii = 0; ii < t; ii++)
        {
            int n= sc.nextInt();
            int[] auction= new int[n];
            HashMap<Integer, Integer> map= new HashMap<>();
            HashSet<Integer> bid= new HashSet<>();
            HashSet<Integer> redundant= new HashSet<>();
            for (int i = 0; i < n; i++)
            {
                auction[i]= sc.nextInt();
                map.put(auction[i], i);
                if(bid.contains(auction[i]))
                    redundant.add(auction[i]);
                else
                    bid.add(auction[i]);
            }

            for(Integer i: redundant)
                bid.remove(i);

            int smallest_bid= Integer.MAX_VALUE;
            for(int i: bid)
                smallest_bid= Math.min(smallest_bid, i);

            System.out.println((smallest_bid!=0x7fffffff?map.get(smallest_bid)+1:-1));
        }
    }
}