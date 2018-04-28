package com.alicode.bitree;

import java.util.*;

// Definition for a binary tree node.
//class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode(int x) { val = x; }
//}

public class LevelorderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> values = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();

        if (root == null) {
            return values;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        TreeNode last = root;
        TreeNode nlast = null;

        TreeNode temp = null;
        while (!queue.isEmpty()) {
            temp = queue.poll();

            list.add(temp.val);

            if (temp.left != null) {
                queue.add(temp.left);

                nlast = temp.left;
            }
            if (temp.right != null) {
                queue.add(temp.right);

                nlast = temp.right;
            }

            if (temp == last) {
                values.add(list);
                list = new ArrayList<Integer>();

                last = nlast;
                //nlast = null;
            }
        }

        return values;
    }

}