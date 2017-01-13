/*
ID: kenkrak1
LANG: JAVA
TASK: crypt1
 */


import java.util.*;
import java.io.*;

class crypt1 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("crypt1.in"));
        PrintWriter out = new PrintWriter(new FileWriter("crypt1.out"));

        int n = scan.nextInt();
        scan.nextLine();
        int[] digits = new int[n];
        for (int i = 0; i < digits.length; ++i) {
            digits[i] = scan.nextInt();
        }
        Arrays.sort(digits);


        int count =0;
        for(int a: digits){
            for(int b: digits){
                for(int c: digits){
                    for(int d: digits){
                        for(int e: digits){
                            int firstNum = 100*a+10*b+c;
                            int secondNum = 10*d+e;
                            int product = secondNum*firstNum;
                            if(existsIn(digits,product)
                                    &&existsIn(digits,firstNum*d)
                                    &&existsIn(digits,firstNum*e)
                                    &&(checkLen(firstNum*d)==checkLen(firstNum*e))
                                    &&checkLen(firstNum*d)==3
                                    &&(checkLen(product)==4) ){
                                count++;
                            }
                        }
                    }
                }
            }
        }

        out.println(count);
        out.close();


    }

    public static boolean existsIn(int[] digits, int target){
        char[] targetDigits = String.valueOf(target).toCharArray();
        String digitArray = Arrays.toString(digits);
        for(int i =0; i<targetDigits.length; ++i){
            if(!digitArray.contains(String.valueOf(targetDigits[i]))){
                return false;
            }
        }
        return true;
    }

    public static int checkLen(int target){
        return String.valueOf(target).length();
    }
}

//        int count = 0;
//        int index = 0;
//        while(index<(int)Math.pow(digits.length,3)){
//            String firstNum = numGen(digits,index,3);
//            int indexTwo = 0;
//            while(indexTwo<(int)Math.pow(digits.length,2)){
//                String secondNum = numGen(digits,index,2);
//                int indexThree = 0;
//                while(indexThree<(int)Math.pow(digits.length,5)){
//                    String productTest = numGen(digits,index,5);
//                    int product = Integer.parseInt(firstNum)*Integer.parseInt(secondNum);
//                    if(String.valueOf(product).equals(productTest)){
//                        count++;
//                        break;
//                    }
//                    indexThree++;
//                }
//                indexTwo++;
//            }
//            index++;
//        }
//
//        out.println(count);
//        out.close();
//
//
//    }
//
//
//
//    //method generates a specific-length num based on an index, each combination corresponds to an index
//    public static String numGen(int[] digits, int index, int length){
//        String result = "";
//        for(int i = 0; i<length; ++i){
//            if(i==length-1){
//                result+= String.valueOf(digits[index%digits.length]);
//            }else{
//                result+= String.valueOf(digits[(int)Math.floor(index/Math.pow(digits.length,length-1-i))]);
//            }
//
//
//        }
//        return result;
//    }






