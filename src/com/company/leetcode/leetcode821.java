package com.company.leetcode;

public class leetcode821 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }    
}
/**
class Solution {
    public int[] shortestToChar(String S, char C) {
        
        int len = S.length();
        int[] ans = new int[len];
        
        int prev = Integer.MIN_VALUE / 2;
        
        for(int i=0; i< len; i++)
        {
            if(S.charAt(i) == C) prev = i;
            ans[i] = i - prev;
        }
        
        prev = Integer.MAX_VALUE/ 2;
        for(int i = len-1; i >= 0; i--)
        {
            if(S.charAt(i) == C) prev = i;
            ans[i] = min(ans[i], prev - i);
        }
        
        return ans;
    }
    public int min(int a, int b) { return a > b ? b : a;}
} 
 */
