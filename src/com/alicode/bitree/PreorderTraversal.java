package com.alicode.bitree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Definition for a binary tree node.
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

public class PreorderTraversal {
    public List<Integer> recursion(TreeNode root) {
        // 递归
        if (root == null) {
            return new ArrayList<Integer>();
        }

        List<Integer> list = new ArrayList<Integer>();
        list.add(root.val);
        list.addAll(recursion(root.left));
        list.addAll(recursion(root.right));

        return list;
    }

    public List<Integer> iteration(TreeNode root) {
        // 迭代
        List<Integer> list = new ArrayList<Integer>();

        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        TreeNode temp = null;
        while(!stack.isEmpty()) { // is not empty
            temp = stack.pop();
            list.add(temp.val);
            if (temp.right != null) {
                stack.push(temp.right);
            }

            if (temp.left != null) {
                stack.push(temp.left);
            }
        }

        return list;
    }

}