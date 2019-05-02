/*
24. Swap Nodes in Pairs
Given a linked list, swap every two adjacent nodes and return its head.
You may not modify the values in the list's nodes, only nodes itself may be changed.

Example:
Given 1->2->3->4, you should return the list as 2->1->4->3.
 */

package leetcode_linkedlist;

public class Question_24 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    public ListNode swapPairs(ListNode head) {

        ListNode newHead = null;
        ListNode tail = null;
        ListNode temp = null;
        int count = 0;
        while(head != null) {
            count++;
            if (count % 2 == 0) {
                if (newHead == null) {
                    newHead = head;
                }

                temp.next = head.next;
                head.next = temp;
                if (tail != null) {
                    tail.next = head;
                }
                tail = temp;

                head = temp.next;
            } else {
                temp = head;
                head = head.next;
            }
        }

        if (count == 1) {
            newHead = temp;
        }
        return newHead;
    }

    public void solve() {
        ListNode root = new ListNode(1);
        //root.next = new ListNode(2);
        //root.next.next = new ListNode(3);
        //root.next.next.next = new ListNode(4);

        ListNode result = swapPairs(root);

        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
    }

}
