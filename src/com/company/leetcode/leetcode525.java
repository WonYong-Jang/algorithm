package com.company.leetcode;

public class leetcode525 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }    
}
/**
class Solution {
    public int findMaxLength(int[] nums) {
        
        return solve(nums);
    }
    public int solve(int[] nums) {
        
        int len = nums.length, answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        int sum = 0;
        for(int i=0; i< len; i++) {
            int num = nums[i];
            
            if(num == 0) sum--;
            else sum++;
            
            if(map.containsKey(sum)) {
                int idx = map.get(sum);
                answer = Math.max(answer, i - idx);
            }
            else map.put(sum, i);
        }
        
        return answer;
    }
}
 */
