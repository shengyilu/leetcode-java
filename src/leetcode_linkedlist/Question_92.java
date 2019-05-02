package leetcode_linkedlist;

import java.util.Stack;

public class Question_92 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }

        ListNode newHead = null;
        Stack<ListNode> preserve = new Stack<>();
        Stack<ListNode> reverse = new Stack<>();

        ListNode reversedTail = null;
        ListNode reversedHead = null;

        int step = 0;
        boolean isComplete = false;
        while (head != null || reverse.size() > 0) {
            step++;

            if (step >= m && step <= n) {
                if (step == m) {
                    reversedTail = head;
                }
                reverse.push(head);
                head = head.next;
                continue;
            }

            while (reverse.size() > 0) {
                if (reversedHead == null) {
                    if (preserve.size() > 0) {
                        reversedHead = preserve.pop();
                    }

                    if (reversedHead == null) {
                        reversedHead = reverse.pop();
                    }
                    if (newHead == null) {
                        while (preserve.size() > 0) {
                            newHead = preserve.pop();
                        }
                        newHead = newHead == null ? reversedHead : newHead;
                    }
                } else {
                    reversedHead.next = reverse.pop();
                    reversedHead = reversedHead.next;

                    if (reverse.size() == 0) {
                        reversedTail.next = head;
                        isComplete = true;
                    }
                }
            }

            if (isComplete) {
                break;
            }

            preserve.push(head);
            if (head != null) {
                head = head.next;
            }
        }


        return newHead;
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
        ListNode result = reverseBetween(head, 2, 3);
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
    }
}
