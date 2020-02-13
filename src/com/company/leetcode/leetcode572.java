package com.company.leetcode;

public class leetcode572 {
    
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
    public boolean flag;
    public boolean isSubtree(TreeNode s, TreeNode t) {
        
        flag = false;
        move(s, t);
        return flag;
    }
    public void move(TreeNode s, TreeNode t)
    {
        if(s == null || flag) return; 
        
        if(s.val == t.val) {
            TreeNode ts = s;
            TreeNode tt = t;
            if(search(ts, tt)) {
                flag = true;
                return;
            }
        }
        move(s.left, t);
        move(s.right, t);
    }
    public boolean search(TreeNode s, TreeNode t)
    {
        if(s == null && t == null) return true;
        else if(s == null || t == null) return false;
        else if(s.val != t.val) return false;
        
        return search(s.left, t.left) && search(s.right, t.right);
        
    }
} 
 */
