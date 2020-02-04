package com.company.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode226 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Queue<Integer> que = new LinkedList<>();
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
    public TreeNode invertTree(TreeNode root) {
        
        if(root == null) return null;
        
        TreeNode ans = root;
        
        Queue<TreeNode> que = new LinkedList<>();
        
        que.add(root);
        
        while(!que.isEmpty())
        {
            TreeNode cur = que.poll();
            
            TreeNode temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;
            
            if(cur.left != null) que.add(cur.left);
            if(cur.right != null) que.add(cur.right);
        }
        
        return ans;
    }
}


class Solution {
    public TreeNode invertTree(TreeNode root) {
        
        if(root == null) return null;
        
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        
        root.left = right;
        root.right = left;
        
        return root;
    }
}



**/
