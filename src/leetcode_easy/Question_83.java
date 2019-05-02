package leetcode_easy;

import java.util.List;

public class Question_83 {

     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

    public ListNode deleteDuplicates(ListNode head) {
         if (head == null || head.next == null) {
             return head;
         }

         ListNode node = deleteDuplicates(head.next);

         if (head.val == node.val) {
             return node;
         }

         head.next = node;
         return head;
    }

     public void solve() {
         ListNode head = new ListNode(1);
         head.next = new ListNode(1);
         head.next.next = new ListNode(1);
         head.next.next.next = new ListNode(4);
         head.next.next.next.next = new ListNode(5);

         ListNode newNode = deleteDuplicates(head);
         while (newNode != null) {
             System.out.println(newNode.val);
             newNode = newNode.next;
         }

     }

}
