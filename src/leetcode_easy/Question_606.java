package leetcode_easy;

public class Question_606 {

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }

    int parenthesis = 0;

    public String dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return sb.toString();
        }
        sb.append(root.val);
        String left = dfs(root.left, sb);
        String right = dfs(root.right, sb);



        return null;
    }

    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        String root = String.valueOf(t.val);
        System.out.println(root);

        String left = tree2str(t.left);
        String right = tree2str(t.right);


        System.out.println("left:" + left + ", right:" + right);
        if (left.isEmpty() && right.isEmpty()) {
            return root;
        }

        if (left.isEmpty()) {
            return root + "()" + "(" + right + ")";
        }

        if (right.isEmpty()) {
            return root + "(" + left + ")";
        }

        return root + "(" + left + ")" + "(" + right + ")";

    }

    public void solve() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(3);

        System.out.println(tree2str(root));
    }

}
