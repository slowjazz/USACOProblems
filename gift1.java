/*
ID: kenkrak1
LANG: JAVA
TASK: gift1
*/

import java.io.*;
import java.util.*;

class gift1 {
    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new FileReader("gift1.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(scan.readLine());
        int num = Integer.parseInt(st.nextToken());
        String[] group = new String[num];
        int[] book = new int[num];
        for(int i =0; i<num;++i){
            group[i]= scan.readLine();

        }
        String read;
        while((read = scan.readLine())!=null){
            String head = read;

            StringTokenizer line = new StringTokenizer(scan.readLine());
            int amt = Integer.parseInt(line.nextToken());
            int count = Integer.parseInt(line.nextToken());
            int orgindex = 0;
            if(count!=0){
                int give = (amt-(amt%count))/count;
                for(int i = 0; i<count;++i ){
                    String name = scan.readLine();

                    int index = 0;
                    for(int j = 0; j<group.length; ++j){
                        if(group[j].equals(name)){
                            index = j;
                        }
                        if(group[j].equals(head)){
                            orgindex = j;
                        }
                    }
                    book[index]+=give;
                }
                book[orgindex] += -amt + amt%count;
            }

        }
        for(int i =0; i<group.length;++i){
            out.println(group[i]+" "+book[i]);
        }
        out.close();
    }
}
