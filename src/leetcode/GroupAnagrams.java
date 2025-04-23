package leetcode;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        System.out.println(groupAnagrams2(new String[]{"eat","tea","tan","ate","nat","bat"}));
        System.out.println(groupAnagrams2(new String[]{""}));
        System.out.println(groupAnagrams2(new String[]{"a"}));
        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> anagramGroups = new HashMap<>();
        for (String str: strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            anagramGroups.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(anagramGroups.values());
    }
    public static List<List<String>> groupAnagrams2(String[] strs) {

        if(strs.length == 1) {
            return List.of(List.of(strs[0]));
        } else if(strs.length == 0) {
            return List.of(List.of(""));
        }

        List<AnagramData> anagrams = new ArrayList<>();
        for (String currWord: strs) {
            solve(currWord.toCharArray(), anagrams);
        }

        List<List<String>> result = new ArrayList<>();
        for (AnagramData anagramData: anagrams) {
            result.add(anagramData.listOfAnagrams);
        }
        return result;
    }

    static void solve(char[] existentOrNewAnagram, List<AnagramData> anagrams){

        if(anagrams.isEmpty()) {
            //this is new and first anagram
            AnagramData anagramData = new AnagramData();
            anagramData.createPattern(existentOrNewAnagram);
            anagramData.addAnagram(new String(existentOrNewAnagram));
            anagrams.add(anagramData);
            return;
        }
        boolean inCurrentAnagram = true;
        for (AnagramData anagram: anagrams) {
            Map<Character, Integer> anagramPatternOriginal = new HashMap<>(anagram.anagramPattern);
            inCurrentAnagram = true;
            for (char c : existentOrNewAnagram) {
                if (anagram.anagramPattern.get(c) == null || anagram.anagramPattern.get(c) == 0) { //NOT IN THIS ANAGRAM
                    inCurrentAnagram = false; //NOT IN THIS ANAGRAM
                    break; //NOT IN THIS ANAGRAM, GO TO NEXT ANAGRAM
                } else {
                    anagram.anagramPattern.put(c, anagram.anagramPattern.get(c) - 1); // b->2 a-> 1 ;; b -> 1 a -> 1;; b => 0 a -> 1
                }
            }
            anagram.anagramPattern = anagramPatternOriginal; //restore mapping in current anagramPattern
            //anagram map should be zeroed out, flag should be true if we exit normally from inner for
            if(inCurrentAnagram) {
                //break outer cycle and add to current AnagramData object
                anagram.addAnagram(new String(existentOrNewAnagram));
                break;
            }
        }
        if(!inCurrentAnagram) {
            AnagramData anagramData = new AnagramData();
            anagramData.createPattern(existentOrNewAnagram);
            anagramData.addAnagram(new String(existentOrNewAnagram));
            anagrams.add(anagramData);
        }
    }
    static class AnagramData{
        Map<Character, Integer> anagramPattern = new HashMap<>();
        List<String> listOfAnagrams = new ArrayList<>();

        void createPattern(char[] newAnagramChars){
            for (char c: newAnagramChars) {
                anagramPattern.merge(c, 1, Integer::sum);
            }
        }
        void addAnagram(String anagram){
            listOfAnagrams.add(anagram);
        }
    }
}