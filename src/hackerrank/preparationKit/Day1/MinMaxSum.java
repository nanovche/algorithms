package hackerrank.preparationKit.Day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
*  since you have only 4 of 5 to calculate min and max -> you need to sort them first
*  convert to long
* */
public class MinMaxSum {

    public static void main(String[] args) {
//        miniMaxSum(Arrays.asList(1,3,5,7,9));
//        miniMaxSum(Arrays.asList(1,2,3,4,5));
        miniMaxSum(Arrays.asList(7,69,2,221,8974));
    }

    public static void miniMaxSum(List<Integer> arr) {
        List<Long> longArr = new ArrayList<>();
        arr.forEach(i -> longArr.add((long)i));

        List<Long> sortedList = longArr.stream().sorted().collect(Collectors.toList());

        System.out.println(sortedList.subList(0, arr.size() - 1).stream().mapToLong(Long::longValue).sum() +
                " " + sortedList.subList(1, arr.size()).stream().mapToLong(Long::longValue).sum());
    }
}