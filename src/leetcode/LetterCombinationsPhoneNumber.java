package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class LetterCombinationsPhoneNumber {

    static Map<String, List<String>> numbersMap = Map.of(
            "2", List.of("a","b","c"),
            "3", List.of("d","e","f"),
            "4", List.of("g","h","i"),
            "5", List.of("j","k","l"),
            "6", List.of("m","n","o"),
            "7", List.of("p","q","r","s"),
            "8", List.of("t","u","v"),
            "9", List.of("w","x","y", "z")
    );

    static int RECURSION_DEPTH;
    static int LAST_INDEX;

    static List<String> letterCombinationsBackTracking(String digits) {

        if(digits == null || digits.equals("")){
            return Collections.emptyList();
        }
        if(digits.length() == 1){
            return numbersMap.get(digits);
        }

        List<List<String>> allLists = new ArrayList<>();
        for (String key: digits.split("")) {
            allLists.add(numbersMap.get(key));
        }
        List<String> combinations = new ArrayList<>();
        String currentCombination = "";
        RECURSION_DEPTH = allLists.size();
        LAST_INDEX = allLists.size() - 1;
        backtrack(combinations, currentCombination, allLists.get(0), allLists, 0);
        return combinations;
    }

    static void backtrack(List<String> combinations, String currentCombination, List<String> currentLetters, List<List<String>> allLetterLines, int indexOfList) {

        if(currentCombination.length() == RECURSION_DEPTH) {
            combinations.add(currentCombination);
            return;
        }

        for (String nextLetter : currentLetters) {
            currentCombination = currentCombination + nextLetter;
            if(indexOfList < LAST_INDEX){
                indexOfList++;
            }
            backtrack(combinations, currentCombination, allLetterLines.get(indexOfList), allLetterLines, indexOfList);
            currentCombination = currentCombination.substring(0, currentCombination.length() - 1);
            indexOfList--;
        }
    }

    public static void main(String[] args) {

        String currentCombination = "abc";
        currentCombination = currentCombination.substring(0, currentCombination.length() - 1);
        System.out.println(currentCombination);

        System.out.println(letterCombinationsBackTracking("234"));
    }

    public static List<String> letterCombinationsIterative(String digits) {

        if(digits == null || digits.equals("")){
            return Collections.emptyList();
        }
        if(digits.length() == 1){
            return numbersMap.get(digits);
        }

        List<List<String>> allLists = new ArrayList<>();
        for (String key: digits.split("")) {
            allLists.add(numbersMap.get(key));
        }
        List<String> combinations = new ArrayList<>();
        if(allLists.size() == 2) {
            two(allLists, combinations);
        } else if (allLists.size() == 3) {
            three(allLists, combinations);
        } else if (allLists.size() == 4) {
            four(allLists, combinations);
        }
        return combinations;
    }

    static void two(List<List<String>> allLists, List<String> combinations){
        for (int i = 0; i < allLists.get(0).size(); i++) {
            String curr = allLists.get(0).get(i);
            for (int j = 0; j < allLists.get(1).size(); j++) {
                String otherCurr = allLists.get(1).get(j);
                String comb = curr + otherCurr;
                combinations.add(comb);
            }
        }
    }
    static void three(List<List<String>> allLists, List<String> combinations){
        for (int i = 0; i < allLists.get(0).size(); i++) {
            String curr = allLists.get(0).get(i);
            for (int j = 0; j < allLists.get(1).size(); j++) {
                String otherCurr = allLists.get(1).get(j);
                for (int k = 0; k < allLists.get(2).size(); k++) {
                    String thirdCurr = allLists.get(2).get(k);
                    String comb = curr + otherCurr + thirdCurr;
                    combinations.add(comb);
                }
            }
        }
    }
    static void four(List<List<String>> allLists, List<String> combinations){
        for (int i = 0; i < allLists.get(0).size(); i++) {
            String curr = allLists.get(0).get(i);
            for (int j = 0; j < allLists.get(1).size(); j++) {
                String otherCurr = allLists.get(1).get(j);
                for (int k = 0; k < allLists.get(2).size(); k++) {
                    String thirdCurr = allLists.get(2).get(k);
                    for (int l = 0; l < allLists.get(3).size(); l++) {
                        String fourth = allLists.get(3).get(l);
                        String comb = curr + otherCurr + thirdCurr + fourth;
                        combinations.add(comb);
                    }
                }
            }
        }
    }
}