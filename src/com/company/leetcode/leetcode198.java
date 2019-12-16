package com.company.leetcode;
/**
 * House Robber
 *
 */
public class leetcode198 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }   
}

/*
class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        
        int[] dp = new int[len+1];
        
        dp[1] = nums[0];
        
        for(int i=2; i<= len; i++)
        {
            dp[i] = max(dp[i-2]+nums[i-1], dp[i-1]);
        }
        
        return dp[len];
    }
    public int max(int a, int b) { return a > b ? a : b ;}
}
*/