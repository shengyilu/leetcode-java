package leetcode_easy;

import java.util.*;

public class Question_784 {

    class Node {
        char val;
        Node left;
        Node right;

        public Node(char val) {
            this.val = val;
        }
    }

    List<String> result = new ArrayList<>();

    private void walkThrough(Node root, int step, char[] charCombination) {
        if (root == null) {
            return;
        }

        charCombination[step] = root.val;
        if (step == charCombination.length - 1) {
            //System.out.println(new String(charCombination));
            result.add(new String(charCombination));
            return;
        }

        walkThrough(root.left, step + 1, charCombination);
        walkThrough(root.right, step + 1, charCombination);
    }


    public List<String> letterCasePermutation(String S) {
        if (S.length() == 0) {
            result.add(S);
            return result;
        }
        char[] sArray = S.toCharArray();

        Node root = new Node('#');
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        for (char c : sArray) {
            //System.out.println("c:" + c);
            Queue<Node> temp = new LinkedList<>();
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                //System.out.println(node.val);
                Node left = new Node(c);
                temp.add(left);
                node.left = left;

                Node right = null;
                if (c >= 'a' && c <= 'z') {
                    right = new Node((char) (c - 'a' + 'A'));

                } else if (c >= 'A' && c <= 'Z') {
                    right = new Node((char) (c - 'A' + 'a'));
                }
                if (right != null) {
                    temp.add(right);
                    node.right = right;
                }
            }
            queue = temp;
        }
        walkThrough(root.left, 0, new char[S.length()]);
        walkThrough(root.right, 0, new char[S.length()]);
        return result;

    }

    public void solve() {
       String S = "a1b2";

       letterCasePermutation(S);
    }
}
