package com.company.leetcode;

public class leetcode912 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
class Solution {
    
    int[] temp;
    public int[] sortArray(int[] nums) {
        
        int len = nums.length;
        temp = new int[len];
        
        solve(nums, 0, len-1, len);
        
        return nums;
    }
    public void solve(int[] nums, int s, int e, int len) {
        
        if(s >= e) return;
        
        int mid = (s+e) / 2;
        solve(nums, s, mid, len);
        solve(nums, mid+1, e, len);
        
        merge(nums, s, e, len);
    }
    public void merge(int[] nums, int s, int e, int len) {
        
        for(int i=s; i <= e; i++) temp[i] = nums[i];
        int mid = (s+e) / 2;
        int i = s, k = s, j = mid + 1;
        
        while(true) {
            
            if(i <= mid && j <= e) {
                if(temp[i] < temp[j]) nums[k++] = temp[i++];
                else nums[k++] = temp[j++];
            }
            else if(i > mid && j <= e) {
                nums[k++] = temp[j++];
            }
            else if(i <= mid && j > e) {
                nums[k++] = temp[i++];
            }
            else break;
        }
        
        
    }
    
} 
 */
