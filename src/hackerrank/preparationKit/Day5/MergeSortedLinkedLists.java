package hackerrank.preparationKit.Day5;

public class MergeSortedLinkedLists {

    public static void main(String[] args) {

    }

    static SinglyLinkedListNode mergeSorted(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

        if(head1 == null && head2 == null) {
            return null;
        } else if(head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }

        SinglyLinkedListNode merged;
        if(head1.data <= head2.data) {
            merged = head1;
            merged.next = mergeSorted(head1.next, head2);
        } else {
            merged = head2;
            merged.next = mergeSorted(head1, head2.next);
        }
        return merged;
    }

    static SinglyLinkedListNode mergeSorted2(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

        SinglyLinkedListNode current, head;

        if(head1.data <= head2.data) {
            head = head1;
            head1 = head1.next;
        } else {
            head = head2;
            head2 = head2.next;
        }
        current = head;

        while(head1 != null && head2 != null) {
            if(head1.data <= head2.data) {
                current.next = head1;
                head1 = head1.next;
            } else {
                current.next = head2;
                head2 = head2.next;
            }
            current = current.next;
        }

        if(head1 != null) {
            current.next = head1;
        } else if (head2 != null) {
            current.next = head2;
        }

        return head;
    }

    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

        SinglyLinkedListNode currentNodeNewList;
        SinglyLinkedListNode headOfFirstList = new SinglyLinkedListNode();
        SinglyLinkedListNode currentNodeFirstOldList = new SinglyLinkedListNode();
        SinglyLinkedListNode currentNodeSecondOldList = new SinglyLinkedListNode();

        int iter = 1;
        while(currentNodeFirstOldList != null && currentNodeSecondOldList != null) {
            currentNodeNewList = insertNode(head1, head2);
            currentNodeFirstOldList = traverseList(head1);
            currentNodeSecondOldList = traverseList(head2);
            if(iter == 1 ) {
                headOfFirstList = currentNodeNewList;
                iter++;
            }
        }
        return headOfFirstList;
    }

    static SinglyLinkedListNode insertNode (SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

        SinglyLinkedListNode merged;
        if(head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                merged = head1;
                merged.next = head2;
            } else {
                merged = head2;
                merged.next = head1;
            }
        } else if (head2 == null) {
            merged = head1;
        } else {
            merged = head2;
        }
        return merged.next;
    }

    static SinglyLinkedListNode traverseList (SinglyLinkedListNode head) {
        return head.next;
    }

    static class SinglyLinkedListNode {

        int data;
        SinglyLinkedListNode next;
    }
}