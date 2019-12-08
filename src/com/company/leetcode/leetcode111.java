package com.company.leetcode;
/**
 * 111. Minimum Depth of Binary Tree
 *
 */
public class leetcode111 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 
class Solution {
    
    public int answer;
    public int minDepth(TreeNode root) {
        
        if(root == null) return 0;
        answer = 987654321;
        
        dfs(root, 1);
        
        
        return answer;
    }
    public void dfs(TreeNode root,int num)
    {
        if(root.left == null && root.right == null)
        {
            answer = min(answer , num);
            return;
        }
        
        
        if(root.left != null)
        {
            dfs(root.left, num+1);
        }
        if(root.right != null)
        {
            dfs(root.right, num+1);
        }
    }
    public int min(int a, int b) { return a > b ? b : a ;}
}

*/