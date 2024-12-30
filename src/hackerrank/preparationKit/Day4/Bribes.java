package hackerrank.preparationKit.Day4;

import java.util.*;

public class Bribes {

    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {

        List<int[]> testCases = new ArrayList<>();

        // Example test case
        testCases.add(new int[]{2, 1, 5, 3, 4}); // Expected: 3
        testCases.add(new int[]{2, 5, 1, 3, 4}); // Expected: Too chaotic

        for (int[] queue : testCases) {
            minimumBribes(queue);
        }

/*
        bribes(Arrays.asList(2, 5, 1, 3, 4));
        bribes(Arrays.asList(2,1,5,3,4));
        bribes(Arrays.asList(5, 1, 2, 3, 7, 8, 6, 4));
        bribes(Arrays.asList(1, 2, 5, 3, 7, 8, 6, 4));
        bribes(Arrays.asList(1, 2, 5, 3, 4, 7, 8, 6));

        boolean chaotic = false;
        for (int el: map.values()) {
            if(el > 2) {
                System.out.println("Too Chaotic");
                chaotic = true;
            }
        };

        if(!chaotic) {
            System.out.println(map.values().stream().mapToInt(i -> i).sum());
        }
*/
    }
    
    private static void bribes (List<Integer> queue) {

        for (int el: queue) {
            map.put(el, 0);
        }

        for (int i = 0; i < queue.size(); i++) {

            for (int j = i + 1; j < queue.size(); j++) {

                if(queue.get(i) > queue.get(j)){
                    int key = queue.get(i);
                    map.put(key, map.get(key) + 1);
                }
            }
        }
    }

    static void minimumBribes(int[] q) {
        int bribes = 0;

        // Start checking the queue from the end
        for (int i = q.length - 1; i >= 0; i--) {
            // Check if the person moved too far ahead
            if (q[i] - (i + 1) > 2) {
                System.out.println("Too chaotic");
                return;
            }

            // Count the number of bribes for this person
            for (int j = Math.max(0, q[i] - 2); j < i; j++) {
                if (q[j] > q[i]) {
                    bribes++;
                }
            }
        }

        System.out.println(bribes);
    }
}