package com.company.leetcode;

public class leetcode437 {
    
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
    public int pathSum(TreeNode root, int sum) {
        
        if(root == null) return 0;
        
        int num = search(root, sum);
        
        return pathSum(root.left, sum) + pathSum(root.right, sum) + num;
    }
    public int search(TreeNode root, int sum)
    {
        if(root == null) return 0;
        
        int num = 0;
        if(root.val == sum) num = 1;
        
        return search(root.left, sum - root.val) + search(root.right, sum - root.val) + num;
    }
}

 */
