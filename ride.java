/*
ID: kenkrak1
LANG: JAVA
TASK: ride
*/
import java.io.*;
import java.util.*;

class ride {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("ride.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        char[] alpha = new char[26];
        for(int i = 0; i<26; i++){
            alpha[i]=(char)('a'+i);
        }
        int[] num = new int[26];
        for(int i = 1; i <=26; ++i){
            num[i-1]=i;
        }
        int[] product = new int[2];

        for(int l = 0; l <2; l++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            product[l]=1;
            char[] array = st.nextToken().toLowerCase().toCharArray();
            for(int i=0; i<array.length; ++i){
                product[l]*= num[String.valueOf(alpha).indexOf(array[i])];
            }
        }
        if (product[0] % 47 == product[1]%47) {
            out.println("GO");
        }else{
            out.println("STAY");
        }
        out.close();



    }
}
