/*
ID: kenkrak1
LANG: JAVA
TASK: barn1
 */

import java.io.*;
import java.util.*;

class barn1 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("barn1.in"));
        PrintWriter out = new PrintWriter(new FileWriter("barn1.out"));

        int max = scan.nextInt();
        int total = scan.nextInt();
        int c = scan.nextInt();
        scan.nextLine();
        boolean[] stalls = new boolean[total];

        int start=201;
        int end=0;

        for(int i = 0; i<c; ++i){
            int index = Integer.parseInt(scan.nextLine());
            if(index<start){
                start = index;
            }
            if(index>end){
                end = index;
            }
            stalls[index-1] = true;

        }

        int[] empty = new int[200];
        int index = 0;
        int count = 0;
        for(int i = start-1; i<stalls.length; ++i){

            if(!stalls[i]){
                count++;
            }else{
                if(count>0){
                    empty[index] = count;
                    index++;
                }
                count = 0;

            }

        }
        int sum = 0;
        for(int i: empty){
            sum+= i;
        }
        System.out.println(sum);
        Arrays.sort(empty);
        int maxSum = 0;
        if(max==1){
            out.println(end-start+1);
        }else{
            for(int i =0 ; i<max-1; ++i){
                maxSum+= empty[empty.length-1-i];
            }
            out.println((end-start+1)-maxSum);
        }




        out.close();


        





    }
}
