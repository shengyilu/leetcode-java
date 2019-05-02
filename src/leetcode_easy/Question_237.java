package leetcode_easy;

public class Question_237 {
     public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
     }

     ListNode head = null;

     public void deleteNode(ListNode node) {
         if (node == null) {
             return;
         }

         if (node.next != null) {
             node.val = node.next.val;
             node.next = node.next.next;
         }
     }

     public void solve() {
         head = new ListNode(4);
         head.next = new ListNode(5);
         head.next.next = new ListNode(1);
         head.next.next.next = new ListNode(9);

         deleteNode(head.next.next.next);

         while (head != null) {
             System.out.println(head.val);
             head = head.next;
         }
     }

}
