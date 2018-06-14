package com.alicode.bitree;
class KthLargest {

    TreeNode root;
    
    int size = 0;
    
    int k = 0;
    
    public KthLargest(int k, int[] nums) {
        this.k = k;
    	
        // init bst
        TreeNode temp = null;
        for (int i = 0; i < nums.length; i++) {
            root = insertIntoBST(root, nums[i]);
            size++;
            
            if (size > k) {
                root = removeSmallestFromBST(root);
                size--;
            }
        }
        
    }
    
    public int add(int val) {
        root = insertIntoBST(root, val);
        size++;
        
        if (size > k) {
            root = removeSmallestFromBST(root);
            size--;
        }
        
        int smallest = findSmallestFromBST(root);
        
        return smallest;
    }
    
    public static TreeNode removeSmallestFromBST(TreeNode root) {
        TreeNode parent = null;
        TreeNode temp = root;
        
        while (temp.left != null) {
            parent = temp;
            temp = temp.left;
        }
        
        if (parent != null) {
            parent.left = temp.right;
        } else {
            root = temp.right;
        }
        
        return root;
    }
    
    public static int findSmallestFromBST(TreeNode root) {
        TreeNode temp = root;
        while (temp.left != null) {
            temp = temp.left;
        }
        
        return temp.val;
    }
    
    public static TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);
        
        if (root == null) {
        	return newNode;
        }
        
        // search leaf node
        TreeNode temp = root;
        while (true) {
        	if (temp.val == val) {
        		newNode.right = temp.right;
        		temp.right = newNode;
        		
        		break;
        	} else if (temp.val > val) {
        		if (temp.left == null) {
        			temp.left = newNode;
        			
        			break;
        		} 
        		
        		temp = temp.left;
        	} else { // temp.val < val
        		if (temp.right == null) {
        			temp.right = newNode;
        			
        			break;
        		}
        		
        		temp = temp.right;
        	}
        }
        
        return root;
    }
    
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // null
        if (root == null) {
            return null;
        }
        if (p == null) {
            return q;
        } 
        if (q == null) {
            return p;
        }
        
        // both not null
        int max, min = 0;
        if (p.val > q.val) {
            max = p.val;
            min = q.val;
        } else {
            max = q.val;
            min = p.val;
        }
        
        TreeNode temp = root;
        while (temp != null) {
            if (temp.val > max) {
                temp = temp.left;
            } else if (temp.val < min) {
                temp = temp.right;
            } else {
                break;
            }
        }
        
        return temp;
    }
    
    public static void main(String[] args) {
    	int k = 3;
    	int[] nums = {4,5,8,2};
    	KthLargest obj = new KthLargest(k, nums);
    	

    	int param_1 = obj.add(3);
    	System.out.println(param_1);
    	
    	param_1 = obj.add(5);
    	System.out.println(param_1);
    	
    	param_1 = obj.add(10);
    	System.out.println(param_1);
    	
    	param_1 = obj.add(9);
    	System.out.println(param_1);
    	
    	param_1 = obj.add(4);
    	System.out.println(param_1);
    }
}