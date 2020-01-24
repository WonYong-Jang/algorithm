package com.company.leetcode;

public class leetcode129 {
    
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
    public int answer;
    public Stack<Integer> stack = new Stack<>();
    public int sumNumbers(TreeNode root) {
        
        answer = 0;
        
        search(root);
        
        return answer;
    }
    public void search(TreeNode root)
    {
        if(root == null) return;
        
        stack.add(root.val);
        if(root.left == null && root.right == null)
        {
            List<Integer> list = new ArrayList<>(stack);
            int len = list.size();
            int mul = 1;
            for(int i=len-1; i >= 0; i--)
            {
                int num = list.get(i);
                answer += num*mul;
                mul *= 10;
            }
            
            return;
        }
        
        search(root.left);
        if(!stack.isEmpty() && root.left != null) stack.pop();
        search(root.right);
        if(!stack.isEmpty() && root.right != null) stack.pop();
    }
}










**/
