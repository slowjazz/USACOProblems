/*
ID: kenkrak1
LANG: JAVA
TASK: transform
*/

import java.util.*;
import java.io.*;

class transform {
    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new FileReader("transform.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));

        int n = Integer.parseInt(scan.readLine());
        char[][] grid = new char[n][n];
        for(int i = 0; i<n;++i){
            String x = scan.readLine();
            char[] y = x.toCharArray();
            for(int j = 0; j<n;++j){
                grid[i][j] = y[j];
            }
        }

        char[][] test = new char[n][n];
        for(int i = 0; i<n;++i){
            String x = scan.readLine();
            char[] y = x.toCharArray();
            for(int j = 0; j<n;++j){
                test[i][j] = y[j];
            }
        }
//        print(grid);
//        char[][] num = reflection(grid);
//        firstcheck(num,test);
        out.println(check(grid,test));
        out.close();


    }

    public static char[][] rotate(char[][] oldgrid){
        char[][] grid = new char[oldgrid.length][oldgrid.length];
        for(int i=0; i<grid.length;++i){
            for(int j = 0; j<grid.length; ++j){
                grid[j][grid.length-1-i] = oldgrid[i][j];

            }
        }

        return grid;
    }

    public static char[][] reflection(char[][] oldgrid){
        char[][] grid = new char[oldgrid.length][oldgrid.length];
        for(int i = 0; i<grid.length; ++i){
            for(int j = 0; j<grid.length; ++j){
                grid[i][grid.length-1-j]=oldgrid[i][j];
            }
        }
        print(grid);
        return grid;
    }

    public static int firstcheck(char[][] grid,char[][] test){
        char[][] newGrid = Arrays.copyOf(grid,grid.length);
        for(int i = 1; i<=3;++i){
            newGrid = rotate(newGrid);
            print(newGrid);
            if(Arrays.deepEquals(newGrid,test)){
                return i;
            }
        }

        return 0;
    }

    public static int check(char[][]grid, char[][]test){

        int x;
        if((x=firstcheck(grid,test))!=0){
            return x;
        }else{
            if(Arrays.deepEquals(reflection(grid),test)){
                return 4;
            }
            if(firstcheck(reflection(grid),test)!=0){

                return 5;
            }
            if(Arrays.deepEquals(grid, test)){
                return 6;
            }else{
                return 7;
            }
        }
    }

    public static void print(char[][] grid){
        for(int i = 0; i<grid.length;++i){
            System.out.println(Arrays.toString(grid[i]));
        }
    }

}
