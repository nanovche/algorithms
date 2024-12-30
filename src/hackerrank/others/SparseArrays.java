package hackerrank.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SparseArrays {

    public static void main(String[] args) {
        System.out.println(matchingStrings(Arrays.asList("ab","ab", "abc"), Arrays.asList("ab","abc","bc")));
        System.out.println(matchingStrings(Arrays.asList("aba","baba", "aba","xzxb"), Arrays.asList("aba","xzxb","ab")));
    }

    public static List<Integer> matchingStrings(List<String> stringList, List<String> queries) {

        List<Integer> res = new ArrayList<>();

        int counter = 0;
        for (String currentQuery: queries) {
            for (String string: stringList) {
                if(currentQuery.equals(string)){
                    counter++;
                }
            }
            res.add(counter);
            counter = 0;
        }
        return res;
    }
}
