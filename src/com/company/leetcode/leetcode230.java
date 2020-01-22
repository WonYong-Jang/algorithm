package com.company.leetcode;

public class leetcode230 {
    
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
    public ArrayList<Integer> arr = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        
        if(root == null) return -1;
        
        search(root, k);
        
        return arr.get(k-1);
    }
    public void search(TreeNode root, int k) 
    {
        if(root == null || arr.size() >= k) return;
        
        search(root.left, k);
        arr.add(root.val);
        search(root.right, k);
    }
}
**/
