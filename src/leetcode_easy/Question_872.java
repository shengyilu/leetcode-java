package leetcode_easy;

public class Question_872 {

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }

    private String walkThrough(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return null;
        }
        String left = walkThrough(root.left, sb);
        String right = walkThrough(root.right, sb);
        if (left == null && right == null) {
            sb.append(root.val);
        }
        return sb.toString();
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        String leaf1 = walkThrough(root1, new StringBuilder());
        String leaf2 = walkThrough(root2, new StringBuilder());
        return leaf1.equals(leaf2);
    }

    public void solve() {
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(5);
        root1.left.left = new TreeNode(6);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(4);
        root1.right = new TreeNode(1);
        root1.right.left = new TreeNode(9);
        root1.right.right = new TreeNode(8);

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(4);
        root2.left.left = new TreeNode(6);
        root2.left.right = new TreeNode(9);
        root2.left.right.left = new TreeNode(7);
        root2.left.right.right = new TreeNode(4);
        root2.right = new TreeNode(6);
        root2.right.left = new TreeNode(9);
        root2.right.right = new TreeNode(8);


        leafSimilar(root1, root2);

    }

}
