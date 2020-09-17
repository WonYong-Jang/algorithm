package com.company.leetcode;

public class leetcode462 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }
}
/**
class Solution {
    public int minMoves2(int[] nums) {
        
        int len = nums.length;
        if(len ==0) return 0;
        
        Arrays.sort(nums);
        int target = nums[len/2];
        int answer = 0;
        
        for(int i=0; i< len; i++) {
            answer += (nums[i] > target ? nums[i] - target : target - nums[i]);   
        }
        
        return answer;
    }
} 
 */
