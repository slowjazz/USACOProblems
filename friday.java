/*
ID: kenkrak1
LANG: JAVA
TASK: friday
*/

import java.util.*;
import java.io.*;

class friday {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("friday.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));

        int n = scan.nextInt();
        int[] tally = new int[7];
        int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int index = 1;


        for (int i = 0; i < n; i++) {
            for (int m = 0; m < 12; ++m) {

                if (isLeap(1900 + i)) { //may be problematic gh
                    month[1] = 29; //reset later
                }


                int tallyIn =index-2;
                if(tallyIn <0){
                    tallyIn = 7+tallyIn;
                }
                tally[tallyIn] += 1;
                index = (index + ((month[m]) % 7)) % 7;

            }
            month[1] = 28;
        }

        String result = "";
        result += tally[6] + " ";
        for (int i = 0; i < tally.length - 2; i++) {
            result += tally[i] + " ";
        }
        result += tally[5]+"\n";
        out.write(result);
        out.close();

    }

    public static boolean isLeap(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0 && year % 400 != 0) {
                return false;
            }
            return true;
        } else {
            return false;
        }
    }

}
