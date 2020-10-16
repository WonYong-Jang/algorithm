package com.company.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class leetcode285 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>() {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return true;
            }
        };
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
 
class Solution {
    public boolean flag;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        
       if(root == null) return null;
        flag = false;
        
        return inorder(root, p);
    }
    public TreeNode inorder(TreeNode root, TreeNode p) {
        
        if(root == null) return null;
        
        TreeNode left = inorder(root.left, p);
        if(root.val == p.val) {
            flag = true;
        }
        else if(flag) {
            flag = false;
            
            return root;
        }
        TreeNode right = inorder(root.right, p);
        
        if(left != null) return left;
        else return right;
    }
}
 */
