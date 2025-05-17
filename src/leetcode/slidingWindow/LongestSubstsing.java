package leetcode.slidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstsing {

    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstringMine("abcabcbb"));
//        System.out.println(lengthOfLongestSubstringMine("bbbbb"));
//        System.out.println(lengthOfLongestSubstringMine("pwwkew"));
//        System.out.println(lengthOfLongestSubstringMine("au"));
        System.out.println(lengthOfLongestSubstringOriginal("pwwkew"));
    }

    public static int lengthOfLongestSubstringOriginal(String s) {

        int n = s.length();
        Set<Character> set = new HashSet<>();
        int left = 0;
        int maxlength = 0;

        for (int right = 0; right < n; right++) {

            char currentChar = s.charAt(right);

            while(set.contains(currentChar)){
                set.remove(s.charAt(left));
                left++;
            }

            set.add(currentChar);
            maxlength = Math.max(maxlength, right - left + 1);

        }
        return maxlength;
    }

    public static int lengthOfLongestSubstringMine(String s) {

        int start = 0;
        int end = 1;
        int counter = 1;
        int oldCounter = counter;
        Set<Character> currentWindow = new HashSet<>();

        char ch1 = s.charAt(start);
        char ch2 = s.charAt(end);
        currentWindow.add(ch1);
        while (true) {
            if(currentWindow.contains(ch2)) {
                //window ended;
                start++;//advance start
                end= start + 1;  //advance end
                //get counter of unrepeated string until now
                counter = currentWindow.size();
                if(counter >= oldCounter) {
                    oldCounter = counter;
                }
                //clear contents of current window and add first char to new window
                currentWindow.clear(); //this is slow -> linear time
                currentWindow.add(s.charAt(start));
                //reached same char; move pointers
            } else {
                currentWindow.add(ch2);
                end++; //advance only end -> we are in the same window
            }
            if(start == s.length() - 1 || end == s.length()) {
                counter = currentWindow.size();
                if(counter >= oldCounter) {
                    oldCounter = counter;
                }
                break;
            }
            ch2 = s.charAt(end);
        }
        return oldCounter;
    }
}