package hackerrank.preparationKit.Day6;

import java.util.*;

public class Cookies {

    public static void main(String[] args) {
//        System.out.println(cookies(9, new ArrayList<>(Arrays.asList(2,7,3,6,4,6))));
//        System.out.println(cookies(7, new ArrayList<>(Arrays.asList(1,2,3,9,10,12))));
//        System.out.println(cookies(200, new ArrayList<>(Arrays.asList(5, 6, 7))));
        System.out.println(cookies2(8467293, new ArrayList<>(Arrays.asList(13, 47, 74, 12, 89, 74, 18, 38))));
//        System.out.println(cookies2(1000, new ArrayList<>(Arrays.asList(52, 96, 13, 37))));
    }

    public static Integer cookies(int k, List<Integer> A) {

        ArrayDeque<Integer> queue = new ArrayDeque<>(A);
        // Write your code here
        int count = 0;

        while(Collections.min(queue) < k){
            if(queue.getFirst() < k && queue.size() == 1) {
                return -1;
            }
            int el1 = queue.stream().min(Comparator.comparingInt(x -> x)).get();
            if(el1 < k) {
                queue.remove(el1);
            }
            int el2 = queue.stream().min(Comparator.comparingInt(x -> x)).get();
            if(el2 < k){
                queue.remove(el2);
            }
            int elToInsert = el1 + 2*el2;
            queue.offerFirst(elToInsert);
            count++;
        }

        return count;
    }

    public static Integer cookies2(int k, List<Integer> A) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(A);
        int operations = 0;

        while (minHeap.size() > 1 && minHeap.peek() < k) {
            int leastSweet = minHeap.poll();
            int secondLeastSweet = minHeap.poll();
            int newSweetness = leastSweet + 2 * secondLeastSweet;
            minHeap.add(newSweetness);
            operations++;
        }

        return minHeap.peek() >= k ? operations : -1;
    }
}