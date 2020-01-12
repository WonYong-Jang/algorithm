package com.company.leetcode;

public class leetcode189 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
class Solution {
    public void rotate(int[] nums, int k) {
        
        int len = nums.length;
        
        int[] ans = nums.clone();
        
        for(int i=0; i< len; i++)
        {
            nums[(i+k)%len] = ans[i];
        }
        
        
    }
} 
 */
