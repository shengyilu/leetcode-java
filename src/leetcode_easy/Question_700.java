package leetcode_easy;

import apple.laf.JRSUIUtils;

public class Question_700 {

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

     public TreeNode searchBST(TreeNode root, int val) {
         if (root == null) {
             return null;
         }
         if (root.val == val) {
             return root;
         } else {
             if (val < root.val) {
                 return searchBST(root.left, val);
             } else {
                 return searchBST(root.right, val);
             }
         }
     }

     private void preOrder(TreeNode root) {
         if (root == null) {
             return;
         }

         System.out.print(root.val);
         preOrder(root.left);
         preOrder(root.right);
     }

     public void solve() {
         TreeNode root = new TreeNode(4);
         root.left = new TreeNode(2);
         root.right = new TreeNode(7);
         root.left.left = new TreeNode(1);
         root.left.right = new TreeNode(3);

         TreeNode node = searchBST(root, 2);
         preOrder(node);

     }
}
