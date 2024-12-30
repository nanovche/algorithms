package hackerrank.preparationKit.Day5;

import java.util.Scanner;
import java.util.Stack;

public class QueueTwoStacks {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Queue<Integer> queue = new Queue<>();

        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int queryType = scanner.nextInt();
            if(queryType == 1) {
                int x = scanner.nextInt();
                queue.push(x);
            } else if (queryType == 2) {
                queue.pop();
            } else if (queryType == 3) {
                System.out.println(queue.peek());
            }
        }
        scanner.close();

    }
}

class Queue<E> {

    Stack<E> stackInsert;
    Stack<E> stackDelete;

    public Queue() {
        this.stackInsert = new Stack<E>();
        this.stackDelete = new Stack<E>();
    }

    public void push(E element){
        stackInsert.push(element);
    }

    //we don't need the element here; thats why void
    public void pop(){
        if(stackDelete.isEmpty()) {
            while(!stackInsert.isEmpty()){
                stackDelete.push(stackInsert.pop());
            }
        }
        stackDelete.pop();
    }

    public E peek(){
        if(stackDelete.isEmpty()) {
            while(!stackInsert.isEmpty()){
                stackDelete.push(stackInsert.pop());
            }
        }
        return stackDelete.peek();
    }
}