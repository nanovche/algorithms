package paysafe;

public class InterleaveTwoStrings {

    public static void main(String[] args) {
        System.out.println(password("hackerrank", "mountain"));
    }

    static String password(String s1, String s2){

        int lens = s1.length();
        int lens2 = s2.length();

        int shorterStringLen = Math.min(lens, lens2);
        StringBuilder longer = new StringBuilder(lens > lens2  ? s1 : s2);

        StringBuilder pwd = new StringBuilder();
        for (int i = 0; i < shorterStringLen; i++) {
            pwd.append(s1.charAt(i));
            pwd.append(s2.charAt(i));
        }

        pwd.append(longer.substring(shorterStringLen));
        return pwd.toString();
    }
}