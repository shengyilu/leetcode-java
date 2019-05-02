package leetcode_easy;

import java.util.ArrayList;
import java.util.List;

public class Question_559 {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    private int maxDepth = 0;

    private void walkThrough(Node root, int depth) {
        if (root == null) {
            if (maxDepth < depth - 1) {
                maxDepth = depth - 1;
            }
            return;
        }

        if (root.children == null || root.children.size() == 0) {
            if (maxDepth < depth) {
                maxDepth = depth;
            }
            return;
        }

        for (Node n : root.children) {
            walkThrough(n, depth + 1);
        }
    }

    private int findDepth(Node root, int depth) {
        if (root == null) {
            return depth;
        }
        depth++;
        int maxLen = depth;

        if (root.children == null || root.children.size() == 0) {
            return depth;
        }

        for (Node node : root.children) {
            int currentLen = findDepth(node, depth);
            if (currentLen >= maxLen) {
                maxLen = currentLen;
            }
        }
        return maxLen;
    }


    public int maxDepth(Node root) {

        if (root == null) {
            return 0;
        }
        //walkThrough(root, 1);
        //return maxDepth;
        return findDepth(root, 0);
    }

    public void solve() {


        Node node3 = new Node(3, new ArrayList<>());
        node3.children.add(new Node(5, null));
        node3.children.add(new Node(6, null));

        Node node2 = new Node(2, null);
        Node node4 = new Node(4, null);

        Node root = new Node(1, new ArrayList<>());
        root.children.add(node3);
        root.children.add(node2);
        root.children.add(node4);

        Node test = new Node(44, new ArrayList<>());
        System.out.println("Max depth:" + maxDepth(root));

    }

}
