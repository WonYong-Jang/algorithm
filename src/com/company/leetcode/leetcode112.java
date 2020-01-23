package com.company.leetcode;

public class leetcode112 {
    
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
/*
class Solution {
    public boolean flag;
    public int k;
    public boolean hasPathSum(TreeNode root, int sum) {
        
        k = sum;
        flag = false;
        if(root == null) return false;
        
        search(root, 0);
        
        return flag;
    }
    public void search(TreeNode root, int sum)
    {
        if(root == null || flag) return;
        
        if(root.left == null && root.right == null)
        {
            if(sum + root.val == k) flag = true;
            return;
        }
        
        search(root.left, root.val + sum);
        search(root.right, root.val + sum);
    }
} 
 */
