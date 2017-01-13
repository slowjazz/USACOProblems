/*
ID: kenkrak1
LANG: JAVA
TASK: beads
*/

import java.util.*;
import java.io.*;

class beads {
    public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(new File("beads.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));

        int n = scan.nextInt();
        scan.nextLine();
        String beads = scan.nextLine();

        char[] line = beads.toCharArray();
        int max=0;
        for(int i = 0; i<line.length; ++i){
            int sum=0;
            boolean check = true;
            boolean change = false;

            char start;
            start = line[i]; //start Color
            sum++;



            int j = i;
            while(check){
                if(j==line.length-1){
                    j = -1;
                }
                j++;
                if(j==i){
                    check = false;
                }else{
                    char next = line[j];
                    if(next == start||next =='w'||start=='w'){
                        sum++;
                        if((next!='w')&&(start ==119)){
                            start = next;
                        }
                    }else if(!change){
                        change =true;
                        start = next;
                        sum++;
                    }else{
                        //check if change switches again, then stop loop (!check) and set max = sum
                        check = false;
                    }
                }


            }
            if(sum>max){
                max = sum;
            }
        }
        out.println(max);
        out.close();




    }


}
