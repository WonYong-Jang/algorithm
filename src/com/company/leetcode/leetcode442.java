package com.company.leetcode;

public class leetcode442 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
class Solution {
    public List<Integer> answer;
    public List<Integer> findDuplicates(int[] nums) {
        
        answer = new ArrayList<>();
        int len = nums.length;
        if(len ==0) return answer;
        
        solve(nums, len);
        
        return answer;
    }
    public void solve(int[] nums, int len) {
        
        for(int i=0; i< len; i++) {
            
            int index = (nums[i] -1) % len;
            
            nums[index] += len;
        }
        
        for(int i=0; i< len; i++) {
            
            if(nums[i] > 2*len) answer.add(i+1);
        }
    }
} 
 */
