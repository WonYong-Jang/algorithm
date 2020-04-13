package com.company.leetcode;

public class leetcode701 {
    
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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        
        return search(root, val);
    }
    public TreeNode search(TreeNode root, int val) {
        if(root == null) {
            TreeNode leaf = new TreeNode(val);
            return leaf;
        }
        
        if(root.val < val) {
            root.right = search(root.right, val);
        }
        else {
            root.left = search(root.left, val);  
        } 
        return root;
    }
} 
 */
