package com.company.leetcode;

import java.util.Comparator;

public class leetcode169 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Comparator<Integer> mySort = new Comparator<Integer>() {
            

            @Override
            public int compare(Integer o1, Integer o2) {
                // TODO Auto-generated method stub
                return 0;
            }  
        };
    }
    
}
/**
class Solution {
    public int majorityElement(int[] nums) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=0; i< nums.length; i++)
        {
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        
        List<Integer> list = new ArrayList<>(map.keySet());
        
        Comparator<Integer> mySort = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(b) - map.get(a);
            }  
        };
        
        Collections.sort(list, mySort);
        
        return list.get(0);
    }
}
 */
