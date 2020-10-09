package com.company.leetcode;

public class leetcode287 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
}

/**
class Solution {
    public int findDuplicate(int[] nums) {
        
        int len = nums.length;
        
        int s = 1, e = len-1, mid = 0;
        
        while(s < e) {
            
            mid = s + (e - s) / 2;
            int count = 0;
            for(int i=0; i< len; i++) {
                if(nums[i] <= mid) count++;
            }
            
            if(count > mid) e = mid;
            else {
                s = mid + 1;
            }
        }
        return e;
    }
}
 */
