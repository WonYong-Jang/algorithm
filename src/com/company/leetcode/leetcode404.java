package com.company.leetcode;

public class leetcode404 {
    
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
    public int sumOfLeftLeaves(TreeNode root) {
        
        
        return inorder(root, -1);
    }
    public int inorder(TreeNode root, int flag) {
        if(root == null) return 0;
        
        int num =0;
        if(flag == 0 && root.left == null && root.right == null) num = root.val;
        return inorder(root.left, 0) + inorder(root.right, 1) + num;
        
    }
}
**/
