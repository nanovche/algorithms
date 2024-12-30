package hackerrank.others;

import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] nM = line.split(" ");
        int rows = Integer.parseInt(nM[0]);
        int cols = Integer.parseInt(nM[1]);
        long[][] matrix = new long[rows][cols];

        long sum=0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j]=(long)(1+ (3*(i+j)));
            }
        }

        for (int i = 0; i < rows; i++) {
            if(i == 0) {
                for (int j = 0; j < cols; j=j+2) {
                    sum+=matrix[i][j];
                }
                continue;
            }
            if(i == rows-1) {
                if(rows % 2 == 1){
                    for (int j = 0; j < cols; j=j+2) {
                        sum+=matrix[i][j];
                    }
                }
                if(rows % 2==0){
                    for (int j = 1; j < cols; j=j+2) {
                        sum+=matrix[i][j];
                    }
                }
                continue;
            }
            if(i % 2==1){
                for (int j = 1; j < cols-1; j=j+2) {
                    sum+=matrix[i][j]*2;
                }
                sum+=matrix[i][cols-1];
            }
            if(i % 2 == 0){
                for (int j = cols-2; j > 1; j=j-2) {
                    sum+=matrix[i][j]*2;
                }
                sum+=matrix[i][0];
            }

        }
        System.out.println(sum);
    }
}
