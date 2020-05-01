package com.company.leetcode;

import java.util.HashMap;

public class leetcode496 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        HashMap<Integer, Integer> map = new HashMap<>();
    }
}
/**
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] ans = new int[len1];
        Arrays.fill(ans, -1);
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i< len1; i++) {
            map.put(nums1[i], i);
        }
        
        for(int i=0; i< len2; i++) {
            
            if(stack.isEmpty()) stack.add(i);
            else {
                
                while(!stack.isEmpty()) {
                    
                    int cur = stack.peek();
                    if(nums2[cur] > nums2[i]) break;
                    else {
                        if(map.containsKey(nums2[cur])) {
                            ans[map.get(nums2[cur])] = nums2[i];
                        }
                        stack.pop();
                    }
                }
                stack.add(i);
            }
        }
        
        
        return ans;
    }
}
**/
