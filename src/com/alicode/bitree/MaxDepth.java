package com.alicode.bitree;

public class MaxDepth {
    public int maxDepth(TreeNode root) {
        int maxDepth = 0;

        if (root == null) {
            return maxDepth;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        maxDepth = Math.max(leftDepth, rightDepth) + 1;

        return maxDepth;
    }
}
