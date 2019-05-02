package leetcode_easy;

import java.util.*;

public class Question_637 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> currentQueue = new LinkedList<>();
        currentQueue.add(root);

        while(!currentQueue.isEmpty()) {
            long sum = 0, count = 0;
            Queue<TreeNode> temp = new LinkedList<>();
            while(!currentQueue.isEmpty()) {
                while (!currentQueue.isEmpty()) {
                    TreeNode n = currentQueue.poll();
                    sum += n.val;
                    count++;
                    if (n.left != null)
                        temp.add(n.left);
                    if (n.right != null)
                        temp.add(n.right);
                }
            }
            currentQueue = temp;
            result.add(sum * 1.0 / count);
        }

        return result;
    }

    public void solve() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<Double> result = averageOfLevels(root);
        for (Double value : result) {
            System.out.println(value);
        }
    }
}
