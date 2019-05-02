package leetcode_linkedlist;

import java.util.HashSet;

public class Question_817 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public int numComponents(ListNode head, int[] G) {
        int result = 0;

        HashSet<Integer> gSet = new HashSet<>();

        for (int i : G) {
            gSet.add(i);
        }

        while (head != null) {
            ListNode cur = head;
            int count = 0;
            while (cur != null && gSet.contains(cur.val)) {
                count++;
                cur = cur.next;
            }
            result += (count > 0) ? 1 : 0;

            if (cur == null) {
                break;
            }
            head = cur.next;
        }

        return result;
    }

    public void solve() {
        int[] input = {0, 1, 2};
        int[] G = {0, 2};

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

        System.out.println(numComponents(head, G));
    }

}
