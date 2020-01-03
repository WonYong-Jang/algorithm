package com.company.leetcode;
/**
 * 3sum closest
 */
public class leetcode16 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }
}

/**
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        Arrays.sort(nums);
        int len = nums.length;
        int answer = 0, flag = 1 << 30;
        
        
        for(int i=0; i< len; i++)
        {
            int value = nums[i];
            int s = i + 1;
            int e = len - 1;
            
            
            while(s < e)
            {
                
                int sum = nums[i] + nums[s] + nums[e];
                int temp = abs(sum, target);
                if(flag > temp) {
                    flag = temp;
                    answer = sum;
                }
                
                if(nums[i] + nums[s] + nums[e] == target) {
                    return target;
                }
                else if(nums[i] + nums[s] + nums[e] < target) s++;
                else e--;
            }
        }
        
        return answer;
    }
    public int abs(int a, int b) { return a > b ? a - b : b - a ;}
    public int min(int a, int b) { return a > b ? b : a ; }
}
 */
