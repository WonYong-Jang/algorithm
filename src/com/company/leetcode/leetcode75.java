package com.company.leetcode;
/**
 * counting sort
 */
public class leetcode75 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}

class Solution75 {
    public void sortColors(int[] nums) {
        int len = nums.length;
        
        int[] arr = new int[3];
        
        for(int i=0; i< len; i++)
        {
            arr[nums[i]]++;
        }
        
        for(int i=0; i< len; i++)
        {
            if(arr[0] > 0) {
                nums[i] = 0;
                arr[0]--;
            }
            else if(arr[1] > 0) {
                nums[i] = 1;
                arr[1]--;
            }
            else {
                nums[i] = 2;
                arr[2]--;
            }
        }
        
    }
}