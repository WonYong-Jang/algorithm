package com.company.leetcode;
/**
 * 538. Convert BST to Greater Tree
 */
public class leetcode538 {
    
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
    public int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        
        if(root == null) return null;
        
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        
        return root;
    }
}
 */
