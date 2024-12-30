package hackerrank.preparationKit.Day5;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedBrackets {

    static Map<Character, Character> pairs = new HashMap<>(){{
        put('}', '{');
        put(')', '(');
        put(']', '[');
    }};
    public static void main(String[] args) {
//        System.out.println(isBalanced("{[()]}"));
//        System.out.println(isBalanced("{{[[(())]]}}"));
//        System.out.println(isBalanced("{[(])}"));
//        System.out.println(isBalanced("{{([])}}"));
//        System.out.println(isBalanced("{{)[](}}"));
//        System.out.println(isBalanced("}][}}(}][))]"));
        System.out.println(isBalanced("{{}("));
    }
    private static String isBalanced(String s){

        Stack<Character> stack = new Stack<>();
        String balanced = "YES";

        for (int i = 0; i < s.length(); i++) {
            char currentBracket = s.charAt(i);
            if(currentBracket == '{' || currentBracket == '(' || currentBracket == '[') {
                stack.push(currentBracket);
            } else {
                if(!stack.isEmpty() && pairs.get(currentBracket) == stack.peek()){
                    stack.pop();
                } else {
                    balanced = "NO";
                    break;
                }
            }
        }

        if(!stack.isEmpty()) {
            balanced = "NO";
        }

        return balanced;
    }
}