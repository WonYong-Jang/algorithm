package com.company.leetcode;

public class leetcode18 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        int len = nums.length;
        Set<List<Integer>> list = new HashSet<>();
        if(len ==0) return new ArrayList<>(list);
        
        Arrays.sort(nums);
        
        for(int i=0; i< len-1; i++) {
            
            for(int j = i+1; j< len; j++) {
                    
                int sum = nums[i] + nums[j];
                
                int start = j+1;
                int end = len-1;
                int val = target - sum;
                while(start < end ) {
                    
                    int twoSum = nums[start] + nums[end];
                    if(twoSum == val) {
                        
                        List<Integer> temp = 
                        Arrays.asList(nums[i], nums[j], nums[start], nums[end]);
                        list.add(temp);
                        
                        
                        start++;
                    }
                    if(twoSum < val) {
                        start++;
                    }
                    else end--;
                }
                
            }
        }
        
        return new ArrayList<>(list);
    }
    
} 
 */
