/*
82. Remove Duplicates from Sorted List II
Given a sorted linked list, delete all nodes that have duplicate numbers,
leaving only distinct numbers from the original list.

Example 1:

Input: 1->2->3->3->4->4->5
Output: 1->2->5
Example 2:

Input: 1->1->1->2->3
Output: 2->3

*/

package leetcode_linkedlist;

import sun.rmi.runtime.Log;

public class Question_82 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode fake = new ListNode(Integer.MIN_VALUE);
        fake.next = head;
        ListNode preNode = fake;
        int duVal = Integer.MIN_VALUE;

        while (head != null) {
            System.out.println("head.val:" + head.val + ", duval:" + duVal);

            if ((preNode != fake || duVal != Integer.MIN_VALUE) && head.val == duVal) {
                preNode.next = head.next;
                head = head.next;
                continue;
            }

            if (head.next == null) {
                break;
            }

            if (head.val != head.next.val) {
                preNode = head;
                head = head.next;
                continue;
            }

            if (head.val == head.next.val) {
                duVal = head.val;
                preNode.next = head.next.next;
                head = preNode.next;
            }
        }

        return fake.next;
    }


    public void solve() {
        int[] input = {1, 1 , 1, 2, 3 , 4, 4, 4, 5, 5, 6};

        ListNode head = null;
        ListNode root = null;
        for (int i : input) {
            ListNode node = new ListNode(i);
            if (root == null) {
                root = node;
                head = root;
                continue;
            } else {
                root.next = node;
            }
            root = root.next;
        }
        ListNode result = deleteDuplicates(head);
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
    }
}
