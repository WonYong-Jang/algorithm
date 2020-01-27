package com.company.leetcode;

public class leetcode784 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        StringBuilder sb = new StringBuilder();
        
    }
    
}
/**
class Solution {
    public int len;
    public List<String> ans = new ArrayList<>();
    public List<String> letterCasePermutation(String S) {
        
        len = S.length();
        
        StringBuilder sb = new StringBuilder(S);
        
        search(0, sb);
        
        return ans;
    }
    public void search(int index, StringBuilder sb )
    {
        if(index >= len) {
            ans.add(sb.toString());
            return;
        }
        
        char ch = sb.charAt(index);
        StringBuilder next = new StringBuilder(sb);
        search(index+1, next);
        
        char nCh = 0;
        if(ch >= 'a' && ch <= 'z')  {
            nCh = (char)(ch - 32);
            next.setCharAt(index, nCh);
            search(index+1, next);
        }
        else if(ch >= 'A' && ch <= 'Z') {
            nCh = (char)(ch + 32);
            next.setCharAt(index, nCh);
            search(index+1, next);
        }
        
        
    }
}
 */
