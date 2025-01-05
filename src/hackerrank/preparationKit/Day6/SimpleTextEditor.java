package hackerrank.preparationKit.Day6;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {

    static ArrayDeque<String[]> lastOpsStack = new ArrayDeque<>();
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numOfOps = scanner.nextInt();
        scanner.nextLine();
        StringBuilder string = new StringBuilder();
//        StringBuilder string = new StringBuilder("abcde");

        for (int i = 0; i < numOfOps; i++) {
            String line = scanner.nextLine();
            String[] ops = line.split(" ");
            switch (ops[0]) {
                case "1" -> append(ops[1], string);
                case "2" -> delete(ops[1], string);
                case "3" -> print(String.valueOf(Integer.parseInt(ops[1]) - 1), string);
                case "4" -> undo(lastOpsStack.pop(), string);
            }
        }
        scanner.close();
    }
    static void append(String stringToAppend, StringBuilder origString){
        origString.append(stringToAppend);
        lastOpsStack.push(new String[]{"1", stringToAppend});
    }
    static void delete(String numOfChars, StringBuilder origString){
        String deleted = origString.substring(origString.length() - Integer.parseInt(numOfChars));
        origString.delete(origString.length() - Integer.parseInt(numOfChars), origString.length());
        lastOpsStack.push(new String[]{"2", deleted});
    }
    static void print(String zeroBasedChar, StringBuilder origString){
        System.out.println(origString.charAt(Integer.parseInt(zeroBasedChar)));
    }
    static void undo(String[] lastOps, StringBuilder origString){
        switch (lastOps[0]) {
            case "1" -> {
                String appended = lastOps[1];
                origString.replace(origString.length() - appended.length(), origString.length(), "");
            }
            case "2" -> {
                String deletedSubstr = lastOps[1];
                origString.append(deletedSubstr);
            }
        }
    }
}

//        String[] lastOps = new String[2];
//        String lastDeleted = null;


/*            if(ops[0].equals("1")){
                for (int j = 0; j < ops.length; j++) {
                    lastOps[j] = ops[j];
                }
                lastOpsStack.push(new String[]{lastOps[0], lastOps[1]});
            } else if(ops[0].equals("2")){
                if(lastDeleted != null){
                    for (int j = 0; j < ops.length; j++) {
                        lastOps[j] = ops[j];
                    }
                    lastOps[1] = lastDeleted;
                    lastOpsStack.push(lastOps);
                }
}*/