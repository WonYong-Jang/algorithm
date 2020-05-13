package com.company.leetcode;

public class leetcode114 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
}
/**
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/**
class Solution {
    
    public void flatten(TreeNode root) {
        
        Stack<TreeNode> stack = new Stack<>();
        if(root != null) stack.add(root);
        
        while(!stack.isEmpty()) {
            
            TreeNode cur = stack.pop();
            
            if(cur.right != null) stack.add(cur.right);
            if(cur.left != null) stack.add(cur.left);
            
            if(!stack.isEmpty()) {
                cur.right = stack.peek();
            }
            cur.left = null;
            
        }
    }
    
}

 
 */
