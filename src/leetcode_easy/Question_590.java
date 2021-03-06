package leetcode_easy;

import java.util.ArrayList;
import java.util.List;

public class Question_590 {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    List<Integer> result = new ArrayList<>();

    private void iteratePostOrder(Node root) {
        if (root == null || root.children == null) {
            return;
        }
        for (Node child : root.children) {
            iteratePostOrder(child);
            result.add(child.val);
        }

    }

    public List<Integer> postorder(Node root) {
        if (root != null) {
            iteratePostOrder(root);
            result.add(root.val);
        }
        return result;
    }

    public void solve() {


        Node node3 = new Node(3, new ArrayList<>());
        node3.children.add(new Node(5, null));
        node3.children.add(new  Node(6, null));

        Node node2 = new Node(2, null);
        Node node4 = new Node(4, null);

        Node root = new Node(1, new ArrayList<>());
        root.children.add(node3);
        root.children.add(node2);
        root.children.add(node4);

        List<Integer> result = postorder(root);

        for (int i : result) {
            System.out.print(i);
        }

    }

}
