package com.company.leetcode;

public class leetcode35 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
class Solution {
    public int searchInsert(int[] nums, int target) {
        
        int len = nums.length;
        if(len == 0) return 0;
        return lower_bound(0, len, target, nums);
    }
    public int lower_bound(int s, int e, int target, int[] nums) {        
        
        int mid = 0;
        while(s < e)
        {
            mid = s + (e - s) / 2;
            
            if( nums[mid] < target ) {
                s = mid+1;
            }
            else {
                e = mid;
            }
        }
        return e;
    }
} 
 */
