package com.company.leetcode;

public class leetcode455 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}
/*
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int len1 = g.length;
        int len2 = s.length;
        Arrays.sort(g, 0, len1);
        Arrays.sort(s, 0, len2);
        int idx1 =0, idx2 = 0, result =0;
        
        while(idx1 < len1 && idx2 < len2)
        {
            if( g[idx1] <= s[idx2] )
            {
                result++;
                idx1++;
                idx2++;
            }
            else idx2++;
        }
        return result;
    }
}
*/