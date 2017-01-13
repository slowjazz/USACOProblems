/*
ID: kenkrak1
LANG: JAVA
TASK: milk
 */

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

class milk {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("milk.in"));
        PrintWriter out = new PrintWriter(new FileWriter("milk.out"));

        int total = scan.nextInt();
        int m = scan.nextInt();
        scan.nextLine();

        int[] farmers = new int[1001];
        for(int i = 0; i<m; ++i){
            farmers[scan.nextInt()] += scan.nextInt();
            if(i!=m-1){
                scan.nextLine();
            }
        }

        int cost = 0;
        int sum = 0;
        for(int i = 0; i<farmers.length; ++i){
            if(farmers[i]>0 && farmers[i]<(total-sum)){
                sum+= farmers[i];
                cost += i*farmers[i];
            }else if(farmers[i]>=(total-sum)){
                cost += i*(total-sum);
                break;
            }
        }
        out.println(cost);
        out.close();




    }
}
