/*
160. Intersection of Two Linked Lists
 */

package leetcode_linkedlist;

import java.util.HashSet;

public class Question_160 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        HashSet<ListNode> nodes = new HashSet<>();

        while (headA != null && headB != null) {
            if (nodes.contains(headA)) {
                return headA;
            }
            if (nodes.contains(headB)) {
                return headB;
            }
            nodes.add(headA);
            nodes.add(headB);
            headA = headA.next;
            headB = headB.next;
        }

        while (headA != null) {
            if (nodes.contains(headA)) {
                return headA;
            }
            nodes.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (nodes.contains(headB)) {
                return headB;
            }
            nodes.add(headB);
            headB = headB.next;
        }


        return null;

    }

    public void solve() {
        int[] input1 = {4,1,8,4,5};
        int[] input2 = {4,1,8,4,5};


        ListNode headA = null;
        ListNode root = null;
        for (int i : input1) {
            ListNode node = new ListNode(i);
            if (root == null) {
                root = node;
                headA = root;
                continue;
            } else {
                root.next = node;
            }
            root = root.next;
        }

        ListNode headB = null;
        root = null;
        for (int i : input2) {
            ListNode node = new ListNode(i);
            if (root == null) {
                root = node;
                headB = root;
                continue;
            } else {
                root.next = node;
            }
            root = root.next;
        }

        ListNode result = getIntersectionNode(headA, headB);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

}
