/*
ID: kenkrak1
LANG: JAVA
TASK: milk2
*/

import java.util.*;
import java.io.*;

class milk2 {
    public static void main(String[] args)throws IOException {
        BufferedReader scan = new BufferedReader(new FileReader("milk2.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster

        //Create massive boolean array, and keep updating values, then loop through and count
        int n = Integer.parseInt(scan.readLine());
        int end = 0;
        int start = 1000000;
        boolean[] array = new boolean[1000000];
        for(int i=0; i<n; ++i){
            StringTokenizer line = new StringTokenizer(scan.readLine());
            int head = Integer.parseInt(line.nextToken());
            int tail = Integer.parseInt(line.nextToken());
            if(tail>end){
                end = tail;
            }
            if(head <start){
                start=head;
            }
            //Head points are marked as false to ensure gaps
            for(int j = head+1; j<=tail;++j){
                array[j]= true;
            }
        }
        int max = 0;
        int maxStreak=0;

        int streakCount=0;
        int gapCount=0;



        for(int i = 0; i<array.length;++i){
            boolean startCheck=(i<=end&&i>start);
            if(startCheck&&array[i]){
                streakCount++;
                gapCount=0;
            }else if(startCheck){
                gapCount++;
                streakCount=0;
            }
            if(gapCount>max){
                max = gapCount;
            }
            if(streakCount>maxStreak){
                maxStreak = streakCount;
            }
        }

        out.println(maxStreak+" "+ (max));
        out.close();


//
//        int max = 0;
//        //*****need to sort all intervals first, then do the scan on sorted list
//        int[] list = new int[n*2];
//        for(int j=0; j<n;++j){
//            StringTokenizer line = new StringTokenizer(scan.readLine());
//            list[j*2] = Integer.parseInt(line.nextToken());
//            list[(j*2)+1] =Integer.parseInt(line.nextToken());
//        }
//
//        int head = list[0];
//        int tail = list[1];
//        for(int i = 1;i<n;++i){
//            int gap = 0;
//
//            int h = list[i*2];
//            int t = list[(i*2)+1];
//            if(h>tail){
//                gap = h-tail;
//                head = h;
//                tail = t;
//            }else{
//                if(t>tail){
//                    tail = t;
//                }
//                if(h<head){
//                    head = h;
//                }
//            }
//            if(gap>max){
//                max = gap;
//            }
//        }
//
//        out.println(tail-head+" "+max);
//        out.close();


    }
}
