package com.company.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode47 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayList<Integer> arr = new ArrayList<>();
        
        
    }
    
}

/**
import java.util.*;

class Solution {
    public List<List<Integer>> ans = new ArrayList<>();
    public int[] data;
    public int[] dp;
    public int[] visit;
    public int len;
    public HashSet<Integer> set = new HashSet<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        data = nums.clone();
        len = nums.length;
        visit = new int[len];
        dp = new int[len];
        
        search(0,0);
        
        return ans;
    }
    public void search(int index, int size)
    {
        if(size >= len) {
            
            int value = 0, mul = 1;
            
            for(int i=len-1; i >= 0; i--)
            {
                value += (dp[i]*mul);
                mul *= 10;
            }
            
            if(!set.contains(value)) {
                set.add(value);
                List<Integer> list = new ArrayList<>();
                
                for(int i=0; i< len; i++)
                {
                    list.add(dp[i]);
                }
                
                ans.add(list);
            }
            return;
        }
        
        for(int i = 0; i < len; i++)
        {
            if(visit[i] == 1) continue;
            visit[i] = 1;
            dp[size] = data[i];
            search(i, size+1);
            visit[i] = 0;
        }
    }
}
 */
