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

public class InorderTraversal {

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
        while(!stack.isEmpty()) { // is not empty
            temp = stack.pop();

            left = temp.left;
            right = temp.right;

            if (right != null) {
                stack.push(right);
                temp.right = null;
            }

            if (left != null) {
                stack.push(temp);
                stack.push(left);
                temp.left = null;
            } else {
                list.add(temp.val);
            }
        }

        return list;
    }

}