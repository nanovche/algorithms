package hackerrank.others;

import java.util.*;

public class Anagrams {

    public static void main(String[] args) {
        System.out.println(anagrams("Race", "Care"));
        System.out.println(anagrams("NAME", "MANE"));
        System.out.println(anagrams("anagram", "gamanra"));
        System.out.println(anagrams("anagram", "GraMana"));
        System.out.println(anagrams("AnAgrAm", "gramana"));
        System.out.println(anagrams("anagram", "naagram"));
        System.out.println(anagrams("anagram", "anargam"));
        System.out.println(anagrams("anagram", "python"));
        System.out.println(anagrams("anagram", "wxdcfvb"));
        System.out.println(anagrams("anagram", "nnagram"));
    }
    static boolean anagrams(String s1, String s2) {

        char[] chars = s1.toLowerCase().toCharArray();
        char[] chars2 = s2.toLowerCase().toCharArray();

        if(chars.length != chars2.length) {
            return false;
        }

        Arrays.sort(chars);
        Arrays.sort(chars2);
        return Arrays.equals(chars, chars2);
    }
}
