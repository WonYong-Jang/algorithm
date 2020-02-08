package com.company.leetcode;

public class leetcode543 {
    
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
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
class Solution {
    public int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        
        ans = 0;
        search(root);
        
        return ans;
    }
    public int search(TreeNode root)
    {
        if(root == null) return 0;
                
        int left = search(root.left);
        int right = search(root.right);
        
        ans = Math.max(ans, left+right);
        
        return Math.max(left, right) + 1;
        
    }
}
 
 */
