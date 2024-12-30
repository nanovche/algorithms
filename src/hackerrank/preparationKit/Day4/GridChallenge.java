package hackerrank.preparationKit.Day4;

import java.util.*;
import java.util.stream.Collectors;

public class GridChallenge {

    public static void main(String[] args) {
//        System.out.println(gridChallenge(List.of("abc","ade","efg")));
//        System.out.println(gridChallenge(new ArrayList<>(List.of("ebacd", "fghij", "olmkn", "trpqs", "xywuv"))));
        System.out.println(gridChallenge(new ArrayList<>(List.of("abc", "lmp", "qrt"))));
        System.out.println(gridChallenge(new ArrayList<>(List.of("mpxz", "abcd", "wlmf"))));
        System.out.println(gridChallenge(new ArrayList<>(List.of("abc", "hjk", "mpq","rtv"))));

    }
    public static String gridChallenge(List<String> grid) {

        String curr;
        for (int i = 0; i < grid.size(); i++) {
            curr = grid.get(i);
            if(!isStringSorted(curr)){
                String sorted;
                List<String> stringList = new java.util.ArrayList<>(Arrays.stream(curr.split("")).collect(Collectors.toList()));
                Collections.sort(stringList);
                sorted = String.join("", stringList);
                grid.set(i, sorted);
            }
        }

        for (int i = 0; i < grid.get(0).length(); i++) {
            StringBuilder col = new StringBuilder();
            for (int j = 0; j < grid.size(); j++) {
                col.append(grid.get(j).charAt(i));
            }
            if(!isStringSorted(col.toString())){
                return "NO";
            }
        }
        return "YES";
    }

    static boolean isListSorted(List<String> stringList){

        Iterator<String> iter = stringList.listIterator();
        String current, previous = iter.next();
        while(iter.hasNext()){
            current = iter.next();
            if(previous.compareTo(current) > 0) {
                return false;
            }
            previous = current;
        }
        return true;
    }

    static boolean isStringSorted(String str){
        if(str.isEmpty() || str.length() == 1) {
            return true;
        }
        for (int i = 0; i < str.length() - 1; i++) {
            if(str.charAt(i) > str.charAt(i + 1)){
                return false;
            }
        }
        return true;
    }
}