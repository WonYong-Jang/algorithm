package com.company.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class leetcode113 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<List<Integer>> list = new ArrayList<>();
        
        Stack<Integer> stack = new Stack<>();
        stack.add(2);
        stack.add(3);
        stack.add(4);
        
        List<Integer> test = new ArrayList<>(stack);
        
        System.out.println(test.toString());
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
    public List<List<Integer>> ans;
    public Stack<Integer> stack = new Stack<>();
    public int k;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        ans = new ArrayList<>(); 
        k = sum;
        search(root, 0);
        
        return ans;
    }
    public void search(TreeNode root, int sum)
    {
        if(root == null) return;
        
        stack.add(root.val);
        if(root.left == null && root.right == null)
        {
            if(root.val + sum == k) {
                List<Integer> list = new ArrayList<>(stack);
                ans.add(list);
            }
            return;
        }
        
        search(root.left, sum + root.val);
        if(!stack.isEmpty() && root.left != null) stack.pop();
        search(root.right, sum + root.val);        
        if(!stack.isEmpty() && root.right != null) stack.pop();
    }
}


 
 */
