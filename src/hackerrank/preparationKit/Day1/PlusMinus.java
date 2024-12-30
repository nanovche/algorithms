package hackerrank.preparationKit.Day1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlusMinus {

/*
    getOrDefault vs get(key) != null
    cast one operand to float when dividing to get floating point
*/

    public static void main(String[] args) {
//        plusMinus(Arrays.asList(1,1,0,-1,-1));
//        plusMinus(Arrays.asList(-4, 3, -9, 0, 4, 1));
        plusMinus(Arrays.asList(1, -2, -7, 9, 1, -8, -5));
    }

    public static void plusMinus(List<Integer> arr) {
        Map<String, Integer> numbers = numbers(arr);
        System.out.printf("%f%n", (float)numbers.getOrDefault("POSITIVE",0) / arr.size());
        System.out.printf("%f%n", (float)numbers.getOrDefault("NEGATIVE",0) / arr.size());
        System.out.printf("%f%n", (float)numbers.getOrDefault("ZERO", 0) / arr.size());
    }

    static Map<String, Integer> numbers(List<Integer> arr) {
        Map<String, Integer> nums = new HashMap<>();
        for (int i: arr) {
            if(i == 0) {
                nums.put("ZERO", nums.get("ZERO") != null ? nums.get("ZERO") + 1 : 1);
            } else if (i < 0) {
                nums.put("NEGATIVE", nums.get("NEGATIVE") != null ? nums.get("NEGATIVE") + 1 : 1);
            } else {
                nums.put("POSITIVE", nums.get("POSITIVE") != null ? nums.get("POSITIVE") + 1 : 1);
            }
/*
            if(i == 0) {
                nums.put("ZERO", nums.getOrDefault("ZERO", 0) + 1);
            } else if (i < 0) {
                nums.put("NEGATIVE", nums.getOrDefault("NEGATIVE", 0) + 1);
            } else {
                nums.put("POSITIVE", nums.getOrDefault("POSITIVE", 0) + 1);
            }
*/
        }
        return nums;
    }
}