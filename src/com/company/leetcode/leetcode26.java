package com.company.leetcode;

public class leetcode26 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
class Solution {
    public int removeDuplicates(int[] nums) {
        
        HashSet<Integer> set = new HashSet<>();
        int len = nums.length;
        
        for(int i=0; i< len; i++)
        {
            set.add(nums[i]);
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        int index =0;
        for(int num : list)
        {
            nums[index++] = num;
        }
        
        return set.size();
    }
} 
 */
