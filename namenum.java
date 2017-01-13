/*
ID: kenkrak1
LANG: JAVA
TASK: namenum
*/

import java.util.*;
import java.io.*;

class namenum {
    public static void main(String[] args) throws IOException {

        BufferedReader scan = new BufferedReader(new FileReader("namenum.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));

        String target = scan.readLine();
        char[][] dict = {
                {'A','B','C'},
                {'D','E','F'},
                {'G','H','I'},
                {'J','K','L'},
                {'M','N','O'},
                {'P','R','S'},
                {'T','U','V'},
                {'W','X','Y'}

        };

        out.print(check(target, dict));
        out.close();

    }

    public static String check(String target, char[][] dict) throws IOException{
        Scanner fileScan = new Scanner(new File("dict.txt"));
        String results ="";
        while(fileScan.hasNextLine()){
            String name = fileScan.nextLine();
            char[] nameChar = name.toCharArray();
            String test ="";
            for(int i =0; i<nameChar.length; ++i){
                int digit=0;
                for(int num = 0; num<dict.length; ++num){
                    for(char c : dict[num]){
                        if(c==nameChar[i]){
                            digit = num+2;
                        }
                    }
                }
                test+= String.valueOf(digit);
            }
            if(target.equals(test)){
                results += name +"\n";
            }

        }
        if(results.isEmpty()){
            results ="NONE\n";
        }
        return results;

    }

//    public static String assemble(String string, int index, char[] digits,char[][] dict,int[]
//            count){
//        if(index==digits.length-1){
//            return string+dict[digits[index]-2][count[index]];
//        }else{
//            return string+assemble(string,index+1,digits,dict,count);
//        }
//    }



}
