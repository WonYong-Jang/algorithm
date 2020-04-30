package com.company.leetcode;

public class leetcode560 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
}
/**
class Solution {
    public int subarraySum(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int ans =0, sum =0;
        for(int num : nums) {
            sum += num;
            ans += map.getOrDefault(sum-k, 0);
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return ans;
    }
} 
 */
