package hackerrank.preparationKit.Day2;

import java.util.*;

/*
*
* use set for better complexity - O(1) for add,contains,remove
*
* */
public class LonelyInteger {

    public static void main(String[] args) {
        System.out.println(lonelyinteger(Arrays.asList(1,2,3,2,1)));
    }

    public static int lonelyinteger(List<Integer> a) {
        Set<Integer> ints = new HashSet<>();
        for (Integer currentNumber: a) {
            if(ints.contains(currentNumber)){
                ints.remove(currentNumber);
            } else {
                ints.add(currentNumber);
            }
        }
        return ints.iterator().next();
    }
}