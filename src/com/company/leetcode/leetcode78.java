package com.company.leetcode;

public class leetcode78 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        int len = nums.length;
        if(len == 0) new ArrayList<>();
        
        return solve(nums);
    }
    public List<List<Integer>> solve(int[] nums) {
         
        int N = nums.length;
        
        List<List<Integer>> list = new ArrayList<>();
        
        for(int i=0; i< (1 << N); i++) {
            
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j < N; j++) {
                
                if( (i & ( 1 << j)) > 0 ) {
                    temp.add(nums[j]);
                }
            }
            list.add(temp);
        }
        
        return list;
    }
} 
 */
