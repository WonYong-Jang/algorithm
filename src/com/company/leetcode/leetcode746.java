package com.company.leetcode;

public class leetcode746 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
       
    }    
}
/**
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        int len = cost.length;
        int[] dp = new int[len+1];
        
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i=2; i<= len; i++)
        {
            if(i == len) dp[i] = min(dp[i-1], dp[i-2]); 
            else dp[i] = min(dp[i-1], dp[i-2]) + cost[i];
        }
        
        return dp[len];
    }
    public int min(int a, int b) { return a > b ? b : a ;}
}
 */
