package hackerrank.preparationKit.Day4;

import java.util.Arrays;

public class SuperDigit {

    static int count = 0;

    public static void main(String[] args) {
        System.out.println(superDigit3("9875", 4));
    }

    static int superDigit2(String num, int k){

        int sum = Arrays.stream(num.split("")).mapToInt(Integer::valueOf).sum();
        int initialSum = sum * k;
        return findSuperDigit2(initialSum);
    }

    static int findSuperDigit2(int num){

        if(num < 10) {
            return num;
        }

        int nextSum = 0;
        while(num > 0){
            nextSum += num % 10;
            num /= 10;
        }

        return findSuperDigit2(nextSum);
    }

    public static int superDigit(String num, int k) {

        if(count == 0){
//            num = num.repeat(k);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < k; i++) {
                sb.append(num);
            }
            num = sb.toString();
            count++;
        }

        if(num.length() == 1) {
            return Integer.parseInt(num);
        }

        String[] nums = num.split("");
        int number = Arrays.stream(nums).mapToInt(Integer::valueOf).sum();
        return superDigit(String.valueOf(number), k);

    }

    public static int superDigit3(String n, int k) {
        // Write your code here
        long sum;
        boolean first = true;

        do {
            sum = 0L;

            for (int i = 0; i < n.length(); ++i) {
                sum += n.charAt(i) - '0';
            }

            if (first) {
                first = false;
                sum *= (long)k;
            }

            n = String.valueOf(sum);
        } while (sum > 10);

        return (int)sum;
    }
}