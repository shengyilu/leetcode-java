package leetcode_easy;

public class Question_671 {

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }

    int minimun = -1;
    int answer = Integer.MAX_VALUE;

    private void dfs(TreeNode root) {
        if (root != null) {
            if (minimun == root.val) {
                dfs(root.left);
                dfs(root.right);
            } else {
                if (minimun < root.val && root.val < answer) {
                    answer = root.val;
                }
            }
        }
    }

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return answer;
        }
        minimun = root.val;
        dfs(root);

        answer = (answer != Integer.MAX_VALUE) ? answer : -1;

        return answer;
    }


}
