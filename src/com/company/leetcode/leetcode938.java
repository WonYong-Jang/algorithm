package com.company.leetcode;

public class leetcode938 {
    
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
    int sum =0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        
        search(root, L, R);
        return sum;
    }
    public void search(TreeNode root, int L, int R) {
        if(root == null) return;
        
        search(root.left, L, R);
        int num = root.val;
        if(num >= L && num <= R) sum += num;
        search(root.right, L, R);
    }
} 
 */
