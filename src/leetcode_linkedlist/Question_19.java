package leetcode_linkedlist;

/*
19. Remove Nth Node From End of List
Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:

Given n will always be valid.

Follow up:

Could you do this in one pass?
 */

public class Question_19 {

     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

     int target = 0;
     int size = 0;
     ListNode tail = null;
     public ListNode removeNthFromEnd(ListNode head, int n) {

         if (head == null) {
             return null;
         }

         if (head.next == null) {
             target++;
             if (target == n) {
                 return null;
             }
             return head;
         }

         removeNthFromEnd(head.next, n);
         target++;
         if (target == n) {
             tail = head.next;
             return tail;
         } else if (target == n + 1) {
             head.next = tail;
             return head;
         } else {
             return head;
         }
     }



     public void solve() {
         ListNode root = new ListNode(1);
         //root.next = new ListNode(2);
//         root.next.next = new ListNode(3);
//         root.next.next.next = new ListNode(4);
//         root.next.next.next.next = new ListNode(5);

         ListNode result = removeNthFromEnd(root, 1);

         while (result != null) {
             System.out.print(result.val);
             result = result.next;
         }



     }
}
