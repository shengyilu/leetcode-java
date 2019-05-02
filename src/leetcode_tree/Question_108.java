/*
108. Convert Sorted Array to Binary Search Tree

Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
 */


package leetcode_tree;

import leetcode_linkedlist.Question_61;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Question_108 {

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        return toBST(nums, 0, nums.length -1);
    }

    public TreeNode toBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int middle = (right + left) / 2;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = toBST(nums, left, middle - 1);
        root.right = toBST(nums, middle + 1, right);
        return root;
    }

    private void leverOrderPrint(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        ((LinkedList<TreeNode>) q).push(root);
        while (!q.isEmpty()) {
            TreeNode node = ((LinkedList<TreeNode>) q).pop();
            System.out.println(node.val);
            if (node.left != null) {
                ((LinkedList<TreeNode>) q).push(node.left);
            }

            if (node.right != null) {
                ((LinkedList<TreeNode>) q).push(node.right);
            }

        }

    }

    public void solve() {
        int[] input = {-10,-3,0,5,9};

        TreeNode node = sortedArrayToBST(input);


        leverOrderPrint(node);

    }
}
