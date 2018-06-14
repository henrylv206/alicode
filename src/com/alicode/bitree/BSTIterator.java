package com.alicode.bitree;

import java.util.Stack;

public class BSTIterator {

	TreeNode root = null;
    Stack<TreeNode> stack = null;
    
    public BSTIterator(TreeNode root) {
        this.root = root;
        
        stack = new Stack<TreeNode>();
    	if (root != null) {
            stack.push(root);
            
            TreeNode temp = root;
            while (temp != null && temp.left != null) {
                stack.push(temp.left);
                temp = temp.left;
            }
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (!stack.isEmpty()) {
        	return true;
        }
    	
    	return false;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode temp = stack.pop();
        
        int ret = temp.val;
        
        if (temp.right != null) {
        	stack.push(temp.right);
        	temp = temp.right;
            
            while (temp != null && temp.left != null) {
                stack.push(temp.left);
                temp = temp.left;
            }
        }
        
    	return ret;
    }
    
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode retNode = root;
    	
        while (retNode != null) {
        	if (retNode.val < val) {
        		retNode = retNode.right;
        	} else if (retNode.val > val) {
        		retNode = retNode.left;
        	} else {
        		break;
        	}
        }
        
    	return retNode;
    }
    

    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);
        
        if (root == null) {
        	return newNode;
        }
        
        // search leaf node
        TreeNode temp = root;
        while (true) {
        	if (temp.val == val) {
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
    
    public TreeNode deleteNode(TreeNode root, int key) {
    	// root is null
        if (root == null) {
        	return null;
        }
        	 
        // root is not null
        // search target node
    	TreeNode parentNode = null;
    	String type = null;
    	
    	TreeNode tempNode = root;
    	while (tempNode != null) {
    		if (tempNode.val == key) {
    			tempNode = replaceRootNode(tempNode);
    			
    			if (parentNode != null) {
    				if (type.equals("left")) {
    					parentNode.left = tempNode;
    				} else if (type.equals("right")) {
    					parentNode.right = tempNode;
    				}
    			}
    			
    			break;
    		} else if (tempNode.val > key) {
//    			if (tempNode.left != null) {
    				parentNode = tempNode;
    				type = "left";
    				tempNode = tempNode.left;
//    			} else {
//    				break;
//    			}
    		} else if (tempNode.val < key) {
//    			if (tempNode.right != null) {
    				parentNode = tempNode;
    				type = "right";
    				tempNode = tempNode.right;
//    			} else {
//    				break;
//    			}
    		}
    	}
        	
        // root node
    	if (parentNode == null) {
    		return tempNode;
    	} else {
    		return root;
    	}
    }
    
    private TreeNode replaceRootNode(TreeNode root) {
    	TreeNode newRoot = null;
    	if (root.right != null) {
    		newRoot = smallestRightNode(root.right);
            newRoot.left = root.left;
    	} else if (root.left != null) {
    		newRoot = biggestLeftNode(root.left);
            newRoot.right = root.right;
    		
    	}
    	
    	return newRoot;
    }
    
    private TreeNode biggestLeftNode(TreeNode root) {
    	TreeNode parent = null;
    	
        TreeNode temp = root;
        
    	if (temp.right != null) {
    		while (temp.right != null) {
    			parent = temp;
    			temp = temp.right;
    		}
    		
    		if (parent != null) {
    			parent.right = null;
    		}
            
            TreeNode leftNode = temp;
            while (leftNode.left != null) {
                leftNode = leftNode.left;
            }
            
            leftNode.left = root;
    	}

    	return temp;
    }
    
    private TreeNode smallestRightNode(TreeNode root) {
    	TreeNode parent = null;
    
        TreeNode temp = root;
        
    	if (temp.left != null) {
    		while (temp.left != null) {
        		parent = temp;
        		temp = temp.left;
        	}
        	
        	if (parent != null) {
        		parent.left = null;
        	}
            
            TreeNode rightNode = temp;
            while (rightNode.right != null) {
                rightNode = rightNode.right;
            }
            
            rightNode.right = root;
            
    	}
    	
    	return temp;
    }
    
    
    


    
	public static void main(String[] args) {
//		
//		
//		
//		TreeNode root = null;
//		
//		BSTIterator i = new BSTIterator(root);
//		
//		while (i.hasNext())
//			i.v.add(i.next());
	}

	
}
