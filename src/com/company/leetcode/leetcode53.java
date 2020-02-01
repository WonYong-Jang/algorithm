package com.company.leetcode;

public class leetcode53 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
class Solution {
    public int maxSubArray(int[] nums) {
        
        int len = nums.length;
        
        int[] dp = new int[len];
        dp[0] = nums[0];
        int result = nums[0];
        
        for(int i=1; i< len; i++)
        {
            dp[i] = Math.max(nums[i]+dp[i-1], nums[i]);
            result = Math.max(result, dp[i]);
        }
        
        return result;
    }
} 
 */
