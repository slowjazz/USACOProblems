/*
ID: kenkrak1
LANG: JAVA
TASK: ariprog
 */


import java.io.*;
import java.util.*;

class ariprog {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("ariprog.in"));
        PrintWriter out = new PrintWriter(new FileWriter("ariprog.out"));

        int n = Integer.parseInt(scan.nextLine());
        int m = Integer.parseInt(scan.nextLine());
        boolean[] checkSet = new boolean[m*m*2+1];

        for(int p=0;p<=m;++p){
            for(int q = 0; q<=m; ++q){
                checkSet[p*p+q*q]=true;

            }
        }


        int count= 0;


        for(int b = 1; b<=m*m*2; ++b){
            for(int i =0; i+b*(n-1)<=m*m*2;++i){
                    boolean check = true;
                    for(int target = 0; target<n;++target){
                        if(i+target*b >=checkSet.length|| !checkSet[i+target*b]){
                            check = false;
                            target = n; //end loop
                        }
                    }
                    if(check) {
                        out.println(i+" "+b);
                        count++;
                    }

            }
        }

        if(count==0){
            out.println("NONE");
        }
        out.close();



    }
}
