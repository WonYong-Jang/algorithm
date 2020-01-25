package com.company.leetcode;

public class leetcode268 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
class Solution {
    public int missingNumber(int[] nums) {
        
        int len = nums.length;
        
        int missing = len;
        
        for(int i=0; i< len; i++)
        {
            missing ^= i^nums[i];
        }
        
        return missing;
    }
}
 */
