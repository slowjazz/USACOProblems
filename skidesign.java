/*
ID: kenkrak1
LANG: JAVA
TASK: skidesign
 */

import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class skidesign {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("skidesign.in"));
        PrintWriter out = new PrintWriter(new FileWriter("skidesign.out"));

        int n = Integer.parseInt(scan.nextLine());
        int[] hills = new int[n];
        for (int i = 0; i < n; ++i) {
            hills[i] = Integer.parseInt(scan.nextLine());
        }

        Arrays.sort(hills);

        int min = 100000000;
        //Iterate through all possible gaps of size 17
        for(int i =0; i<=83; ++i){
            int cost = 0;

            //iterate through hills
            for(int x: hills){
                if(x<i){
                    cost += (i-x)*(i-x);
                }else if(x>i+17){
                    cost += (x-i-17)*(x-i-17);
                }
            }

            min = Math.min(min,cost);
        }

        out.println(min);
        out.close();

    }


}
