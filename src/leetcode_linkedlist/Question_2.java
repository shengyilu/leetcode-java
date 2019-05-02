package leetcode_linkedlist;

/*
2. Add Two Numbers
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 */

import leetcode_dfs.Question_98;

import java.util.List;

public class Question_2 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = null;
        ListNode head = null;

        int carry = 0;
        while (l1 != null && l2 != null) {
            int digitSum = l1.val + l2.val + carry;

            carry = (digitSum >= 10) ? 1 : 0;
            int remain = digitSum % 10;
            if (head == null) {
                head = new ListNode(remain);
                sum = head;
            } else {
                sum.next = new ListNode(remain);
            }
            l1 = l1.next;
            l2 = l2.next;
            if (sum.next != null) {
                sum = sum.next;
            }
        }

        while (l1 != null) {
            int digitSum = l1.val + carry;
            carry = (digitSum >= 10) ? 1 : 0;
            int remain = digitSum % 10;
            if (head == null) {
                head = new ListNode(remain);
                sum = head;
            } else {
                sum.next = new ListNode(remain);
            }
            l1 = l1.next;
            if (sum.next != null) {
                sum = sum.next;
            }
        }

        while (l2 != null) {
            int digitSum = l2.val + carry;
            carry = (digitSum >= 10) ? 1 : 0;
            int remain = digitSum % 10;
            if (head == null) {
                head = new ListNode(remain);
                sum = head;
            } else {
                sum.next = new ListNode(remain);
            }
            l2 = l2.next;
            if (sum.next != null) {
                sum = sum.next;
            }
        }

        System.out.println(carry);
        if (carry != 0) {
            sum.next = new ListNode(carry);
        }

        return head;
    }

    public void solve() {
        ListNode l1 = new ListNode(1);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);

        ListNode sum = addTwoNumbers(l1, l2);

        while (sum != null) {
            System.out.print(sum.val);
            sum = sum.next;
        }

    }

}
