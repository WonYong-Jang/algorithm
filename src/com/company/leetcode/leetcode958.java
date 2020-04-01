package com.company.leetcode;
/**
 * 
 * 958. Check Completeness of a Binary Tree
 *
 */
public class leetcode958 {
    
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
    public boolean isCompleteTree(TreeNode root) {
        
        
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        int chk = 1, cnt = 1;
        boolean flag = false;
        while(!que.isEmpty()) {
            
            TreeNode cur = que.poll();
            
            if(cur.left != null ) {
                que.add(cur.left);
                cnt++;
                if(!flag) chk++;
            }
            else if(cur.left == null ) flag = true;
            
            if(cur.right != null ) {
                que.add(cur.right);
                cnt++;
                if(!flag) chk++;
            }
            else if(cur.right == null ) flag = true;
        }
        
        if(chk == cnt) return true;
        else return false;
    }
    
}
 */
