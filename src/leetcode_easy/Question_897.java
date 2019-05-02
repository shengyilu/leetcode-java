package leetcode_easy;

import java.util.ArrayList;
import java.util.List;

public class Question_897 {

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }

    List<TreeNode> inOrder = new ArrayList<>();

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        inOrder.add(root);
        inOrder(root.right);

    }

    public TreeNode increasingBST(TreeNode root) {

        inOrder(root);

        for (int i = 0; i < inOrder.size(); i++) {
            TreeNode head = inOrder.get(i);
            System.out.println(head.val);
            head.left = null;
            if (i + 1 < inOrder.size()) {
                head.right = inOrder.get(i + 1);
            } else {
                head.right = null;
            }
        }
        return inOrder.get(0);
    }

    public void solve() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);

        root.right = new TreeNode(6);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(9);

        increasingBST(root);

    }
}
