package com.alicode.bitree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BiTree {

    // 迭代
    public boolean isSymmetric_iterator(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> lQueue = new LinkedList<TreeNode>();
        Queue<TreeNode> rQueue = new LinkedList<TreeNode>();
        lQueue.add(root);
        rQueue.add(root);

        TreeNode left = null;
        TreeNode right = null;
        while (!lQueue.isEmpty()) {
            left = lQueue.poll();
            right = rQueue.poll();

            if (left.val == right.val) {
                if (left.left != null && right.right != null) {
                    lQueue.add(left.left);
                    rQueue.add(right.right);
                } else if (left.left == null &&  right.right == null) {
                    // noop
                } else {
                    return false;
                }

                if (left.right != null && right.left != null) {
                    lQueue.add(left.right);
                    rQueue.add(right.left);
                } else if (left.right == null && right.left == null) {
                    // noop
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }

    /**
     * 对称二叉树
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        // 递归
        if (root == null) {
            return true;
        }

        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left != null && right != null && left.val == right.val) {
            boolean bLeft = isSymmetric(left.left, right.right);
            boolean bRight = isSymmetric(left.right, right.left);

            return bLeft && bRight;
        }

        return false;
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;

        if (len == 0) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[len - 1]);

        int index = 0;
        for (int i = 0; i < len; i++) {
            if (inorder[i] == postorder[len - 1]) {
                index = i;
                break;
            }
        }

        int[] leftInorder = Arrays.copyOfRange(inorder, 0, index);
        int[] leftPostorder = Arrays.copyOfRange(postorder, 0, index);
        TreeNode left = buildTree(leftInorder, leftPostorder);
        root.left = left;

        int[] rightInorder = Arrays.copyOfRange(inorder, index + 1, len);
        int[] rightPostorder = Arrays.copyOfRange(postorder, index, len - 1);
        TreeNode right = buildTree(rightInorder, rightPostorder);
        root.right = right;

        return root;
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        int len = preorder.length;

        if (len == 0) {
            return null;
        }

        // 根节点
        TreeNode root = new TreeNode(preorder[0]);

        // 根节点在中序遍历的索引位置
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (inorder[i] == preorder[0]) {
                index = i;
            }
        }

        // 左子树
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, index + 1);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, index);
        TreeNode left = buildTree2(leftPreorder, leftInorder);
        root.left = left;

        // 右子树
        int[] rightPreorder = Arrays.copyOfRange(preorder, index + 1, len);
        int[] rightInorder = Arrays.copyOfRange(inorder, index + 1, len);
        TreeNode right = buildTree2(rightPreorder, rightInorder);
        root.right = right;

        return root;
    }

    public static TreeNode buildTree3(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length -1, inorder, 0, inorder.length - 1);
    }

    // 不使用中间数组，基于原数组及下标来控制前序、中序遍历数据
    public static TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        int len = preEnd - preStart + 1;

        if (len == 0) {
            return null;
        }

        // 根节点
        TreeNode root = new TreeNode(preorder[preStart]);

        // 根节点在中序遍历中的索引位置
        int index = 0;
        for (int i = inStart; i < inEnd + 1; i++) {
            if (inorder[i] == preorder[preStart]) {
                index = i;
            }
        }

        // 左子树
        TreeNode left = buildTree(preorder, preStart + 1, preStart + 1 + (index - 1 - inStart), inorder, inStart, index - 1);
        root.left = left;

        // 右子树
        TreeNode right = buildTree(preorder, preEnd - (inEnd - index - 1), preEnd, inorder, index + 1, inEnd);
        root.right = right;

        return root;
    }
//
//    public static int[] mergeSort(int[] inputs) {
//
//
//    }

    public static void main(String[] args) {
//        int[] inorder = {9,3,15,20,7};
//        int[] preorder = {3,9,20,15,7};
//
//        buildTree3(inorder, preorder);

        String lists = "[1,2,3,null,null,4,5]";

        List<String> list = Arrays.asList(lists);

        System.out.print(list.size());
        
    }
}
