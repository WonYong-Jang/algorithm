package com.company.leetcode;

public class leetcode94 {
    
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
    public List<Integer> ans;
    public List<Integer> inorderTraversal(TreeNode root) {
        ans = new ArrayList<>();
        
        search(root);
        
        return ans;
    }
    public void search(TreeNode root) {
        
        if(root == null) return;
        
        search(root.left);
        ans.add(root.val);
        search(root.right);
    }
}
 */
