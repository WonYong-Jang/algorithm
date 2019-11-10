package com.company.leetcode;

/**
 * 844. Backspace String Compare
 */
public class leetcode844 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
}


class Solution844 {
    public boolean backspaceCompare(String S, String T) {
        
        int len1 = S.length();
        int len2 = T.length();
        String ss = "", tt = "";
        StringBuilder sb = new StringBuilder();
        
        int size = 0;
        for(int i=0; i< len1; i++)
        {
            size = sb.length();
            if(S.charAt(i) == '#')
            {
                if(size == 0) continue;
                sb.deleteCharAt(size-1);
            }
            else {
                sb.append(S.charAt(i));
            }
        }
        ss = sb.toString();
        sb = new StringBuilder();
        for(int i=0; i< len2; i++)
        {
            size = sb.length();
            if(T.charAt(i) == '#') {
                if(size == 0) continue;
                sb.deleteCharAt(size-1);
            }
            else {
                sb.append(T.charAt(i));
            }
        }
        tt = sb.toString();
        if(ss.equals(tt)) return true;
        else return false;
    }
}