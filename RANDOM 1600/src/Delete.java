import java.io.*;
import java.util.*;
class Solution2 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String s= sc.nextLine();

        if(s.length()!= 12) System.out.println("Invalid Input");
        else {
            if(s.charAt(2)> '9' && s.charAt(2)<'0') {
                System.out.println("Invalid Batch Code");
                return;
            }

            for(int i=0;i<4;i++) {
                if(i== 2) continue;
                if(s.charAt(i)>'Z' ||s.charAt(i)<'A') {
                    System.out.println("Invalid Batch Code");
                    return;
                }
            }

            int year= Integer.parseInt(s.substring(4, 8));
            int month= Integer.parseInt(s.substring(8, 10));
            int day= Integer.parseInt(s.substring(10, 12));

            if(year> 2020 || year<2015) System.out.println("Invalid Year");
            else if(month<1 || month>12) System.out.println("Invalid Month");
            else if(day<1 || day>31) System.out.println("Invalid Date");
            else {
                System.out.println("Batch Number: "+s.substring(0, 4));
                System.out.println("Expiry Date: "+day+"/"+month+"/"+year);
            }
        }
    }
}
				