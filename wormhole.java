/*
ID: kenkrak1
LANG: JAVA
TASK: wormhole
 */

import java.util.Scanner;
import java.io.*;

class wormhole {
    public static final int MAX = 12;

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("wormhole.in"));
        PrintWriter out = new PrintWriter(new FileWriter("wormhole.out"));

        int[] x = new int[MAX+1];
        int[] y = new int[MAX+1];

        int n = Integer.parseInt(scan.nextLine());
        for(int i =1; i<=n;++i){
            x[i] = scan.nextInt();
            y[i] = scan.nextInt();
            if(scan.hasNextLine()) scan.nextLine();
        }

        int[] partner = new int[MAX+1];
        int[] next_on_right = new int[MAX+1];
        for(int i = 1; i<=n; ++i){
            for(int j = 1; j<=n; ++j){
                if(x[j]>x[i] && y[i] == y[j]){
                    //check if array is empty before populating it or if a closer point is found
                    if(next_on_right[i]==0 || x[j]-x[i]<x[next_on_right[i]]-x[i]){
                        next_on_right[i]=j;
                    }
                }
            }
        }

        out.println(solve(n,partner,next_on_right));
        out.close();



    }

    //solve for all possible pairs of wormholes recursively
    public static int solve(int n, int[] partner , int[] next_on_right){
        int first, total = 0;
        for(first = 1; first<= n; ++first){
            if(partner[first]==0) break;
        }

        //exit recursion if all pairs are found
        if(first>n){
            if(cycle_exists(n, partner,next_on_right)) return 1;
            else return 0;
        }

        for(int second = first+1; second<=n; second++){
            if(partner[second]==0){
                partner[first] = second;
                partner[second] = first;
                total += solve(n,partner,next_on_right);
                partner[first] = partner[second] = 0;
            }
        }
        return total;
    }

    public static boolean cycle_exists(int n,int[] partner,int[] next_on_right){
        for(int start = 1; start<= n; start++){
            int pos = start;
            for(int count = 0; count <n; count++){
                pos = next_on_right[partner[pos]];
            }
            if(pos!=0) return true;
        }
        return false;
    }


}
