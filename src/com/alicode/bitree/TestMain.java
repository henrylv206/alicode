package com.alicode.bitree;

public class TestMain {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
