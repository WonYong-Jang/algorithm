package com.company.leetcode;

import java.util.HashSet;

public class leetcode202 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        HashSet<Integer> set = new HashSet<>();
        
    }   
}
/**
class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        
        int cnt = 0;
        while(true) {
            
            if(n == 1) return true;
            if(set.contains(n)) break;
            
            set.add(n);
            
            int sum = 0;
            int val = n;
            
            while(val > 0) {
                
                int mod = val % 10;
                sum = sum + (mod*mod);
                val /= 10;
            }
            
            n = sum;
        }
        
        return false;
    }
}
 */
