package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
//        System.out.println(combine(1, 1));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> allCombs = new ArrayList<>();
        backtrack(1, n,k,new ArrayList<>(), allCombs);
        return allCombs;
    }
    static void backtrack(int start, int n, int k, List<Integer> currentComb, List<List<Integer>> allCombs){

        if(currentComb.size() == k) {
            allCombs.add(new ArrayList<>(currentComb));
            return;
        }

        for (int i = start; i <= n; i++) {
            currentComb.add(i);
            backtrack(i + 1, n,k,currentComb,allCombs);
            currentComb.remove(currentComb.size() - 1);
        }
    }
}