package company4;

import java.util.ArrayDeque;
import java.util.List;

public class Task {


    public static void main(String[] args) {

        System.out.println(minimumSteps(List.of("x/", "y/", "../", "z/", "./")));
        System.out.println(minimumSteps(List.of("o/", "w/", "e/", "./", "./", "./")));
        System.out.println(minimumSteps(List.of("o/", "z/", "x/", "a/", "../", "../")));
        System.out.println(minimumSteps(List.of("o/", "z/", "x/", "a/", "../", "../")));
    }

/*    public static int minimumSteps(List<String> loggedMoves) {

        int steps = 0;
        for (String currMove: loggedMoves) {
            if(!currMove.equals("../") && !currMove.equals("./")) {
                steps++;
            } else if (currMove.equals("../")) {
                steps--;
            }
        }
        return steps;
    }*/

    public static int minimumSteps(List<String> loggedMoves) {

        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
        for (String currMove: loggedMoves) {
            if(!currMove.equals("../") && !currMove.equals("./")) {
                arrayDeque.push(currMove);
            } else if (currMove.equals("../") && !arrayDeque.isEmpty()) {
                arrayDeque.pop();
            }
        }
        return arrayDeque.size();
    }
}