package com.alicode.bitree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Definition for a binary tree node.
//class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode(int x) { val = x; }
//}

public class PostorderTraversal {
    public List<Integer> iteration(TreeNode root) {
        // 迭代
        List<Integer> list = new ArrayList<Integer>();

        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        TreeNode left = null;
        TreeNode right = null;
        TreeNode temp = null;
        while (!stack.isEmpty()) {
            temp = stack.pop();

            left = temp.left;
            right = temp.right;

            if (left == null && right == null) {
                list.add(temp.val);
            } else {
                stack.push(temp);

                if (right != null) {
                    stack.push(right);
                    temp.right = null;
                }

                if (left != null) {
                    stack.push(left);
                    temp.left = null;
                }
            }

        }

        return list;
    }

}