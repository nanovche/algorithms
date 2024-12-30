package hackerrank.others;

import java.awt.geom.Line2D;
import java.util.*;

public class Waiter {

    public static void main(String[] args) {
//        System.out.println(waiter(Arrays.asList(2,3,4,5,6,7), 3));
//        System.out.println(waiter(Arrays.asList(3,4,7,6,5), 1));
        System.out.println(waiter(Arrays.asList(3,3,4,4,9), 2));

    }
///concurerntmodification
    public static List<Integer> waiter(List<Integer> number, int q) {

        Deque<Integer> primes = new LinkedList<>(Arrays.asList(2, 3, 5, 7, 11, 13));
        Deque<Integer> divisible = new LinkedList<>();
        Deque<Integer> nonDivisible = new LinkedList<>();
        Deque<Integer> numberLinkedList = new LinkedList<>(number);
        List<Integer> answers = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            if(i > 0 ){
                numberLinkedList = new LinkedList<>(nonDivisible);
                nonDivisible.clear();
            }
            int divisor = primes.pop();
            for (int currNum: numberLinkedList) {
                if(isCurrNumDivisibleByCurrPrime(currNum, divisor)){
                    divisible.push(currNum);
                } else {
                    nonDivisible.push(currNum);
                }
            }

            addRemanining(divisible, answers);
            divisible.clear();
            if(i + 1 == q ) {
                addRemanining(nonDivisible, answers);
                break;
            }
        }
        return answers;
    }

    static void addRemanining(Deque<Integer> queue, List<Integer> answers){
        int size = queue.size();
        for (int j = 0; j < size; j++) {
            answers.add(queue.removeLast());
        }
    }

    static boolean isCurrNumDivisibleByCurrPrime(int number, int prime){
        return number % prime == 0;
    }
}