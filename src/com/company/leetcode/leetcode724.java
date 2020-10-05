package com.company.leetcode;

public class leetcode724 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
class Solution {
    public int pivotIndex(int[] nums) {
        
        int len = nums.length;
        if(len == 0) return -1;
        
        int[] rightSum = new int[len];
        
        for(int i = len-1; i >= 0; i--) {
            if(i == len - 1) rightSum[i] = nums[i];
            else rightSum[i] = nums[i] + rightSum[i+1];
        }
        
        int leftSum = 0;
        for(int i = 0 ; i< len; i++) {
            if(i == len - 1) {
                if(leftSum == 0) return i;
            }
            else {
                if(leftSum == rightSum[i+1]) return i;    
            }
            
            leftSum += nums[i];
        }
        
        return -1;
    }
}
 
 */
