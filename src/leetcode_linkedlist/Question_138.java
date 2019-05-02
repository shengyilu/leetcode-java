/*
138. Copy List with Random Pointer
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
Example 1:

Input:
{"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}

Explanation:
Node 1's value is 1, both of its next and random pointer points to Node 2.
Node 2's value is 2, its next pointer points to null and its random pointer points to itself.
 */

package leetcode_linkedlist;

import java.util.*;

public class Question_138 {

    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }


    public Node copyRandomList(Node head) {

        HashMap<Node, Node> copy = new HashMap<>();
        Node temp = head;
        while (temp != null) {
            copy.put(temp, new Node(temp.val, null, null));
            temp = temp.next;
        }

        temp = head;
        while (temp != null) {
            copy.get(temp).next = copy.get(temp.next);
            copy.get(temp).random = copy.get(temp.random);
            temp = temp.next;
        }
        return copy.get(head);
    }

    public void solve() {
        int[] input = {1, 2, 3};

    }
}
