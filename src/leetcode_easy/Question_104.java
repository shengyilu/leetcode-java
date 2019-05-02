package leetcode_easy;

public class Question_104 {

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }

    int maxDepth = 0;
    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            if (maxDepth < depth) {
                maxDepth = depth;
            }
            return;
        }
        depth++;
        dfs(root.left, depth);
        dfs(root.right, depth);
    }

    public int maxDepth(TreeNode root) {
         dfs(root, 0);
         return maxDepth;
    }

    public void solve() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(maxDepth(root));

    }


}
