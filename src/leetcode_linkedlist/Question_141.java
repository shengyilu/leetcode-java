package leetcode_linkedlist;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Question_141 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
           val = x;
           next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();

        while (head != null) {
            if (nodeSet.contains(head.next)) {
                return true;
            }
            nodeSet.add(head);
            head = head.next;
        }

        return false;
    }

    public void solve() {
        int[] input = {1, 2, 3};

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

        hasCycle(head);
    }

}
