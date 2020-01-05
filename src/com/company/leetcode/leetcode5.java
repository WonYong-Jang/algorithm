package com.company.leetcode;

/**
 * 5. Longest Palindromic Substring
 */
public class leetcode5 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub   
    }
}
/**
class Solution {
    public String longestPalindrome(String s) {
        
        int len = s.length();
        if(len == 0) return "";
        String answer = s.substring(0,1);
        
        int maxLen = 1, temp = 1;
        int start = 0, end =0;
        
        for(int i =0; i< len; i++)
        {
            
            // odd
            start = i-1; end = i+1;
            temp = 1;
            while(start >=0 && end <= len-1)
            {
                if(s.charAt(start) == s.charAt(end))
                {
                    temp += 2;
                    if(maxLen < temp) {
                        maxLen = temp;
                        answer = s.substring(start,end+1);
                    }
                    start -= 1;
                    end += 1;
                }
                else break;
            }
            
            // even
            start = i-1; end = i;
            temp = 0;
            while(start >=0 && end <= len-1)
            {
                if(s.charAt(start) == s.charAt(end))
                {
                    temp += 2;
                    if(maxLen < temp) {
                        maxLen = temp;
                        answer = s.substring(start,end+1);
                    }
                    start -= 1;
                    end += 1;
                }
                else break;
            }
        }
        
        
        return answer;
    }
} 
 */
