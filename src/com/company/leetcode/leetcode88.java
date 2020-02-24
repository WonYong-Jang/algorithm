package com.company.leetcode;

public class leetcode88 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/**
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int[] temp = new int[m];
        for(int i=0; i< m; i++) temp[i] = nums1[i];
        
        int i = 0, j = 0, k = 0;
        
        while(i< m && j < n)
        {
            if(temp[i] > nums2[j]) nums1[k++] = nums2[j++];
            else nums1[k++] = temp[i++];
        }
        
        while(i < m) nums1[k++] = temp[i++];
        while(j < n) nums1[k++] = nums2[j++];
    }
} 
 */
