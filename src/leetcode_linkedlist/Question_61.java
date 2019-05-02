/*
Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL
 */

package leetcode_linkedlist;

public class Question_61 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode newHead = head;
        ListNode newTail = null;
        ListNode preTail = null;
        int size = 0;
        while(newHead != null) {
            size++;
            newHead = newHead.next;
        }
        k = k % size;

        int count = 0;
        while (count < k) {
            while (head != null) {
                if (newHead == null) {
                    newHead = head;
                }
                if (head.next != null && head.next.next == null) {
                    newTail = head.next;
                    preTail = head;
                }
                head = head.next;
            }
            if (preTail != null) {
                preTail.next = null;
            } else {
                break;
            }

            if (newTail != null) {
                newTail.next = newHead;
            } else {
                break;
            }

            newHead = newTail;
            head = newHead;

            count++;
        }
        if (newHead == null) {
            return head;
        }
        return newHead;
    }

    public void solve() {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        //root.next.next.next = new ListNode(4);
        //root.next.next.next.next = new ListNode(5);

        ListNode result = rotateRight(root, 2000000000);

        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
    }
}
