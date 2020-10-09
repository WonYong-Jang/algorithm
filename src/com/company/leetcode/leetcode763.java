package com.company.leetcode;

public class leetcode763 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }    
}
/**
class Solution {
    public List<Integer> partitionLabels(String S) {
        
        if(S.length() <= 1) return new ArrayList<>();
        
        return solve(S);
        
    }
    public List<Integer> solve(String s) {
        
        List<Integer> answer = new ArrayList<>();
        
        int len = s.length();
        int[] idxArr = new int[26];
        
        for(int i=0; i< len; i++) {
            int idx = s.charAt(i) - 'a';
            
            idxArr[idx] = i;
        }
        
        
        int left = 0, right = 0;
        int sum = 0;
        for(int i=0; i< len; i++) {
            int idx = s.charAt(i) - 'a';
            right = Math.max(right, idxArr[idx]);
            
            if(right == i) {
                sum = right - left + 1;
                answer.add(sum);
                left = right + 1;
            }
        }
        
        return answer;
    }
} 
 */
