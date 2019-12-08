package com.company.leetcode;
/**
 * 863. All Nodes Distance K in Binary Tree
 */
public class leetcode863 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/*
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }

class Solution {
    
    public ArrayList<Integer>[] adj = new ArrayList[501];
    public List<Integer> answer = new ArrayList<>();
    public int[] visit = new int[501];
    public int cntK;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        
        for(int i=0; i<= 500; i++)
        {
            adj[i] = new ArrayList<>();
        }
        cntK = K;
        dfs(root, root.left);
        dfs(root, root.right);
        
        solve(target.val, 0);
        
        
        return answer;
    }
    public void solve(int cur, int cnt)
    {
        if(cnt == cntK)
        {
            answer.add(cur);
            return;
        }
        
        visit[cur] = 1;
        
        for(int next : adj[cur])
        {
            if(visit[next] == 1) continue;
            solve(next, cnt+1);
        }
    }
    public void dfs(TreeNode cur, TreeNode next)
    {
        if(next == null) return;
        
        adj[cur.val].add(next.val);
        adj[next.val].add(cur.val);
        
        dfs(next, next.left);
        dfs(next, next.right);
    }
}
 */
