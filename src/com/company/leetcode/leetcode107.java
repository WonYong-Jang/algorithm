package com.company.leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode107 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<List<Integer>> arr = new ArrayList<>();
        
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
    List<List<Integer>> list;
    int level;
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        list = new ArrayList<>();
        level = getMaxLevel(root);
        for(int i=0; i< level; i++) {
            list.add(new ArrayList<>());
        }
        postOrder(root, 0);
        return list;
    }
    public void postOrder(TreeNode root, int depth) {
        if(root == null) return;
        postOrder(root.left, depth+1);
        postOrder(root.right, depth+1);
        list.get(level - depth - 1).add(root.val);
    }
    public int getMaxLevel(TreeNode root) {
        if(root == null) return 0;
        
        return Math.max(getMaxLevel(root.left), getMaxLevel(root.right)) + 1;
    }
} 
 */
