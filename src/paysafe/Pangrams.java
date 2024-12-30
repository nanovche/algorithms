package paysafe;

import java.util.HashSet;
import java.util.Set;

public class Pangrams {

    public static void main(String[] args) {

        boolean isPangram = isPangram("pack my box with five dozen liquor jugs");
        boolean isPangram2 = isPangram("this is not pangram");
        System.out.println(isPangram);
        System.out.println(isPangram2);
    }

    static boolean isPangram(String string){
        string = string.toLowerCase();
        Set<Character> set = new HashSet<>();

        for (Character ch: string.toCharArray()) {
            if(ch >= 'a' && ch <= 'z'){
                set.add(ch);
            }
        }

        return set.size() == 26;
    }
}