package com.company.leetcode;

public class leetcode928 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
class Solution {
    static ArrayList<Integer>[] adj;
    static int[] parent;
    static HashSet<Integer> set;
    public int minMalwareSpread(int[][] graph, int[] initial) {
        
        int len = graph.length;
        adj = new ArrayList[len];
        parent = new int[len];
        set = new HashSet<>();
        for(int i=0; i< len; i++)
        {
            adj[i] = new ArrayList<>();
            parent[i] = i;
        }
        for(int i = 0; i < len; i++)
        {
            for(int j = 0; j < len; j++)
            {
                if(i == j) continue;
                if(graph[i][j] == 1)
                {
                    adj[i].add(j);
                }
            }
        }
        Arrays.sort(initial);
        int M = initial.length;
        for(int i=0; i< M; i++) set.add(initial[i]);
        
        for(int i=0; i< len; i++)
        {
            for(int next : adj[i])
            {
                int ap = find(i);
                int bp = find(next);
                if(ap != bp) 
                {
                    union(ap, bp);
                }
            }
        }
        
        int result = 0, cnt = 0, ret = 0, ans = 0;
        for(int i=0; i< len; i++)
        {
            if(!set.contains(parent[i]))
            {
                cnt++;
            }
        }
        result = cnt;
        ret = cnt;
        for(int k=0; k< M; k++)
        {
            for(int i=0; i< len; i++) parent[i] = i;
            int target = initial[k];
            for(int i=0; i< len; i++)
            {
                if(target == i) continue;
                for(int next : adj[i])
                {
                    if(target == next) continue;
                    int ap = find(i);
                    int bp = find(next);
                    if(ap != bp) 
                    {
                        union(ap, bp);
                    }
                }
            }
            
            cnt = 0;
            for(int i=0; i< len; i++)
            {
                if(!set.contains(parent[i]))
                {
                    cnt++;
                }
            }
            
            if(result < cnt) {
                result = cnt;
                ans = target;   
            }
        }
        
        if(result == ret) return initial[0];
        else return ans;
    }
    public static void union(int a, int b)
    {
        int ap = find(a);
        int bp = find(b);
        
        if(set.contains(ap)) {
            parent[bp] = ap;    
        }
        else if(set.contains(bp)) {
            parent[ap] = bp;    
        }
        else parent[ap] = bp;
        
    }
    public static int find(int a)
    {
        if(parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }
}
 */
