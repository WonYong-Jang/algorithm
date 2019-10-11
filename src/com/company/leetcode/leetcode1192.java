package com.company.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 단절선 
 * @author jang-won-yong
 *
 */
public class leetcode1192 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}

class Solution {
    int number = -1;
    ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
    int[] order;
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        order = new int[n];
        
        for(int i=0; i< n; i++)
        {
            adj.add(new ArrayList<>());
            order[i] = -1;
        }
        
        for(List<Integer> cur : connections)
        {
            adj.get(cur.get(0)).add(cur.get(1));
            adj.get(cur.get(1)).add(cur.get(0));
        }
        
        for(int i=0; i< n; i++)
        {
            if(order[i] != -1) continue;
            dfs(i, -1);
        }
        
        return ans;
    }
    public int dfs(int cur, int p)
    {
        order[cur] = ++number;
        int ret = order[cur];
        
        for(int next : adj.get(cur))
        {
            if(next == p) continue;
            if(order[next] != -1)
            {
                ret = min(ret, order[next]);
                continue;
            }
            
            int prev = dfs(next, cur);
            
            if(order[cur] < prev)
            {
                ans.add(Arrays.asList(cur, next));
            }
            ret = min(ret, prev);
        }
        
        return ret;
    }
    public int min(int a, int b) { return a > b ? b : a ;}
}
