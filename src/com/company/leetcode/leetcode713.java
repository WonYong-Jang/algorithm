package com.company.leetcode;

public class leetcode713 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
}
/**
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        
        return solve(nums, k);
    }
    public int solve(int[] nums, int k) {
        
        int answer = 0, len = nums.length;
        
        int mul = 1, s = 0;
        for(int i=0; i< len; i++) {
            mul *= nums[i];
            
            while(mul >= k && s <= i) {
                mul /= nums[s++];
            }
            answer += (i - s + 1);
        }
        
        return answer;
    }
}
 */
