package com.company.leetcode;

public class leetcode153 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
class Solution {
    public int findMin(int[] nums) {
        
        int len = nums.length;
        int left = 0, right = len-1;
        
        while(left < right)
        {
            int mid = left + (right-left >> 1 );
            if(nums[mid] > nums[right]) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return nums[right];
    }
} 
 */
