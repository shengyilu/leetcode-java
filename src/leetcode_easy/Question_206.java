package leetcode_easy;

import java.util.List;

public class Question_206 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode dfs(ListNode head, ListNode preHead) {
        if (head == null) {
            return preHead;
        }

        dfs(head.next, head);
        System.out.println(head.val);
        return head;
    }


    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            if (head != null) {
                System.out.println(head.val);
            }
            return head;
        }
        ListNode p = reverseList(head.next);
        System.out.println(head.val);

        head.next.next = head;
        head.next = null;

        return p;
    }

    public void solve() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        reverseList(head);
    }
}
