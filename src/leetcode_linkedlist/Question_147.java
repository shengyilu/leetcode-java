package leetcode_linkedlist;

public class Question_147 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode insertionSortList(ListNode head) {

        ListNode preCur = null;
        ListNode originalHead = head;

        while (head != null) {
            if (preCur == null) {
                preCur = head;
                head = head.next;
                continue;
            }

            if (head.val < preCur.val) {
                ListNode tmp = head;
                preCur.next = head.next;

                originalHead = reorder(originalHead, tmp);
                head = preCur.next;
            } else {
                preCur = head;
                head = head.next;
            }

        }
        return originalHead;
    }

    private ListNode reorder(ListNode head, ListNode target) {

        ListNode originalHead = head;

        ListNode preCur = null;
        while (head != null) {
            if (target.val <= head.val) {
                target.next = head;
                if (preCur != null) {
                    preCur.next = target;
                } else {
                    originalHead = target;
                }
                break;
            }

            preCur = head;
            head = head.next;
        }
        return originalHead;
    }



    public void solve() {
        int[] input = {4,2, 1, 3};

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

        ListNode result = insertionSortList(head);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
