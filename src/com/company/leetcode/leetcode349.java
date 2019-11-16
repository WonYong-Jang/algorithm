package com.company.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class leetcode349 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }
    
}
/*
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        HashSet<Integer> list = new HashSet<>();
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=0; i< len1; i++) set.add(nums1[i]);
        
        for(int i=0; i< len2; i++)
        {
            
            if(set.contains(nums2[i]))
            {
                list.add(nums2[i]);
            }
        }
        
        int[] result = new int[list.size()];
        int index = 0;
        for(int num : list)
        {
            result[index] = num;
            index++;
        }
        return result;
    }
}
*/