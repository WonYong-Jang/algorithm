package com.company.leetcode;

public class leetcode1395 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
}
/**
 import java.util.*;

class Solution {
    public int numTeams(int[] rating) {
        
        int len = rating.length;
        
        if(len == 0) return 0;
        else return solve(len, rating);
    }
    public int solve(int len, int[] rating) {
        
        int count = 0;
        int[] leftMax = new int[len];
        int[] leftMin = new int[len];
        
        int minNum = rating[len-1];
        int maxNum = rating[len-1];
        for(int i=0; i< len-1; i++) {
            for(int j= i+1; j< len; j++) {
                if(rating[i] < rating[j]) leftMax[i]++;
                
                if(rating[i] > rating[j]) leftMin[i]++;
            }
        }
        
        
        for(int i=0; i< len-1; i++) {
            for(int j=i+1; j< len; j++) {
                if(rating[i] < rating[j] && leftMax[j] > 0) count+= leftMax[j];
                
                if(rating[i] > rating[j] && leftMin[j] > 0) count+= leftMin[j];
            }
        }
        
        return count;
    }
}
 */
