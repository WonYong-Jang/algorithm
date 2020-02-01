package com.company.leetcode;

import java.util.ArrayList;

public class leetcode101 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayList<Integer> arr = new ArrayList<>();
        
        arr.add(null);
        
        
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
 * 
Iterative 
 * 
class Solution {
    
    public boolean isSymmetric(TreeNode root) {
        
        if(root == null) return true;
        
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root.left);
        que.add(root.right);
        
        while(!que.isEmpty())
        {
            TreeNode left = null, right = null;
            left = que.poll();
            if(!que.isEmpty()) right = que.poll();
            
            if(left == null && right == null) continue;
            else if(left == null || right == null) return false;
            else if(left.val != right.val) return false;
            
            que.add(left.left);
            que.add(right.right);
            que.add(left.right);
            que.add(right.left);
        }
        
        return true;
    }
    
}
*/



/*
Recursive !
 * 
class Solution {
    
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return search(root.left, root.right);
    }
    public boolean search(TreeNode left, TreeNode right)
    {
        if(left == null && right == null) return true;
        else if(left == null || right == null) return false;
        else if(left.val != right.val) return false;
        
        return search(left.left, right.right) && search(left.right, right.left);
        
    }
}
 */

