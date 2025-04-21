package permutations;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        Permutations p = new Permutations();
//        int[] nums = {1, 2, 3};
        String[] nums = {"A", "B", "C"};
        //        int[] nums = {1, 2};
        List<List<String>> result = p.permute(nums);
        System.out.println(result);
    }

    private List<List<String>> permute(String[] nums) {
        List<List<String>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String[] nums, List<String> current, List<List<String>> result){

        if(current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (String num: nums) {
            if(current.contains(num)) {
                continue;
            }
            current.add(num); //choose
            backtrack(nums, current, result); //explore
            current.remove(current.size() - 1); //remove
        }
    }
}
//base case checks if current permutation list equals length of nums - this is valid permutation (same length)
//list current keeps the elements
//traversal in for:

//if(current.contains(num)) continue;
//we check if iteration of num is already in the list of curr perms, if it is we skip it ()

//current.add(num);
//in current iteration of for & current num - we add this num as part of valid permutation and call backtrack

//backtrack(nums,current,result);
//call of backtrack -> nums because it is used in iteration & some checks (check for length in base case; iteration in for; contains check)

//current.remove(current.size - 1)
//after backtrack returns (we have valid permutation saved in result list) normal flow of current backtrack method (iteration in for is finished)
//we remove last index because it is already used

//in current execution of baacktrack recursive method we can still call backtrack (sinc we are resolving another permutaion)
//and we need to traverse all nums (so we iterate in for) coz we can have different states of nums ([], [1], [1,2,], etc...) i mean we need to go through all nums again


/*    Performance Analysis:
    Time Complexity: O(n!)

    There are n! permutations of n distinct numbers.

    Each permutation is built in O(n) time, but the dominant factor is the total number of permutations.

    Space Complexity:

    O(n!) for the output list storing all permutations.

    O(n) for the recursion stack and current list.
*/

/* Optimizations:
    For large n, this becomes very expensive. If you want to avoid current.contains(num) which is O(n), you can:

    Use a boolean array used[] instead to track which elements are already used, making checks O(1).

    Let me know if you'd like the version with the used[] array or with in-place swapping (which is also efficient and avoids list copying).
*/