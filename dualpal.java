/*
ID: kenkrak1
LANG: JAVA
TASK: dualpal
 */

import java.io.*;
import java.util.*;

class dualpal {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("dualpal.in"));
        PrintWriter out = new PrintWriter(new FileWriter("dualpal.out"));
        int n = scan.nextInt();
        int s = scan.nextInt();

        int test = s +1;
        int count = 0;
        while(count<n){
            int check = 0;
            for(int base = 2; base<=10; ++base){
                String pal = Integer.toString(test, base);
                char[] palArray = pal.toCharArray();
                boolean isPal = true;
                for(int i =0; i<(pal.length())/2; ++i){
                    if(palArray[i]!=palArray[palArray.length-1-i]){
                        isPal = false;
                    }
                }
                if(isPal){
                    check ++;
                }
            }
            if(check>=2){
                out.println(test);
                count++;
            }
            test++;

        }
        out.close();

    }
}
