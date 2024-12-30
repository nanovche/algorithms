package hackerrank.preparationKit.Day3;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CaesarCipher {

    public static void main(String[] args) {
//        System.out.println(caesarCipher2("abcdefghijklmnopqrstuvwxyz", 3));
        System.out.println(caesarCipher("middle-Outz", 2));
        System.out.println(caesarCipher2("middle-Outz", 2));
//        System.out.println(caesarCipher2("Always-Look-on-the-Bright-Side-of-Life", 5));
//        System.out.println(caesarCipher2("Hello_World!", 4));
//        System.out.println(caesarCipher2("1X7T4VrCs23k4vv08D6yQ3S19G4rVP188M9ahuxB6j1tMGZs1m10ey7eUj62WV2exLT4C83zl7Q80M", 27));
//        System.out.println(caesarCipher2("www.abc.xy", 87));
//        System.out.println(caesarCipher2("159357lcfd", 98));
//        System.out.println(caesarCipher2("Pz-/aI/J`EvfthGH", 66));
//        System.out.println(caesarCipher2("6DWV95HzxTCHP85dvv3NY2crzt1aO8j6g2zSDvFUiJj6XWDlZvNNr", 87));
//        System.out.println(caesarCipher2("1X7T4VrCs23k4vv08D6yQ3S19G4rVP188M9ahuxB6j1tMGZs1m10ey7eUj62WV2exLT4C83zl7Q80M", 27));
//        System.out.println(caesarCipher2("DNFjxo?b5h*5<LWbgs6?V5{3M].1hG)pv1VWq4(!][DZ3G)riSJ.CmUj9]7Gzl?VyeJ2dIPEW4GYW*scT8(vhu9wCr]q!7eyaoy.", 45));
//        System.out.println(caesarCipher2("!m-rB`-oN!.W`cLAcVbN/CqSoolII!SImji.!w/`Xu`uZa1TWPRq`uRBtok`xPT`lL-zPTc.BSRIhu..-!.!tcl!-U", 62));
    }

    public static String caesarCipher(String s, int k){

        k = k % 26;
        int i = 0;

        List<Character> rotated = new ArrayList<>();

        do {
            int c = s.charAt(i);
            c += k;
            if(c > 122) {
                c = 96 + (c % 122);
            }
            rotated.add((char)c);
            i++;
        } while (i < s.length());

        return rotated.stream().map(String::valueOf).collect(Collectors.joining());
    }



    public static String caesarCipher2(String s, int rotation) {

        List<Character> rotated = new ArrayList<>();
        Set<Character> letters = Set.of('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z');
        Set<Character> lettersUppercase = Set.of('A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W', 'X','Y','Z');

        char firstLetterCode = 97;
        char lastLetterCode = 122;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            boolean lowercase = letters.contains(currentChar);
            boolean uppercase = lettersUppercase.contains(currentChar);

            if (lowercase || uppercase) {
                //convert to lowercase so inbounds and rotation work
                currentChar = toLowerCase(currentChar, lowercase);
                if(inBounds((char)(currentChar + rotation))){
                    if(uppercase) {
                        String upperCaseChar = String.valueOf((char) (currentChar + rotation)).toUpperCase();
                        rotated.add(upperCaseChar.charAt(0));
                    } else {
                        rotated.add((char) (currentChar + rotation));
                    }
                } else {
                    int newRotation = rotation;
                    do{
                        /*first time currecntchar is for sure less than 122 */
                        newRotation = calculateNewRotationValue(newRotation, lastLetterCode, currentChar);
                        /*we set char to 1 before 97('a') */
                        currentChar = (char)(firstLetterCode - 1);
                    } while(!inBounds((char)(currentChar + newRotation)));
                    currentChar = (char)(currentChar + newRotation);
                    currentChar = lowercase ? currentChar : String.valueOf(currentChar).toUpperCase().charAt(0);
                    rotated.add(currentChar);
                }
            } else { //if not letter we just add it
                rotated.add(currentChar);
            }
        }
        return rotated.stream().map(String::valueOf).collect(Collectors.joining());
    }

    static char toLowerCase(char currentChar, boolean lowercase){
        currentChar = lowercase ? currentChar : String.valueOf(currentChar).toLowerCase().charAt(0);
        return currentChar;
    }

    static int calculateNewRotationValue(int currentRotationValue, char lastLetterCode, char currentCharValue){
        return currentRotationValue - (lastLetterCode - currentCharValue);
    }
    static boolean inBounds(char c) {
        return c <= 122;
    }
}