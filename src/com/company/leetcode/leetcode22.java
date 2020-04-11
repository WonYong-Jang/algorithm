package com.company.leetcode;

import java.util.ArrayList;

public class leetcode22 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }
}
/**
class Solution {
    public List<String> ans;
    public int N;
    public char[] perm;
    public List<String> generateParenthesis(int n) {
        
        ans = new ArrayList<String>();
        N = n*2;
        perm = new char[N];
        
        search(0, 0, 0);
        return ans;
    }
    public void search(int left, int right, int len) {
        
        if(left < right || N/2 < left || N/2 < right ) return;
        if(len >= N) {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< N; i++) {
                sb.append(perm[i]);
            }
            ans.add(sb.toString());
            return;
        }
        perm[len] = '(';
        search(left+1, right, len+1);
        perm[len] = ')';
        search(left, right+1, len+1);
    }
} 
 */
