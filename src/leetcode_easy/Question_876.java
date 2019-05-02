package leetcode_easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question_876 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode middleNode(ListNode head) {
        Map<Integer, ListNode> listMap = new HashMap<>();

        int index = 0;
        while (head != null) {
            listMap.put(index, head);
            head = head.next;
            index++;
        }
        return listMap.get(index / 2);
    }

    public void solve() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        System.out.println(middleNode(head).val);

    }
}
