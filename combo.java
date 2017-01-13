/*
ID: kenkrak1
LANG: JAVA
TASK: combo
 */

import java.util.Scanner;
import java.io.*;

class combo {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("combo.in"));
        PrintWriter out = new PrintWriter(new FileWriter("combo.out"));

        int n = Integer.parseInt(scan.nextLine());
        int[] comboOne = new int[3];
        int[] comboTwo = new int[3];
        copyInt(comboOne,scan);
        scan.nextLine();
        copyInt(comboTwo,scan);

        int count=0;
        String results ="";

        for(int i =1; i<=n; ++i){
            if(checkDistance(comboOne,0,i,n)||checkDistance(comboTwo,0,i,n)){
                int identify = 1;
                if(checkDistance(comboTwo,0,i,n)){
                    identify=2;
                }
                if(checkDistance(comboOne,0,i,n)&&checkDistance(comboTwo,0,i,n)){
                    identify=3;
                }
                for(int j=1;j<=n;++j){

                    if(checkDistance(comboOne,1,j,n)&&(identify==1||identify==3)){
                        for(int k = 1;k<=n;++k){
                            if(checkDistance(comboOne,2,k,n)){
                                count++;
                                results+=result(i,j,k)+"\n";
                            }else if(identify==3&&checkDistance(comboTwo,1,j,n)&&checkDistance(comboTwo,2,k,n)){
                                count++;
                                results += "new case"+result(i,j,k)+"\n";
                            }
                        }

                    } else if(checkDistance(comboTwo,1,j,n)&&(identify==2||identify==3)){
                        for(int k=1; k<=n;++k){
                            if(checkDistance(comboTwo,2,k,n)){
                                count++;
                                results+=result(i,j,k)+"\n";
                            }
                        }

                    }
                }

            }
        }

        out.println(count);
        out.close();
        System.out.println(results);



    }

    public static void copyInt(int[] target, Scanner scan){
        for(int i =0; i<3;++i){
            target[i]=scan.nextInt();
        }
    }

    public static boolean checkDistance(int[] combo, int pos,int target,int n){
        return Math.abs(combo[pos]-(target))<=2 || Math.abs(combo[pos]+n-(target))<=2||Math.abs(combo[pos]-n-target)<=2;
    }

    public static String result(int i, int j, int k){
        return i+","+j+","+k;
    }
}
