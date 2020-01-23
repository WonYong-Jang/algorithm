package com.company.leetcode;

public class leetcode162 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
class Solution {
    public int findPeakElement(int[] nums) {
        
        int len = nums.length;
        if(len <= 1) return 0;
        
        int ans = 0;
        for(int i=0; i< len; i++)
        {
            if(i == 0) 
            {
                if(nums[i] > nums[i+1])
                {
                    ans = i;
                    break;    
                }
            }
            else if(i == len-1)
            {
                if(nums[i-1] < nums[i])
                {
                    ans = i;
                    break;
                }
            }
            else if(nums[i-1] < nums[i] && nums[i] > nums[i+1])
            {
                ans = i;
                break;
            }
        }
        return ans;
    }
} 
 */
