package hackerrank.preparationKit.Day2;

import java.util.Arrays;
import java.util.List;

public class DiagonalDifference {

    public static void main(String[] args) {
/*
        System.out.println(diagonalDifference(
                Arrays.asList(
                        Arrays.asList(1,2,3),
                        Arrays.asList(4,5,6),
                        Arrays.asList(9,8,9)
                )
        ));
*/

        System.out.println(diagonalDifference(
                Arrays.asList(
                        Arrays.asList(11,2,4),
                        Arrays.asList(4,5,6),
                        Arrays.asList(10,8,-12)
                )
        ));

    }

    public static int diagonalDifference(List<List<Integer>> arr) {

        int sumPrimary = 0;
        int sumSecondary = 0;
        int currXPrimary = 0;
        int currYPrimary = 0;
        int currXSecondary = arr.size() - 1;
        int currYSecondary = 0;
        while (true) {
            if(!inBounds(currXPrimary, currYPrimary, currXSecondary, currYSecondary, arr.size())){
                break;
            }
            sumPrimary += arr.get(currXPrimary).get(currYPrimary);
            currXPrimary += 1;
            currYPrimary += 1;

            sumSecondary += arr.get(currXSecondary).get(currYSecondary);
            currXSecondary -= 1;
            currYSecondary += 1;
        }
        if(sumPrimary > sumSecondary) {
            return sumPrimary - sumSecondary;
        } else if(sumPrimary < sumSecondary) {
            return sumSecondary - sumPrimary;
        } else {
            return 0;
        }
    }

    static boolean inBounds(int px, int py, int sx, int sy, int size) {
        return px < size && py < size && sx < size && sy < size;
    }
}