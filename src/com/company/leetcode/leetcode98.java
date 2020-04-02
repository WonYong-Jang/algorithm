package com.company.leetcode;

public class leetcode98 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }
}
/**
 * 
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
    public ArrayList<Integer> list;
    public boolean isValidBST(TreeNode root) {
        
        list = new ArrayList<>();
        
        return search(root);
    }
    public boolean search(TreeNode root) {
        if(root == null) return true;
        
        boolean left = search(root.left);
        if(list.size() > 0 && list.get(list.size()-1) >= root.val) return false;
        
        list.add(root.val);
        boolean right = search(root.right);
        return (left & right);
    }
}
**/
