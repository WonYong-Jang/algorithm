package com.company.leetcode;

public class leetcode338 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
class Solution {
    public int[] countBits(int num) {
        
        int[] dp = new int[num+1];
        for(int i=1; i<= num; i++)
        {
            dp[i] = dp[i - (i & -i)] + 1;
        }
        
        return dp;
    }
}
 */
