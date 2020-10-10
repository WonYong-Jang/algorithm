package com.company.leetcode;

public class leetcode144 {
    
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
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 
class Solution {
    public List<Integer> answer;
    public List<Integer> preorderTraversal(TreeNode root) {
        
        answer = new ArrayList<>();
        search(root);
        
        return answer;
    }
    public void search(TreeNode root) {
        
        if(root == null) return;
        
        answer.add(root.val);
        search(root.left);
        search(root.right);
    }
}
 
 */
