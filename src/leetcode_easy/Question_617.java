package leetcode_easy;

import apple.laf.JRSUIUtils;

public class Question_617 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }

        TreeNode t1_left = null, t1_right = null, t2_left = null, t2_right = null;
        int val = 0;

        if (t1 != null) {
            val += t1.val;
            t1_left = t1.left;
            t1_right = t1.right;
        }

        if (t2 != null) {
            val += t2.val;
            t2_left = t2.left;
            t2_right = t2.right;
        }

        TreeNode mergeNode = new TreeNode(val);
        mergeNode.left = mergeTrees(t1_left, t2_left);
        mergeNode.right = mergeTrees(t1_right, t2_right);
        return mergeNode;
    }

    private void preOrderTravasal(TreeNode node) {
        if (node == null) {
            return;
        }

        System.out.print(node.val);
        preOrderTravasal(node.left);
        preOrderTravasal(node.right);

    }

    public void solve() {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(3);
        t1.right = new TreeNode(2);
        t1.left.left = new TreeNode(5);

        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(3);
        t2.left.right = new TreeNode(4);
        t2.right.right = new TreeNode(7);

        TreeNode merged = mergeTrees(t1, t2);

        preOrderTravasal(merged);

    }

}
