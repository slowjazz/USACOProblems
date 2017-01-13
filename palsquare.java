/*
ID: kenkrak1
LANG: JAVA
TASK: palsquare
*/

import java.util.*;
import java.io.*;

class palsquare {
    public static void main(String[] args) throws IOException{
        BufferedReader scan = new BufferedReader(new FileReader("palsquare.in"));
        PrintWriter out = new PrintWriter(new FileWriter("palsquare.out"));

        int base = Integer.parseInt(scan.readLine());
        for(int i = 1; i<=300; ++i){
            String num = Integer.toString(i, base).toUpperCase();
            int square = (int)Math.pow((double)i,(double)2);
            String newSquare = Integer.toString(square, base).toUpperCase();


            if(checkPal(newSquare)){

                out.println(num+" "+newSquare);
            }

        }
        out.close();

    }

    public static boolean checkPal(String target){
        String num = target;
        for(int i = 0; i<(num.length()/2);++i){
            if(num.charAt(i)!=num.charAt(num.length()-1-i)){
                return false;
            }
        }
        return true;
    }

}
