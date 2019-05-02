package leetcode_easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Question_429 {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            Queue<Node> temp = new LinkedList<>();
            while(!queue.isEmpty()) {
                Node currentNode = queue.poll();
                level.add(currentNode.val);
                //System.out.println("queue.size:" + queue.size());
                if (currentNode.children != null && currentNode.children.size() != 0) {
                    temp.addAll(currentNode.children);
                    //System.out.println("temp.size:" + temp.size());
                }
            }
            result.add(level);
            queue = temp;

        }
        return result;
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

        List<List<Integer>> ans = levelOrder(root);
        for (List<Integer> list : ans) {
            for (Integer value : list) {
                System.out.print(value);
            }
            System.out.println("");
        }

    }

}
