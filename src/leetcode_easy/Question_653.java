package leetcode_easy;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Question_653 {

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }

    Set<Integer> digitsSet = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        int diff = k - root.val;
        if (digitsSet.contains(diff)) {
            return true;
        }
        digitsSet.add(root.val);

        return findTarget(root.left, k) || findTarget(root.right, k);
    }

    public void solve() {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(findTarget(root, 10));
    }
}
