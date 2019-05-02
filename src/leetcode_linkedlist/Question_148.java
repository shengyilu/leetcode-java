package leetcode_linkedlist;

public class Question_148 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    private ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode nextNode = sortList(head.next);

        if (nextNode.val < head.val) {
            ListNode tmp = head;
            tmp.next = nextNode.next;
            head = nextNode;
            nextNode = tmp;
            head.next = sortList(nextNode);
        } else {
            head.next = nextNode;
        }
        return head;
    }

    public void solve() {
        int[] input = {-1,5,3,4,0};

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

        ListNode result = sortList(head);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
