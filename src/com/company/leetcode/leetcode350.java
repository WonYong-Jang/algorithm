package com.company.leetcode;

import java.util.ArrayList;

public class leetcode350 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        ArrayList<Integer> arr = new ArrayList<>();
        
    }
    
}
/**
import java.util.*;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        for(int i=0; i< len1; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i],0) + 1);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i< len2; i++) {
            if(map.containsKey(nums2[i])) {
                int val = map.get(nums2[i]);
                if(val == 0) continue;
                list.add(nums2[i]);
                map.put(nums2[i], --val);
            }
        }
        
        int[] ans = new int[list.size()];
        for(int i=0; i< list.size(); i++) ans[i] = list.get(i);
        return ans;
    }
} 
 */
