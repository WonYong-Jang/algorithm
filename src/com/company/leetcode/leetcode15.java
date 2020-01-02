package com.company.leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 3Sum
 */
public class leetcode15 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        
    }
    
}


/**
class Solution {
    
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> answer = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
        
        int s = 0, e = 0;
        for(int i=0; i< len-2; i++)
        {
            s = i + 1;
            e = len - 1;
            if(i > 0 && nums[i] == nums[i-1]){
                
                continue;
            }
            while(s < e)
            {
               
                if(e < len - 1 && nums[e] == nums[e+1])
                {
                    e--;
                    continue;
                }
                
                if(nums[i] + nums[s] + nums[e] == 0) 
                {
                    answer.add(new ArrayList<>(Arrays.asList(nums[i], nums[s], nums[e])));
                    s++;
                    e--;
                }
                else if(nums[i] + nums[s] + nums[e] > 0) {
                    e--;
                }
                else {
                    s++;
                }
            }
        }
       
        
        return answer;
    }
    
}

 */
