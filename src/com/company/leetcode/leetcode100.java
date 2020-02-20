package com.company.leetcode;

public class leetcode100 {
    
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        if(p != null && q != null) {
            if(p.val != q.val) return false;
        }
        else if(p == null && q == null) return true;
        else if(p == null || q == null) return false;
        
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
} 
 */
