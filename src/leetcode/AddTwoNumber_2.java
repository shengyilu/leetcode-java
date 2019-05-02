package leetcode;

/*
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order and each of their nodes contain a single digit.
Add the two numbers and return it as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

*/


import java.util.Arrays;

public class AddTwoNumber_2 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) {
            return null;
        }

        ListNode root = new ListNode(0);
        ListNode head = root;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            carry = sum/10;
            head.next = new ListNode(sum % 10);
            head = head.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode temp = null;
        if (l1 != null) {
            temp = l1;
        } else {
            temp = l2;
        }

        while (temp != null) {
            int sum = temp.val + carry;
            carry = sum/10;
            head.next = new ListNode(sum % 10);
            head = head.next;
            temp = temp.next;
            if (temp == null && carry > 0) {
                temp = new ListNode(0);
            }
        }

        if (carry > 0) {
            head.next = new ListNode(carry);
        }

        return root.next;
    }

    public void solve() {
        ListNode val1 = new ListNode(5);
//        val1.next = new ListNode(4);
//        val1.next.next = new ListNode(3);


        ListNode val2 = new ListNode(5);
//        val2.next = new ListNode(6);
//        val2.next.next = new ListNode(4);

        ListNode answer = addTwoNumbers(val1, val2);

        while (answer != null) {
            System.out.println("digit:" + (answer.val));
            answer = answer.next;
        }

    }
}
