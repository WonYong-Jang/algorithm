package com.company.leetcode;

public class leetcode213 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
class Solution {
    public int rob(int[] nums) {
        
        int len = nums.length;
        
        if(len == 0) return 0;
        else if(len == 1) return nums[0];
        else if(len == 2) return Math.max(nums[0], nums[1]);
        
        int t1 = search(0, len-2, nums);
        int t2 = search(1, len-1, nums);
        
        return Math.max(t1, t2);
    }
    public int search(int s, int e, int[] nums)
    {
        int[] dp = new int[e+1];
        
        dp[s] = nums[s];
        int ans = 0;
        for(int i = s + 1; i <= e; i++)
        {
            if(i-2 < 0 ) dp[i] = Math.max(nums[i], dp[i-1]);
            else dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }
} 
 */
