package leetcode_dfs;

import frequent_question.Question_57;

/*
98. Validate Binary Search Tree
Given a binary tree, determine if it is a valid binary search tree (BST).
Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:

Input:
    2
   / \
  1   3
Output: true
Example 2:

    5
   / \
  1   4
     / \
    3   6
Output: false
Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
             is 5 but its right child's value is 4.

             [10,5,15,null,null,6,20]

   10
   / \
  5  15
     / \
    6   20

*
* */
public class Question_98 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return walkThrough(root, null, null);
    }

    public boolean walkThrough(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if ( (min != null && root.val <= min) || (max != null && root.val >= max)) {
            return false;
        }

        return walkThrough(root.left, min, root.val) && walkThrough(root.right, root.val, max);
    }

    public void solve() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);

        System.out.println("Answer:" + isValidBST(root));


    }
}
