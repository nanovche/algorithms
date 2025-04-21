package company3;

import java.util.HashMap;
import java.util.Map;

public class PermutationsInterviewPaysafe {

    public static void main(String[] args) {
        //System.out.println(countPermutationsChat("abbc", "babcvfavfdaabbaaacbaaabbccccc"));
        System.out.println(countPermutations2("abbc", "babcvfavfdaabbaaacbaaabbcbbac"));
        System.out.println(countPermutations("abbc", "babcvfavfdaabbaaacbaaabbcbbac"));
    }

    static int countPermutations2(String s1, String s2) {

        int counter = 0;
        for (int i = 0; i < s2.length() - 3; i++) {
            Map<Character, Integer> perm = fillMap2();
            char[] candidatePerm = s2.substring(i, i + 4).toCharArray();
            if(isPermutation2(perm, candidatePerm)){
                counter++;
            }
        }
        return counter;
    }

    static boolean isPermutation2(Map<Character, Integer> permMap,char[] candidatePerm){
        boolean permutation = true;
        for (char c: candidatePerm) {
            if(permMap.containsKey(c)){
                if(permMap.get(c) == 1){
                    permMap.remove(c);
                } else {
                    permMap.put(c, permMap.get(c) - 1);
                }
            } else {
                return false;
            }
        }
        return permutation;
    }

    static Map<Character, Integer> fillMap2(){
        Map<Character, Integer> perm = new HashMap<>();
        perm.put('a', 1);
        perm.put('b', 2);
        perm.put('c', 1);
        return perm;
    }

    static int countPermutations(String s1, String s2) {
        int permutationLength = s1.length();
        int countOfPermutations = 0;
        for (int i = 0; i < s2.length() - permutationLength + 1; i++) {
            Map<Character, Integer> s1Map = fillMap(s1);
            char[] candidatePermutation = s2.substring(i, permutationLength + i).toCharArray();
            if(isPermutation(s1Map, candidatePermutation)){
                countOfPermutations++;
            }
        }
        return countOfPermutations;
    }
    static boolean isPermutation(Map<Character, Integer> s1Map, char[] candidatePermutation){

        boolean permutation = true;
        for (Character ch: candidatePermutation) {
            if(s1Map.containsKey(ch)){
                int count = s1Map.get(ch);
                if(count == 1) {
                    s1Map.remove(ch);
                } else {
                    s1Map.put(ch, s1Map.get(ch) - 1);
                }
            } else {
                permutation = false;
                break;
            }
        }
        return permutation;
    }
    static Map<Character, Integer> fillMap(String s1){
        Map<Character, Integer> m = new HashMap<>();
        for (Character ch: s1.toCharArray()) {
            if(m.get(ch) != null){
                m.put(ch, m.get(ch) + 1);
            } else {
                m.put(ch, 1);
            }
        }
        return m;
    }
}