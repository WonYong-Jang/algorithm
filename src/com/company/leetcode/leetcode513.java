package com.company.leetcode;

public class leetcode513 {
    
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
    public int findBottomLeftValue(TreeNode root) {
        
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        int ans = 0;
        while(!que.isEmpty()) {
            
            int size = que.size();
            
            for(int i=0; i< size; i++) {
                TreeNode cur = que.poll();
                
                if(i == 0) ans = cur.val;
                
                if(cur.left != null) que.add(cur.left);
                if(cur.right != null) que.add(cur.right);
                
            }
        }
        
        return ans;
    }
} 
 */
