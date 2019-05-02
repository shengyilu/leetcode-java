package EasyAlgorithm;

import apple.laf.JRSUIUtils;

import java.util.Arrays;


/*
    Create follow binary tree

                   0
                 /   \
                1     2
              /   \     \
             3     4     5
           /   \       /   \
          6     7     8     9
 * */


public class BinaryTree {

    private int[] data = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    // 1. 先定義出 node 的資料結構
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public BinaryTree() {
        init();
    }

    private TreeNode root;

    private void init() {
        root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.left.left.left = new TreeNode(6);
        root.left.left.right = new TreeNode(7);

        root.right.right = new TreeNode(5);
        root.right.right.left = new TreeNode(8);
        root.right.right.right = new TreeNode(9);
    }

    private void preOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    private void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.val);
        inOrderTraversal(root.right);
    }

    private TreeNode helper(int[] preOrder, int[] inOrder, int preLeftBound, int preRightBound, int inLeftBound, int inRightBound) {
        TreeNode root = null;
        if (preRightBound - preLeftBound >= 0 && preLeftBound <= preOrder.length - 1) {
            root = new TreeNode(preOrder[preLeftBound]);
        } else {
            return null;
        }

        int rootPosInOrder = 0;
        for (int i = inLeftBound; i <= inRightBound; i++) {
            if (inOrder[i] == root.val) {
                rootPosInOrder = i;
            }
        }

        int leftLength = rootPosInOrder - inLeftBound;
        int rightLength = inRightBound - rootPosInOrder;

        root.left = helper(preOrder, inOrder, preLeftBound + 1, preLeftBound + leftLength, inLeftBound, rootPosInOrder - 1);
        root.right = helper(preOrder, inOrder, preLeftBound + leftLength + 1, preLeftBound + leftLength + rightLength, rootPosInOrder + 1, rootPosInOrder + rightLength);

        return root;
    }

    private TreeNode buildTree2(int[] preOrder, int[] inOrder) {
        return helper(preOrder, inOrder, 0, preOrder.length-1, 0, inOrder.length-1);
    }


    private TreeNode buildTree(int[] preOrder, int[] inOrder) {

        TreeNode root = null;
        if (preOrder.length > 0) {
            root = new TreeNode(preOrder[0]);
        } else {
            return null;
        }

        int rootIndex = 0;
        for (int i = 0; i < inOrder.length; i++) {
            if (inOrder[i] == root.val) {
                rootIndex = i;
            }
        }

        int[] leftInOrder = new int[rootIndex];
        for (int i = 0; i < rootIndex; i++) {
            leftInOrder[i] = inOrder[i];
        }

        int[] rightInOrder = new int[inOrder.length - rootIndex - 1];
        for (int i = 0; i < rightInOrder.length; i++) {
            rightInOrder[i] = inOrder[rootIndex + i + 1];
        }

        int[] leftPreOrder = new int[leftInOrder.length];
        int[] rightPreOrder = new int[rightInOrder.length];
        for (int i = 0; i < leftPreOrder.length; i++) {
            leftPreOrder[i] = preOrder[i + 1];
        }

        for (int i = 0; i < rightPreOrder.length; i++) {
            rightPreOrder[i] = preOrder[i + leftPreOrder.length + 1];
        }

        root.left = buildTree(leftPreOrder, leftInOrder);
        root.right = buildTree(rightPreOrder, rightInOrder);
        return root;
    }

    public void solve() {
        BinaryTree bt = new BinaryTree();
        bt.preOrderTraversal(root);
        System.out.println("");
        bt.inOrderTraversal(root);
        System.out.println("");

        int[] preOrder = new int[]{0, 1, 3, 6, 7, 4, 2, 5, 8, 9};
        int[] inOrder = new int[]{6, 3, 7, 1, 4, 0, 2, 8, 5, 9};
        TreeNode reBuildRoot = buildTree(preOrder, inOrder);

        preOrderTraversal(reBuildRoot);
        System.out.println("");
        bt.inOrderTraversal(reBuildRoot);
        System.out.println("");


        TreeNode reBuildRoot2 = helper(preOrder, inOrder, 0, preOrder.length-1, 0, inOrder.length-1);
        preOrderTraversal(reBuildRoot2);
        System.out.println("");
        bt.inOrderTraversal(reBuildRoot2);
        System.out.println("");
    }


}
