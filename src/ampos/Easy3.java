package ampos;

import java.util.HashSet;

public class Easy3 {

    class Node {
        int val;
        Node next;
        Node(int x) {
            val = x;
            next = null;
        }
    }

    public Node findCircularLinkedList(Node head) {

        HashSet<Node> nodeSet = new HashSet<>();

        while (head != null) {

            if (nodeSet.contains(head)) {
                return head;
            }
            nodeSet.add(head);
            head = head.next;
        }
        return null;
    }

    public void solve() {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = c;

        Node result = findCircularLinkedList(a);
        if (result != null) {
            System.out.println(result.val);
        } else {
            System.out.println("Not circular list");
        }

    }



}
