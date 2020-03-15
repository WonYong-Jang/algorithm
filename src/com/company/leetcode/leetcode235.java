package com.company.leetcode;

public class leetcode235 {
    
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
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        
        if(p.val < q.val) return search(root, p, q);
        else return search(root, q, p);
        
    }
    public TreeNode search(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        
        if(p.val <= root.val && root.val <= q.val) return root;
        else if(p.val < root.val && q.val < root.val) return search(root.left, p, q);
        else return search(root.right, p, q);
    }
} 
 */
