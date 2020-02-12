package com.company.leetcode;

public class leetcode108 {
    
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
    public TreeNode sortedArrayToBST(int[] nums) {
        
        int len = nums.length;
        if(len == 0) return null;
        
        return solve(nums, 0, len-1);
    }
    public TreeNode solve(int[] nums, int s, int e)
    {
        if(s > e) return null;
        
        int mid = s + (e - s) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = solve(nums, s, mid-1);
        node.right = solve(nums, mid+1, e);
        
        return node;
    }
} 
 */
