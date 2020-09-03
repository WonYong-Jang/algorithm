package com.company.leetcode;

public class leetcode257 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        
        char ch = (char)(1+'a');
        
        System.out.println(ch);
        System.out.println("a");
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
    public final String next = "->";
    List<String> answer;
    public List<String> binaryTreePaths(TreeNode root) {
        answer = new ArrayList<>();
        
        StringBuilder sb = new StringBuilder();
        
        search(root, sb);
        
        return answer;
    }
    public void search(TreeNode root, StringBuilder sb) {
        
        if(root == null) return;
        
        if(sb.length() > 0 ) {
            sb.append(next);
            sb.append(root.val);
        }
        else sb.append(root.val);
        
        if(root.left == null && root.right == null) {
            answer.add(sb.toString());
            return;
        }
        StringBuilder leftSb = new StringBuilder(sb.toString());
        StringBuilder rightSb = new StringBuilder(sb.toString());
        
        search(root.left, leftSb);
        search(root.right, rightSb);
        
    }
}
 */
