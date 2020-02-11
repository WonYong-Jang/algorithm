package com.company.leetcode;

public class leetcode110 {
    
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
    public boolean isBalanced(TreeNode root) {
        
        flag = true;
        search(root);
        
        return flag;
    }
    public int search(TreeNode root) {
        if(root == null || !flag) return 0;
        
        int left = search(root.left);
        int right = search(root.right);
        int value = left > right ? left - right : right - left;
        
        if(value > 1) {
            flag = false;
            return 0;
        }
        
        return Math.max(left, right) + 1;
    }
} 
 */
