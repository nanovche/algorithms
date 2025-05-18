import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    static Map<Integer, Integer> memo = new HashMap<>();

    static boolean[] computed = new boolean[1000];
    static int[] memo2 = new int[1000];
    public static void main(String[] args) {
        System.out.println(fib(6));
        System.out.println(fib2(8));
    }

    static int fib(int n) {

        if(n == 0) {
            return 0;
        } else if(n == 1) {
            return 1;
        } else if(memo.containsKey(n)) {
            return memo.get(n);
        } else {
            int result =  fib(n - 1) + fib(n - 2);
            memo.put(n, result);
            return result;
        }
    }
    static int fib2(int n) {

        if(n == 0) {
            return 0;
        } else if(n == 1) {
            return 1;
        } else if(computed[n]) {
            return memo2[n];
        } else {
            memo2[n] =  fib(n - 1) + fib(n - 2);
            computed[n] = true;
            return memo2[n];
        }
    }
}
