package com.company.leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode102 {
    
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
 */
/**
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
     
        Queue<TreeNode> que = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        
        que.offer(root);
        
        while(!que.isEmpty()) {
            
            int size = que.size();
            ArrayList<Integer> arr = new ArrayList<>();
            
            for(int i=0; i < size; i++) {
                
                TreeNode cur = que.poll();
                arr.add(cur.val);
                
                if(cur.left != null) que.offer(cur.left);
                if(cur.right != null) que.offer(cur.right);
            }
            ans.add(arr);
        }
        
        
        return ans;
    }
}
**/
