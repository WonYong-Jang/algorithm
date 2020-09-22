package com.company.leetcode;

public class leetcode260 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
class Solution {
    public int[] singleNumber(int[] nums) {
        
        int len = nums.length;
        if(len == 0) return new int[0];
        
        int xor = 0;
        for(int num : nums) xor ^= num;
        
        int digit = 0;

        while(true) {
            
            if((xor & 1) > 0) {
                break;
            }
            digit++;
            xor >>= 1;
        }
        
        int target1 = 0, target2 = 0;
        for(int num : nums) {
            
            if( ((num >> digit) & 1) == 1) {
                target1 ^= num;
            }
            else {
                target2 ^= num;
            }
        }
        
        return new int[]{target1, target2};
    }
}

 
 */
